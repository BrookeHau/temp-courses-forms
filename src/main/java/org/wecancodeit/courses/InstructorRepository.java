package org.wecancodeit.courses;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface InstructorRepository extends CrudRepository<Instructor, Long> {

	// when instructor becomes object need to add to repo, transition from
	// instructor being a string to an object, what's within the parameter is
	// what is listed in controller/view
	Instructor findByInstructorName(String instructorName);

	Collection<Course> findByInstructorId(long instructorId);
}
