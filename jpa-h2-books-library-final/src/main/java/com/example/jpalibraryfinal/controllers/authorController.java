package com.example.jpalibraryfinal.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpalibraryfinal.entities.author;
import com.example.jpalibraryfinal.services.authorService;


@RestController
public class authorController {
	@Autowired
	private authorService authorService;

	@PostMapping("/addnewauthor")
	public author addauthor(@RequestBody author author) {
		return authorService.createauthor(author);
	}

	@PostMapping("/addmultiauthors")
	public List<author> addauthors(@RequestBody List<author> authors) {
		return authorService.createauthors(authors);
	}

	@GetMapping("/getauthorbyID/{id}")
	public author getauthorById(@PathVariable long id) {
		return authorService.getauthorById(id);
	}
	

	@GetMapping("/getallauthors")
	public List<author> getAllauthors() {
		return authorService.getauthors();
	}
	

	@DeleteMapping("/deleteauthor/{id}")
	public String deleteauthor(@PathVariable long id) {
		return authorService.deleteauthorById(id);
	}
}