package com.example.jpalibraryfinal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpalibraryfinal.entities.author;
import com.example.jpalibraryfinal.entities.book;
import com.example.jpalibraryfinal.entities.publisher;
import com.example.jpalibraryfinal.repositories.authorRepository;
import com.example.jpalibraryfinal.repositories.bookRepository;
import com.example.jpalibraryfinal.repositories.publisherRepository;
import com.example.jpalibraryfinal.services.bookService;



@RestController
public class bookController {
	@Autowired
	private bookService bookService;
	
	@Autowired
	private bookRepository bookRepository;
	
	@Autowired
	private authorRepository authorRepository;
	
	@Autowired
	private publisherRepository publisherRepository;
	

	@PostMapping("/addnewbook")
	public book addbook(@RequestBody book book) {
		return bookService.createbook(book);
	}

	@PostMapping("/addmultibooks")
	public List<book> addbooks(@RequestBody List<book> books) {
		return bookService.createbooks(books);
	}

	@GetMapping("/getbookbyID/{id}")
	public book getbookById(@PathVariable long id) {
		return bookService.getbookById(id);
	}

	@GetMapping("/getallbooks")
	public List<book> getAllbooks() {
		return bookService.getbooks();
	}
	
	@PutMapping("/{bookId}/authors/{authorId}")
	book enrollAuthorToBook(@PathVariable long bookId,
			@PathVariable long authorId) {
		book book =bookRepository.findById(bookId).get();
		author author=authorRepository.findById(authorId).get();
		book.enrollAuthor(author);
		return bookRepository.save(book);
	}
	
	@PutMapping("/{bookId}/publisher/{publisherId}")
	book assignPublisherToBook(@PathVariable long bookId,
			@PathVariable long publisherId) {
		book book =bookRepository.findById(bookId).get();
		publisher publisher=publisherRepository.findById(publisherId).get();
		book.assignPublisher(publisher);
		return bookRepository.save(book);
	}

	@DeleteMapping("/deletebook/{id}")
	public String deletebook(@PathVariable long id) {
		return bookService.deletebookById(id);
	}
}