package org.wecancodeit.courses;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CoursePopulator implements CommandLineRunner {

	@Resource
	private CourseRepository courseRepo;
	
	@Resource
	private InstructorRepository instRepo;

	@Override
	public void run(String... args) throws Exception {

		Instructor Alan = new Instructor("Alan");
		instRepo.save(Alan);
		Instructor Donny = new Instructor("Donny");
		instRepo.save(Donny);
		Instructor Brian = new Instructor("Brian");
		instRepo.save(Brian);		
		
		Course java = new Course("Java", "Java Description", Alan );
		Course javascript = new Course("Javascript", "Javascript Description", Donny);
		Course spring = new Course("Spring", "Spring Description", Brian);

		courseRepo.save(java);
		courseRepo.save(javascript);
		courseRepo.save(spring);

	}

}
