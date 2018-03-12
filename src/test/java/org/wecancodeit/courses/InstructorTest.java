package org.wecancodeit.courses;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class InstructorTest {

	@Test 
	public void createInstructor() {
		Instructor instructor = new Instructor("name");
		String check = instructor.getInstructorName();
		assertThat(check, is("name"));
	}
}
