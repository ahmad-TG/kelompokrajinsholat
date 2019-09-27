package net.guides.springboot2.springboot2jpacrudexample.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.model.Course;
import net.guides.springboot2.springboot2jpacrudexample.repository.CourseRepository;

@RestController
@RequestMapping("/api/v1")
public class CourseController {
	@Autowired
	private CourseRepository courseRepository;

	@GetMapping("/course")
	public List<Course> getAllCourse() {
		return courseRepository.findAll();
	}

	@GetMapping("/course/{id_course}")
	public ResponseEntity<Course> getCourseById(@PathVariable(value = "id_course") Long courseId)
			throws ResourceNotFoundException {
		Course course = courseRepository.findById(courseId)
				.orElseThrow(() -> new ResourceNotFoundException("matkul tidak ditemukan di id ini sayang:: " + courseId));
		return ResponseEntity.ok().body(course);
	}

	@PostMapping("/course")
	public Course createCourse(@Valid @RequestBody Course course) {
		return courseRepository.save(course);
	}

	@PutMapping("/course/{id_course}")
	public ResponseEntity<Course> updateCourse(@PathVariable(value = "id_course") Long courseId,
			@Valid @RequestBody Course courseDetails) throws ResourceNotFoundException {
		Course course = courseRepository.findById(courseId)
				.orElseThrow(() -> new ResourceNotFoundException("Course GAADA DENGAN ID :: " + courseId));

		course.setNmCourse(courseDetails.getNmCourse());
		course.setjmlSks(courseDetails.getjmlSks());
		course.setIdDosen(courseDetails.getIdDosen());
		course.setSemester(courseDetails.getSemester());
		final Course updatedCourse = courseRepository.save(course);
		return ResponseEntity.ok(updatedCourse);
	}

	@DeleteMapping("/courses/{id}")
	public Map<String, Boolean> deleteCourse(@PathVariable(value = "id") Long courseId)
			throws ResourceNotFoundException {
		Course course = courseRepository.findById(courseId)
				.orElseThrow(() -> new ResourceNotFoundException("Course not found for this id :: " + courseId));

		courseRepository.delete(course);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
