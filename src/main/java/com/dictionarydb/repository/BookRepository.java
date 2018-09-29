package com.dictionarydb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dictionarydb.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
