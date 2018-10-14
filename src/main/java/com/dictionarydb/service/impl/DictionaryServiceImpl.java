package com.dictionarydb.service.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dictionarydb.entity.Dictionary;
import com.dictionarydb.entity.Family;
import com.dictionarydb.enumaration.DictionaryType;
import com.dictionarydb.repository.DictionaryRepository;
import com.dictionarydb.service.DictionaryService;
import com.dictionarydb.service.FamilyService;
import com.dictionarydb.util.ObjectMapperUtils;
import com.dictionarydb.util.TimeUtils;

@Service
public class DictionaryServiceImpl implements DictionaryService {

	@Autowired
	private DictionaryRepository dictionaryRepository;
	@Autowired
	private FamilyService familyService;

	@Override
	public Dictionary insert(Dictionary dictionary) {
		return dictionaryRepository.save(dictionary);
	}

	@Override
	public Dictionary get(int uniqueid) {
		Dictionary dictionary = dictionaryRepository.findById(uniqueid).get();
		if (dictionary == null) {
			try {
				throw new Exception("Dictionary is not found for uniquieid: " + uniqueid);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dictionary;
	}

	@Override
	public Dictionary update(Dictionary dictionary) {
		return dictionaryRepository.save(dictionary);

	}

	@Override
	public void delete(int uniqueid) {
		dictionaryRepository.deleteById(uniqueid);
	}

	@Override
	public List<Dictionary> get() {
		return dictionaryRepository.findAll();
	}

	@Override
	public Dictionary save(Dictionary dictionary) {
		Dictionary saved = new Dictionary();
		if (dictionary == null) {
			try {
				throw new Exception("Dictionary cannot be null.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (dictionary.getUniqueid() == 0) {
			// TODO implementation
			// family
			List<Family> familyList = familyService.get();
			Family familyVal;
			if (familyList == null || familyList.size() == 0) {
				Family family = new Family();
				family.setName("Myumyun");
				family.setCreatedAt(TimeUtils.getCurrentTimestamp());
				family.setUpdatedAt(TimeUtils.getCurrentTimestamp());
				family.setDescription("");
				familyVal = familyService.insert(family);
			} else {
				familyVal = familyList.get(0);
			}

			dictionary.setFamilyId(familyVal.getUniqueid());

			// TODO implementation
			// dictionary type
			dictionary.setCreatedAt(new Date());
			dictionary.setUpdatedAt(new Date());
			dictionary.setType(DictionaryType.CODE.name());
			saved = insert(dictionary);
		} else {
			saved = update(dictionary);
		}
		return saved;
	}
}
