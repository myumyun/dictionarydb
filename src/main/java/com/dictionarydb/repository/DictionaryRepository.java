package com.dictionarydb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dictionarydb.entity.Dictionary;

public interface DictionaryRepository extends JpaRepository<Dictionary, Integer> { 
}
