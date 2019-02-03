package com.dictionarydb.repository.nativeQuery;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

public class DictionaryNativeQuery {
	private final String SQL_SELECT_DICTIONARY_LIST_WITH_FILTERS = "SELECT * FRON dictionaries WHERE title = :title";
	
	//@Autowired
	//private EntityManager em;
	
	//public void getDictionaryListFilters(){
	//	Query q = em.createNativeQuery("SELECT * FROM dictionaries");
		//q.setParameter("username", "test");
		//List t = q.getResultList();
	//}
}
