package com.dictionarydb.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dictionarydb.dto.CategoryDTO;
import com.dictionarydb.entity.Category;
import com.dictionarydb.service.CategoryService;
import com.dictionarydb.util.ObjectMapperUtils;

@RestController
@RequestMapping("/categories")
@CrossOrigin
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

	@GetMapping("/{uniqueid}")
	public CategoryDTO getCategory(@PathVariable int uniqueid) {
		Category category = categoryService.get(uniqueid);
		return ObjectMapperUtils.map(category, CategoryDTO.class);
	}

	@PostMapping
	public CategoryDTO insertCategory(@RequestBody CategoryDTO categoryDTO) { 
		Category category = new Category();
		if (categoryDTO != null) {
			category = ObjectMapperUtils.map(categoryDTO, Category.class);
		}
		return ObjectMapperUtils.map(categoryService.insert(category), CategoryDTO.class);
	}

	@PutMapping
	public void updateDictionary() {
		// TODO
	}

	@DeleteMapping("/{uniqueid}")
	public int deleteCategory(@PathVariable int uniqueid) {
		categoryService.delete(uniqueid);
		return uniqueid;
	}
	
	@GetMapping
	public List<CategoryDTO> getCategoryList() {
		System.out.println("getCategoryList");
		return ObjectMapperUtils.mapAll(categoryService.get(), CategoryDTO.class);
	}
}
