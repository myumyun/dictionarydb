package com.dictionarydb.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dictionarydb.dto.LogDTO;
import com.dictionarydb.entity.Log;
import com.dictionarydb.service.LogService;
import com.dictionarydb.util.ObjectMapperUtils;

@RestController
@RequestMapping("/logs")
@CrossOrigin
public class LogController {
	@Autowired
	private LogService logService;

	@GetMapping
	public List<LogDTO> getLogList() {
		List<Log> logList = logService.get();
		return ObjectMapperUtils.mapAll(logList, LogDTO.class);
	}
	
	@GetMapping("deleteAll")
	public String deleteAllLogs() {
		logService.deleteAll();
		return "all logs deleted";
	}
	
	
}
