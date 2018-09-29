package com.dictionarydb.service.impl;

import java.io.BufferedReader;
import java.io.Reader;
import java.sql.Clob;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Lob;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dictionarydb.entity.Book;
import com.dictionarydb.entity.Dictionary;
import com.dictionarydb.repository.BookRepository;
import com.dictionarydb.service.BookService;
import com.dictionarydb.service.DictionaryService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private DictionaryService dictionaryService;

	@Override
	public Book insert(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Book get(int uniqueid) {
		return bookRepository.findById(uniqueid).get();
	}

	@Override
	public Book update(Book book) {
		return bookRepository.save(book);

	}

	@Override
	public void delete(int uniqueid) {
		bookRepository.deleteById(uniqueid);

	}

	@Override
	public List<Book> get() {
		return bookRepository.findAll();
	}

	@Override
	public void generate() {
		Book book = new Book();
		List<Dictionary> dictionaryList = new ArrayList<>();
		try {
			dictionaryList = dictionaryService.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String document = "";
		for (Dictionary dictionary : dictionaryList) {
			document = document + dictionary.toString();
			document = document + "\n";
		}
		book.setDocument(document);
		bookRepository.save(book);

	}

	private static String getAsString(Clob clob) {
		Reader reader = null;
		BufferedReader bufferedReader = null;
		try {
			reader = clob.getCharacterStream();
			bufferedReader = new BufferedReader(reader);
			return bufferedReader.toString();

		} catch (Exception e) {
			throw new RuntimeException("Error while reading String from CLOB", e);
		} finally {
			IOUtils.closeQuietly(reader);
			IOUtils.closeQuietly(bufferedReader);
		}
	}

}
