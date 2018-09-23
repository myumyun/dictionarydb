package com.dictionarydb.restcontroller;

import java.util.ArrayList;
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
import com.dictionarydb.dto.DictionaryDTO;
import com.dictionarydb.entity.Dictionary;
import com.dictionarydb.service.CategoryService;
import com.dictionarydb.service.DictionaryService;
import com.dictionarydb.util.ObjectMapperUtils;

@RestController
@RequestMapping("/dictionaries")
@CrossOrigin
public class DictionaryController {
	@Autowired
	private DictionaryService dictionaryService;
	@Autowired
	private CategoryService categoryService;
	private final static String[] languages = {"java","C","C++","javascript"};
	
	@GetMapping
	public List<DictionaryDTO> getDictionaryList() {
		List<Dictionary> dictionaryList = dictionaryService.get();
		List<DictionaryDTO> dictionaryDTOList = new ArrayList<>();
		for (Dictionary dictionary : dictionaryList) {
			DictionaryDTO dictionaryDTO = ObjectMapperUtils.map(dictionary, DictionaryDTO.class);
			if (dictionary.getCategoryId() != 0) {
				dictionaryDTO.setCategoryDTO(
						ObjectMapperUtils.map(categoryService.get(dictionary.getCategoryId()), CategoryDTO.class));
			}
			dictionaryDTOList.add(dictionaryDTO);
		}
		return dictionaryDTOList;
	}

	@GetMapping("/{id}")
	public DictionaryDTO getDictionary(@PathVariable int id) {
		Dictionary dictionary = dictionaryService.get(id);
		return ObjectMapperUtils.map(dictionary, DictionaryDTO.class);
	}

	@PostMapping
	public DictionaryDTO createDictionary(@RequestBody DictionaryDTO dictionaryDTO) {
		System.out.println(dictionaryDTO);
		Dictionary dictionary = new Dictionary();
		if (dictionaryDTO != null) {
			dictionary = ObjectMapperUtils.map(dictionaryDTO, Dictionary.class);
		}
		return ObjectMapperUtils.map(dictionaryService.save(dictionary), DictionaryDTO.class);
	}

	@PutMapping
	public void updateDictionary() {
		// TODO
	}

	@DeleteMapping("/{id}")
	public int deleteDictionary(@PathVariable int id) {
		dictionaryService.delete(id);
		return id;
	}
	
	@GetMapping("/languages")
	public String[] getLanguageList() {
		return languages;
	}

	@GetMapping("/ping")
	public String ping() {
		return "pong";
	}
}
