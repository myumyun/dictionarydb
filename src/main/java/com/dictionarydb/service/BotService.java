package com.dictionarydb.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface BotService {
	List<String> analyzeInput(String input);
}
