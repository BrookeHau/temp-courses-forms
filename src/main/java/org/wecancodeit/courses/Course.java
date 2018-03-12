package org.wecancodeit.courses;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Course {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String description;

	
	@ManyToOne
	private Instructor instructor;

	public Instructor getInstructor() {
		return instructor;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}


	public String getDescription() {
		return description;
	}

	protected Course() {

	}

	public Course(String name, String description, Instructor instructor) {
		this.name = name;
		this.description = description;
		this.instructor = instructor;
	}

}
