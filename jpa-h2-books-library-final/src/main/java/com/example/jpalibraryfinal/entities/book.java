package com.example.jpalibraryfinal.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class book {

	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    Long id;

	    private String name;
	    
	    private long price;


		@ManyToMany
	    @JoinTable(
	            name = "author_enrolled",
	            joinColumns = @JoinColumn(name = "book_id"),
	            inverseJoinColumns = @JoinColumn(name = "author_id")
	    )
	    Set<author> enrolledauthors = new HashSet<>();
	    
	    @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "publisher_id", referencedColumnName = "id")
	    private publisher publisher;

	    public Long getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		 public long getPrice() {
				return price;
			}

			public void setPrice(long price) {
				this.price = price;
			}

	    public Set<author> getEnrolledauthors() {
	        return enrolledauthors;
	    }

	    public publisher getpublisher() {
	        return publisher;
	    }

	    public void setpublisher(publisher publisher) {
	        this.publisher = publisher;
	    }

		public void enrollAuthor(author author) {
			enrolledauthors.add(author);
		}

	
		public void assignPublisher(publisher publisher) {
			this.publisher=publisher;
		}

	    
}
