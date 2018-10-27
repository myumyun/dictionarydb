package com.dictionarydb.service;

import java.util.List;

import com.dictionarydb.entity.Dictionary;
import com.dictionarydb.entity.Family;

public interface FamilyService {
	
	Family insert(Family family);

	Family get(int uniqueid);

	Family update(Family family);

	void delete(int uniqueid);

	List<Family> get();
	
	void init();
}
