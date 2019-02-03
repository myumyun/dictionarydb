package com.dictionarydb.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dictionarydb.entity.Log;
import com.dictionarydb.service.LogService;

@Aspect
@Component
public class LoggingAspect {

	@Autowired
	private LogService logService;

	@Around("@annotation(Logging)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		
		long start = System.currentTimeMillis();
		Object proceed = null;
		Log log = new Log();
		try {
			proceed = joinPoint.proceed();
		} catch (Exception e) {
			log.setStackTrace(e.getStackTrace().toString());
		}

		Object[] args = joinPoint.getArgs();
		System.out.println(args.toString());

		long executionTime = System.currentTimeMillis() - start;

		
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
		System.out.println("className --> "+className);
		System.out.println("methodName --> "+methodName);
		
		if (proceed != null) {
			log.setRequest(args.toString());
			log.setResponse(proceed.toString());
			log.setClassName(className);
			log.setMethodName(methodName);
			log.setDuration(Long.toString(executionTime));
			logService.insert(log);
		} else {
			// do logging here probably passing in (joinPoint, classMethod);
		}

		return proceed;
	}

	// @AfterReturning(value = "@annotation(Logging)", returning = "returnValue")
	// public void loggingRepositoryMethods(JoinPoint joinPoint, Object returnValue)
	// {
	//
	// Object[] args = joinPoint.getArgs();
	// // System.out.println(args.toString());
	// // System.out.println(returnValue.toString());
	//
	// String className = joinPoint.getTarget().getClass().getName();
	// String methodName = joinPoint.getSignature().getName();
	//
	// Log log = new Log();
	// if (returnValue != null) {
	// log.setRequest(args.toString());
	// log.setResponse(returnValue.toString());
	// log.setClassName(className);
	// log.setMethodName(methodName);
	// logService.insert(log);
	// } else {
	// // do logging here probably passing in (joinPoint, classMethod);
	// }
	// }
}
