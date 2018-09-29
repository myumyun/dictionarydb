package com.dictionarydb.service;

import java.util.List;

import com.dictionarydb.entity.Book;

public interface BookService {
	
	Book insert(Book category);

	Book get(int uniqueid);

	Book update(Book category);

	void delete(int uniqueid);

	List<Book> get();
	
	void generate();

}
