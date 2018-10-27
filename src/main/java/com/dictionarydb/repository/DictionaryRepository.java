package com.dictionarydb.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dictionarydb.entity.Dictionary;

public interface DictionaryRepository extends JpaRepository<Dictionary, Integer> { 
	List<Dictionary> getDictionariesByName(String name);
	List<Dictionary> getDictionariesByCreatedAtIsBetween(Date start, Date stop);
	List<Dictionary> getDictionariesByTags(String tags);
	List<Dictionary> findTop10ByOrderByUniqueidAsc();
}
