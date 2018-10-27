package com.dictionarydb.restcontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.dictionarydb.dto.DictionaryDTO;
import com.dictionarydb.entity.Dictionary;
import com.dictionarydb.entity.DictionaryFilter;
import com.dictionarydb.service.DictionaryService;
import com.dictionarydb.util.ObjectMapperUtils;

@RestController
@RequestMapping("/dictionaries")
@CrossOrigin
public class DictionaryController {
	@Autowired
	private DictionaryService dictionaryService;

	@GetMapping("/")
	public List<DictionaryDTO> getDictionaryList() {
		List<Dictionary> dictionaryList = dictionaryService.get();
		List<DictionaryDTO> dictionaryDTOList = ObjectMapperUtils.mapAll(dictionaryList, DictionaryDTO.class);
		return dictionaryDTOList;
	}

	@GetMapping
	public List<DictionaryDTO> getDictionaryListFiltered(DictionaryFilter dictionaryFilter) {
		System.out.println(dictionaryFilter.toString());
		List<Dictionary> dictionaryList = dictionaryService.getDictionaryListWithFilters(dictionaryFilter);
		List<DictionaryDTO> dictionaryDTOList = ObjectMapperUtils.mapAll(dictionaryList, DictionaryDTO.class);
		return dictionaryDTOList;
	}

	@GetMapping("/list/{rowCount}")
	public List<DictionaryDTO> getDictionaryListWithFilters(@PathVariable int rowCount) {
		List<Dictionary> dictionaryList = dictionaryService.get();
		List<DictionaryDTO> dictionaryDTOList = ObjectMapperUtils.mapAll(dictionaryList, DictionaryDTO.class);
		return dictionaryDTOList;
	}

	@GetMapping("/{id}")
	public DictionaryDTO getDictionary(@PathVariable int id) {
		Dictionary dictionary = dictionaryService.get(id);
		return ObjectMapperUtils.map(dictionary, DictionaryDTO.class);
	}

	@PostMapping
	public DictionaryDTO createDictionary(@RequestBody DictionaryDTO dictionaryDTO) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				.getRequest();
		String ip = request.getRemoteAddr();
		Dictionary dictionary = new Dictionary();
		if (dictionaryDTO != null) {
			dictionary = ObjectMapperUtils.map(dictionaryDTO, Dictionary.class);
			dictionary.setIp(ip);
		}
		return ObjectMapperUtils.map(dictionaryService.save(dictionary), DictionaryDTO.class);
	}

	@PutMapping
	public DictionaryDTO updateDictionary(@RequestBody DictionaryDTO dictionaryDTO) {
		Dictionary dictionary = new Dictionary();
		if (dictionaryDTO != null) {
			dictionary = ObjectMapperUtils.map(dictionaryDTO, Dictionary.class);
		}
		return ObjectMapperUtils.map(dictionaryService.update(dictionary), DictionaryDTO.class);
	}

	@DeleteMapping("/{id}")
	public int deleteDictionary(@PathVariable int id) {
		dictionaryService.delete(id);
		return id;
	}
	
	@GetMapping("/generate/{count}")
	public ResponseEntity<String> generate(@PathVariable int count) {
		dictionaryService.generate(count);
		return new ResponseEntity<String>("generated.", HttpStatus.OK);
	}

	@GetMapping("/ping")
	public String ping() {
		return "pong";
	}
}
