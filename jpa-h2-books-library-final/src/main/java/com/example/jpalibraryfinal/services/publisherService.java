package com.example.jpalibraryfinal.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpalibraryfinal.entities.publisher;
import com.example.jpalibraryfinal.repositories.publisherRepository;

@Service
public class publisherService {

	@Autowired
	private publisherRepository publisherRepository;
	public publisher createpublisher(publisher publisher) {
		return publisherRepository.save(publisher);
	}

	public List<publisher> createpublishers(List<publisher> publishers) {
		return publisherRepository.saveAll(publishers);
	}

	public publisher getpublisherById(long id) {
		return publisherRepository.findById(id).orElse(null);
	}

	public List<publisher> getpublishers() {
		return publisherRepository.findAll();
	}
	
	
	public String deletepublisherById(long id) {
		publisherRepository.deleteById(id);
		return "publisher got deleted";
	}

}
