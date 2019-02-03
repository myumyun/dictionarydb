package com.dictionarydb.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dictionarydb.service.CategoryService;
import com.dictionarydb.service.ConfigService;
import com.dictionarydb.service.DashboardService;
import com.dictionarydb.service.DictionaryService;

@Service
@Transactional
public class DashboardServiceImpl implements DashboardService {
	
	@Autowired
	private DictionaryService dictionaryService;
	@Autowired
	private ConfigService configService;
	@Autowired
	private CategoryService categoryService;

	@Override
	public void initializeSystem() {
		dictionaryService.deleteAll();
		configService.initializeConfig();
		categoryService.deleteAll();	
	}

}
