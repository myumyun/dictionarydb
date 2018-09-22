package com.dictionarydb.service;

import java.util.List;

import com.dictionarydb.entity.Category;

public interface CategoryService {
	
	Category insert(Category category);

	Category get(int uniqueid);

	Category update(Category category);

	void delete(int uniqueid);

	List<Category> get();

}
