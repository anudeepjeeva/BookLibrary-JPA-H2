package com.example.jpalibraryfinal.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpalibraryfinal.entities.book;
import com.example.jpalibraryfinal.repositories.bookRepository;

@Service
public class bookService {

	@Autowired
	private bookRepository bookRepository;
	public book createbook(book book) {
		return bookRepository.save(book);
	}

	public List<book> createbooks(List<book> books) {
		return bookRepository.saveAll(books);
	}

	public book getbookById(long id) {
		return bookRepository.findById(id).orElse(null);
	}

	public List<book> getbooks() {
		return bookRepository.findAll();
	}
	
	
	
	public String deletebookById(long id) {
		bookRepository.deleteById(id);
		return "book got deleted";
	}

}
