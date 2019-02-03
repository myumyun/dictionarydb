package com.dictionarydb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dictionarydb.entity.Log;

public interface LogRepository extends JpaRepository<Log, Integer> {

}
