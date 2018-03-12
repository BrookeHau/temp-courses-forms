package org.wecancodeit.courses;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class MappingTest {

	@Resource
	private TestEntityManager entityManager;

	@Resource
	private CourseRepository courseRepo;

	@Resource
	private InstructorRepository instRepo;

	@Test
	public void getInstructor() {
		Instructor instructor = new Instructor("instructor");
		instructor = instRepo.save(instructor);
		long instId = instructor.getInstructorId();

		entityManager.flush();
		entityManager.clear();

		instructor = instRepo.findOne(instId);
		assertThat(instructor.getInstructorName(), is("instructor"));

	}
	
	@Test
	public void generateCourse() {
		Instructor instructor = new Instructor("instructor");
		instructor = instRepo.save(instructor);
		Course course = new Course("name", "description", instructor);
		course = courseRepo.save(course);
		long courseId = course.getId();

		entityManager.flush();
		entityManager.clear();

		course = courseRepo.findOne(courseId);
		assertThat(course.getDescription(), is("description"));

	}

}
