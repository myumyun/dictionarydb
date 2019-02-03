package com.dictionarydb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dictionarydb.entity.Dictionary;
import com.dictionarydb.entity.Family;
import com.dictionarydb.repository.DictionaryRepository;
import com.dictionarydb.repository.FamilyRepository;
import com.dictionarydb.service.DictionaryService;
import com.dictionarydb.service.FamilyService;
import com.dictionarydb.util.TimeUtils;

@Service
public class FamilyServiceImpl implements FamilyService {

	@Autowired
	private FamilyRepository familyRepository;

	@Override
	public Family insert(Family family) {
		return familyRepository.save(family);
	}

	@Override
	public Family get(int uniqueid) {
		Family family = null;
		try {
			family = familyRepository.findById(uniqueid).get();
		} catch (Exception e) {
			System.out.println("there is no family for uniqueid : " + uniqueid);
		}
		return family;
	}

	@Override
	public Family update(Family family) {
		return familyRepository.save(family);
	}

	@Override
	public void delete(int uniqueid) {
		familyRepository.deleteById(uniqueid);
	}

	@Override
	public List<Family> get() {
		return familyRepository.findAll();
	}

	@Override
	public void init() {
		familyRepository.deleteAll();
		Family family = new Family();
		family.setName("Myumyun");
		family.setDescription("AUTHOR");
		family.setCreatedAt(TimeUtils.getCurrentTimestamp());
		family.setUpdatedAt(TimeUtils.getCurrentTimestamp());
		familyRepository.save(family);
	}

}
