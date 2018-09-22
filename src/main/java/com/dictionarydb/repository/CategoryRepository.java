package com.dictionarydb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dictionarydb.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
