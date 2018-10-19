package com.dictionarydb.service;

import java.util.List;

import com.dictionarydb.entity.Dictionary;

public interface DictionaryService {
	
	Dictionary insert(Dictionary dictionary);

	Dictionary get(int uniqueid);

	Dictionary update(Dictionary dictionary);

	void delete(int uniqueid);

	List<Dictionary> get();
	
	Dictionary save(Dictionary dictionary);
	
	int count();
	
	List<Dictionary> getDictionaryList(int rowCount);
}
