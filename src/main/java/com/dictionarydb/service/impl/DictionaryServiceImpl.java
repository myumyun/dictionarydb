package com.dictionarydb.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;
import javax.xml.transform.Source;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dictionarydb.entity.Dictionary;
import com.dictionarydb.entity.DictionaryFilter;
import com.dictionarydb.entity.Family;
import com.dictionarydb.enumaration.DictionaryType;
import com.dictionarydb.enumaration.SourceType;
import com.dictionarydb.enumaration.StatusType;
import com.dictionarydb.repository.DictionaryRepository;
import com.dictionarydb.service.DictionaryService;
import com.dictionarydb.service.FamilyService;
import com.dictionarydb.util.NullAwareBeanUtilsBean;
import com.dictionarydb.util.StringUtils;

@Transactional
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
				throw new Exception(
						"Dictionary is not found for uniquieid: " + uniqueid);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dictionary;
	}

	@Override
	public Dictionary update(Dictionary dictionary) {
		Dictionary dictionaryRead = get(dictionary.getUniqueid());
		BeanUtilsBean notNull = new NullAwareBeanUtilsBean();
		try {
			notNull.copyProperties(dictionaryRead, dictionary);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dictionaryRead.setUpdatedAt(new Date());
		return dictionaryRepository.save(dictionaryRead);
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
			List<Family> familyList = familyService.get();
			if (familyList == null || familyList.size() == 0) {
				familyService.init();
				familyList = familyService.get();
				dictionary.setFamily(familyList.get(0).getName());
			} else {
				dictionary.setFamily(familyList.get(0).getName());
			}
			dictionary.setCreatedAt(new Date());
			dictionary.setUpdatedAt(new Date());
			dictionary.setType(DictionaryType.CODE.name());
			dictionary.setStatus(StatusType.ACTIVE.name());
			saved = insert(dictionary);
		} else {
			saved = update(dictionary);
		}
		return saved;
	}

	@Override
	public int count() {
		return (int) dictionaryRepository.count();
	}

	@Override
	public List<Dictionary> getDictionaryList(int rowCount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dictionary> getDictionaryListWithFilters(
			DictionaryFilter dictionaryFilter) {
		if (dictionaryFilter == null) {
			return dictionaryRepository.findAll();
		} else if (!dictionaryFilter.getTitle().isEmpty()) {
			String nameFilter = "%" + dictionaryFilter.getTitle() + "%";
			return dictionaryRepository.findByNameIsLike(nameFilter);
		}
		return null;
	}

	@Override
	public void generate(int dictionaryCount) {
		int stop = 1000;
		Dictionary dictionary = null;
		if (dictionaryCount != 0) {
			stop = dictionaryCount;
		}
		for (int i = 0; i < stop; i++) {
			dictionary = new Dictionary();
			dictionary.setName(StringUtils.generateString());
			dictionary.setDescription(StringUtils.generateString());
			dictionary.setCreatedAt(new Date());
			dictionary.setUpdatedAt(new Date());
			dictionary.setType(DictionaryType.CODE.name());
			dictionary.setFamily("TEST");
			dictionary.setSource(SourceType.GENERATED.name());
			dictionaryRepository.save(dictionary);
		}

	}

	@Override
	public void deleteAll() {
		dictionaryRepository.deleteAll();
	}
	
	
	@Override
	public void deleteGeneratedDictionaries() {
		dictionaryRepository.deleteBySource(SourceType.GENERATED.name());
	}
}
