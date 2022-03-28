package fi.projects.teetimebooking.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fi.projects.teetimebooking.domain.Course;
import fi.projects.teetimebooking.domain.CourseRepository;

@RestController
public class CourseController {

	@Autowired
	private CourseRepository courseRepository;
	
	@GetMapping("/courses")
	public List<Course> getCourses() {
		return (List<Course>) courseRepository.findAll();
	}
	
	@GetMapping("/courses/{id}")
	public Optional<Course> getCourseById(@PathVariable Long id) {
		return courseRepository.findById(id);
	}
	
	@PostMapping("/courses")
	public Course saveCourse(@RequestBody Course course) {
		return courseRepository.save(course);
	}
}
