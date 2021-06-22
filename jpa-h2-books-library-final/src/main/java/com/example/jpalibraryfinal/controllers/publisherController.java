package com.example.jpalibraryfinal.controllers;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpalibraryfinal.entities.publisher;
import com.example.jpalibraryfinal.services.publisherService;


@RestController
public class publisherController {
	@Autowired
	private publisherService publisherService;

	@PostMapping("/addnewpublisher")
	public publisher addpublisher(@RequestBody publisher publisher) {
		return publisherService.createpublisher(publisher);
	}

	@PostMapping("/addmultipublishers")
	public List<publisher> addpublishers(@RequestBody List<publisher> publishers) {
		return publisherService.createpublishers(publishers);
	}

	@GetMapping("/getpublisherbyID/{id}")
	public publisher getpublisherById(@PathVariable long id) {
		return publisherService.getpublisherById(id);
	}

	@GetMapping("/getallpublishers")
	public List<publisher> getAllpublishers() {
		return publisherService.getpublishers();
	}
	

	@DeleteMapping("/deletepublisher/{id}")
	public String deletepublisher(@PathVariable long id) {
		return publisherService.deletepublisherById(id);
	}
}