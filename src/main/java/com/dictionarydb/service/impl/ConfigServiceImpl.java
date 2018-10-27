package com.dictionarydb.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dictionarydb.entity.Config;
import com.dictionarydb.repository.ConfigRepository;
import com.dictionarydb.service.ConfigService;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;

@Service
public class ConfigServiceImpl implements ConfigService {

	@Autowired
	private ConfigRepository configRepository;

	@Override
	public Config insert(Config family) {
		return configRepository.save(family);
	}

	@Override
	public Config get(int uniqueid) {
		try{
			return configRepository.findById(uniqueid).get();
		}catch (Exception e) {
			System.out.println("error would be omitted.");
		}
		return null;
	}

	@Override
	public Config update(Config config) {
		return configRepository.save(config);
	}

	@Override
	public void delete(int uniqueid) {
		configRepository.deleteById(uniqueid);
	}

	@Override
	public List<Config> get() {
		List<Config> configList = configRepository.findAll();
		if (configList == null || configList.size() == 0) {
			initializeConfig();
			configList = configRepository.findAll();
		} else {
			validateConfigList(configList);
		}
		return configList;
	}

	private void validateConfigList(List<Config> configList) {
		for (Config config : configList) {
			JsonFactory factory = new JsonFactory();
			try {
				JsonParser parser = factory.createParser(config.getValue());
			} catch (JsonParseException e) {
				System.out.println("initilizing configs since there is parse error.");
				initializeConfig();
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("initilizing configs since there is parse error.");
				initializeConfig();
				e.printStackTrace();
			}
		}
	}

	public void initializeConfig() {

		configRepository.deleteAll();

		Config applicationConfig = new Config();
		applicationConfig.setName("applicationConfig");
		applicationConfig.setValue("{" + "\"dictionaryListRowCount\": 10,"
				+ "\"dictionaryListTitle\": \"Dictionary List\"," + "\"dictionaryListHeaderLabels\":{},"
				+ "\"dictionaryListShowItemCount\":10," + "\"dictionaryListShowPageCount\":5" + "}");

		Config systemConfig = new Config();
		systemConfig.setName("systemConfig");
		systemConfig.setValue("{" + "\"webServiceUrl\":\"http://localhost:8080/api\"" + "}");

		configRepository.save(systemConfig);
		configRepository.save(applicationConfig);
	}

}
