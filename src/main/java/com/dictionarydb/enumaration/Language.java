package com.dictionarydb.enumaration;

import java.util.ArrayList;
import java.util.List;

public enum Language {
	JAVA, JAVASCRIPT, C;
	
	List<String> getLanguageNameList(){
		List<String> languageNameList = new ArrayList<>();
		for (Language language : values()) {
			languageNameList.add(language.name());
		}
		return languageNameList;
	}
};
