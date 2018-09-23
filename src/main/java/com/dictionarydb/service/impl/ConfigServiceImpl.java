package com.dictionarydb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dictionarydb.entity.Config;
import com.dictionarydb.repository.ConfigRepository;
import com.dictionarydb.service.ConfigService;

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
		return configRepository.findById(uniqueid).get();
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
		return configRepository.findAll();
	}

	

}
