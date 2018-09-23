package com.dictionarydb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dictionarydb.entity.Config;

public interface ConfigRepository extends JpaRepository<Config, Integer> {
}
