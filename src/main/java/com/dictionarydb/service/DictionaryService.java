package com.dictionarydb.service;

import java.util.List;

import com.dictionarydb.entity.Dictionary;
import com.dictionarydb.entity.DictionaryFilter;

public interface DictionaryService {
	
	Dictionary insert(Dictionary dictionary);

	Dictionary get(int uniqueid);

	Dictionary update(Dictionary dictionary);

	void delete(int uniqueid);

	List<Dictionary> get();
	
	Dictionary save(Dictionary dictionary);
	
	int count();
	
	List<Dictionary> getDictionaryList(int rowCount);
	
	List<Dictionary> getDictionaryListWithFilters(DictionaryFilter dictionaryFilter);
	
	void generate(int dictionaryCount);
	
	void deleteAll();
	
	void deleteGeneratedDictionaries();
}
