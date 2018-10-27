package com.dictionarydb.service;

import java.util.List;

import com.dictionarydb.entity.Config;

public interface ConfigService {
	
	Config insert(Config config);

	Config get(int uniqueid);

	Config update(Config config);

	void delete(int uniqueid);

	List<Config> get();
	
	void initializeConfig();
}
