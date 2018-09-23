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
import com.dictionarydb.dto.ConfigDTO;
import com.dictionarydb.entity.Category;
import com.dictionarydb.entity.Config;
import com.dictionarydb.service.CategoryService;
import com.dictionarydb.service.ConfigService;
import com.dictionarydb.util.ObjectMapperUtils;

@RestController
@RequestMapping("/configs")
@CrossOrigin
public class ConfigController {
	
	@Autowired
	private ConfigService configService;

	@GetMapping("/{uniqueid}")
	public ConfigDTO getConfig(@PathVariable int uniqueid) {
		return ObjectMapperUtils.map(configService.get(uniqueid), ConfigDTO.class);
	}

	@PostMapping
	public ConfigDTO insertConfig(@RequestBody ConfigDTO configDTO) { 
		Config config = new Config();
		if (configDTO != null) {
			config = ObjectMapperUtils.map(configDTO, Config.class);
		}
		return ObjectMapperUtils.map(configService.insert(config), ConfigDTO.class);
	}

	@PutMapping(("/{uniqueid}"))
	public void updateDictionary(@RequestBody ConfigDTO configDTO) {
		Config config = null;
		if(configDTO!=null){
			config = ObjectMapperUtils.map(configDTO, Config.class);
		}
		configService.update(config);
	}

	@DeleteMapping("/{uniqueid}")
	public int deleteConfig(@PathVariable int uniqueid) {
		configService.delete(uniqueid);
		return uniqueid;
	}
	
	@GetMapping
	public List<ConfigDTO> getConfigList() {
		return ObjectMapperUtils.mapAll(configService.get(), ConfigDTO.class);
	}
}
