package com.dictionarydb.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dictionarydb.entity.Dictionary;
import com.dictionarydb.entity.Family;
import com.dictionarydb.enumaration.DictionaryType;
import com.dictionarydb.repository.DictionaryRepository;
import com.dictionarydb.service.DictionaryService;
import com.dictionarydb.service.FamilyService;
import com.dictionarydb.util.NullAwareBeanUtilsBean;
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
		Dictionary dictionaryRead = get(dictionary.getUniqueid());
		BeanUtilsBean notNull=new NullAwareBeanUtilsBean();
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

	@Override
	public int count() {
		return (int) dictionaryRepository.count();
	}

	@Override
	public List<Dictionary> getDictionaryList(int rowCount) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Pageable createPageRequest() {
		return new PageRequest(0, 10);
        //Create a new Pageable object here.
    }
}
