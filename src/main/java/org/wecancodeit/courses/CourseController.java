package org.wecancodeit.courses;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CourseController {

	@Resource
	CourseRepository courseRepo;

	@Resource
	InstructorRepository instRepo;

	@RequestMapping("/show-courses")
	public String findAllCourses(Model model) {
		model.addAttribute("courses", courseRepo.findAll());
		return "courses";
	}

	@RequestMapping("/course")
	public String findOneCourse(@RequestParam(value = "id") Long id, Model model) {
		model.addAttribute("courses", courseRepo.findOne(id));
		return "course";
	}

	@RequestMapping("/add-course")
	public String addCourse(String courseName, String description, String instructorName) {

		if(courseRepo.findByNameIgnoreCase(courseName) == null) {
			Instructor instructor = instRepo.findByInstructorName(instructorName);
			Course newCourse = new Course(courseName, description, instructor);
			newCourse = courseRepo.save(newCourse);
		} 
		if (instRepo.findByInstructorName(instructorName) == null) {
			Instructor instructor = new Instructor(instructorName);
			instructor = instRepo.save(instructor);
			Course newCourse = new Course(courseName, description, instructor);
			newCourse = courseRepo.save(newCourse);
		}
		return "redirect:/show-courses";
	}

	@RequestMapping("/remove-course") // match request mapping put within courses.html
	public String removeCourse(String removeName) {
		if (courseRepo.findByNameIgnoreCase(removeName) != null) {
			Course removeCourse = courseRepo.findByNameIgnoreCase(removeName);
			removeCourse = courseRepo.save(removeCourse);
			courseRepo.delete(removeCourse);
		}
		return "redirect:/show-courses";
	}

	@RequestMapping("/del-course")
	public String deleteCourseId(Long id) {
		courseRepo.delete(id);
		return "redirect:/show-courses";
	}

	@RequestMapping("/see-courses")
	public String showInstructorCourses(String instructorName, Model model) {
		Instructor instructor = instRepo.findByInstructorName(instructorName);
		model.addAttribute("courses", courseRepo.findByInstructor(instructor));
		return "instructor";
	}

	// how to customize application: through queries as in sort by or find by name
	// etc
	@RequestMapping("/sort-courses")
	public String sortAllCourses(Model model) {
		model.addAttribute("courses", courseRepo.findAllByOrderByNameAsc());
		return "courses";
	}

}
