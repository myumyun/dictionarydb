package com.dictionarydb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dictionarydb.entity.Category;
import com.dictionarydb.repository.CategoryRepository;
import com.dictionarydb.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category insert(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Category get(int uniqueid) {
		return categoryRepository.findById(uniqueid).get();
	}

	@Override
	public Category update(Category category) {
		return categoryRepository.save(category);

	}

	@Override
	public void delete(int uniqueid) {
		categoryRepository.deleteById(uniqueid);

	}

	@Override
	public List<Category> get() {
		return categoryRepository.findAll();
	}

	@Override
	public void deleteAll() {
		categoryRepository.deleteAll();
	}

}
