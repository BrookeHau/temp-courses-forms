package org.wecancodeit.courses;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Instructor {

	@Id
	@GeneratedValue
	private long instructorId;
	private String instructorName;

	@SuppressWarnings("unused")
	private Instructor() {

	}

	public Instructor(String instructorName) {
		this.instructorName = instructorName;
	}

	@OneToMany(mappedBy = "instructor")
	public Collection<Course> courses;

	public Collection<Course> getCourses() {
		return courses;
	}

	public String getInstructorName() {
		return instructorName;
	}

	public long getInstructorId() {
		return instructorId;
	}
}
