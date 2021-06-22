package com.example.jpalibraryfinal.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class author {
@Id	
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
private String name;
private String description;

@JsonIgnore
@ManyToMany(mappedBy = "enrolledauthors")
private Set<book> books = new HashSet<>();

public long getId() {
	return id;
}

public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public Set<book> getbooks() {
    return books;
}


}