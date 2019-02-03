package com.dictionarydb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dictionarydb.entity.Log;
import com.dictionarydb.repository.LogRepository;
import com.dictionarydb.service.LogService;

@Service
public class LogServiceImpl implements LogService {

	@Autowired
	private LogRepository logRepository;

	@Override
	public Log insert(Log log) {
		return logRepository.save(log);
	}

	@Override
	public List<Log> get() {
		return logRepository.findAll();
	}

	@Override
	public Log insert(String request, String response, String duration) {
		Log log = new Log();
		log.setRequest(request);
		log.setResponse(response);
		log.setDuration(duration);
		return logRepository.save(log);
	}

	@Override
	public void deleteAll() {
		logRepository.deleteAll();
	}
}
