package com.dictionarydb.service;

import java.util.List;

import com.dictionarydb.entity.Log;

public interface LogService {

	Log insert(Log log);
	
	Log insert(String request, String reponse, String duration);

	List<Log> get();
	
	void deleteAll();
}
