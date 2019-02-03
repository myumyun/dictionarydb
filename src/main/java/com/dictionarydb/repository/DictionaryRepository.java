package com.dictionarydb.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dictionarydb.entity.Dictionary;
import java.lang.String;

public interface DictionaryRepository extends JpaRepository<Dictionary, Integer> { 
	List<Dictionary> getDictionariesByNameIsLike(String name);
	List<Dictionary> getDictionariesByCreatedAtIsBetween(Date start, Date stop);
	List<Dictionary> getDictionariesByTags(String tags);
	List<Dictionary> findTop10ByOrderByUniqueidAsc();
	List<Dictionary> findByNameIsLike(String name);	
	Long removeBySource(String source);
	Long deleteBySource(String source);
	
}
