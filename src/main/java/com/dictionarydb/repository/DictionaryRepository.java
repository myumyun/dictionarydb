package com.dictionarydb.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dictionarydb.entity.Dictionary;

public interface DictionaryRepository extends JpaRepository<Dictionary, Integer> { 
	
	List<Dictionary> findFirst10ByName(String username);
	List<Dictionary> findFirst(Pageable pageRequest);
}
