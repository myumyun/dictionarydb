package com.dictionarydb.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dictionarydb.service.BookService;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin
public class DashboardController {
		
	@Autowired
	private BookService bookService;
	
	@GetMapping
	public String getBookList(){
		return bookService.get().toString();
	}
	
	@GetMapping("/generateBook")
	public void generateBook(){
		bookService.generate();
	}
	
	public String downloadDictionarydbBook(){
		return "";
	}
	
	
	
	
}
