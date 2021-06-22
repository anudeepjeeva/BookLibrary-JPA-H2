package com.example.jpalibraryfinal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpalibraryfinal.entities.author;
import com.example.jpalibraryfinal.repositories.authorRepository;

@Service
public class authorService {

	@Autowired
	private authorRepository authorRepository;
	public author createauthor(author author) {
		return authorRepository.save(author);
	}

	public List<author> createauthors(List<author> authors) {
		return authorRepository.saveAll(authors);
	}

	public author getauthorById(long id) {
		return authorRepository.findById(id).orElse(null);
	}

	public List<author> getauthors() {
		return authorRepository.findAll();
	}	
	
	public String deleteauthorById(long id) {
		authorRepository.deleteById(id);
		return "author got deleted";
	}

	

}
