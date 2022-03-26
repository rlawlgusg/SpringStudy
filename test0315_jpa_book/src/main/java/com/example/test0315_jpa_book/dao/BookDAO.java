package com.example.test0315_jpa_book.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.test0315_jpa_book.vo.Book;

public interface BookDAO extends JpaRepository<Book, Integer> {

}
