package com.dictionarydb.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dictionarydb.annotation.Logging;
import com.dictionarydb.dto.BotDTO;
import com.dictionarydb.service.BotService;

@Controller
@CrossOrigin
@RequestMapping("/bot")
public class BotController {
	
	@Autowired
	private BotService botService;
	
	@GetMapping("/input")
	@Logging
	public String getInput(BotDTO botDTO) {
		System.out.println(botDTO.toString());
		botService.analyzeInput(botDTO.getInput());
		return "okey";
	}

}
