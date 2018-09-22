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

import com.dictionarydb.dto.DictionaryDTO;
import com.dictionarydb.dto.FamilyDTO;
import com.dictionarydb.entity.Dictionary;
import com.dictionarydb.entity.Family;
import com.dictionarydb.service.DictionaryService;
import com.dictionarydb.service.FamilyService;
import com.dictionarydb.util.ObjectMapperUtils;

@RestController
@RequestMapping("/families")
@CrossOrigin
public class FamilyController {
	
	@Autowired
	private FamilyService familyService;

	@GetMapping
	public List<FamilyDTO> getFamilyList() {
		List<Family> familyList = familyService.get();
		return ObjectMapperUtils.mapAll(familyList, FamilyDTO.class);
	}

	@GetMapping("/{id}")
	public FamilyDTO getFamily(@PathVariable int id) {
		Family family = familyService.get(id);
		return ObjectMapperUtils.map(family, FamilyDTO.class);
	}

	@PostMapping
	public FamilyDTO insertDictionary(@RequestBody FamilyDTO familyDTO) {
		Family family = new Family();
		if (familyDTO != null) {
			family = ObjectMapperUtils.map(familyDTO, Family.class);
		}
		return ObjectMapperUtils.map(familyService.insert(family), FamilyDTO.class);
	}

	@PutMapping
	public void updateDictionary() {
		// TODO
	}

	@DeleteMapping("/{uniqueid}")
	public int deleteFamily(@PathVariable int uniqueid) {
		familyService.delete(uniqueid);
		return uniqueid;
	}
}
