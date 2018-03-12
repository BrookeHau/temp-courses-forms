package org.wecancodeit.courses;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface InstructorRepository extends CrudRepository<Instructor,Long> {

	Instructor findByInstructorName(String instructorName);
	
	Collection<Course> findByInstructorId(long instructorId);
}
