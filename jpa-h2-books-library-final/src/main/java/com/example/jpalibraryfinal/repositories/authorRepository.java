package com.example.jpalibraryfinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.jpalibraryfinal.entities.author;


public interface authorRepository extends JpaRepository<author, Long> {
	
} 