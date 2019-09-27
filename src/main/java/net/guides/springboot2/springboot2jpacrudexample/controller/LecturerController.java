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
import net.guides.springboot2.springboot2jpacrudexample.model.Lecturer;
import net.guides.springboot2.springboot2jpacrudexample.repository.LecturerRepository;

@RestController
@RequestMapping("/api/v1")
public class LecturerController {
	@Autowired
	private LecturerRepository lecturersRepository;

	@GetMapping("/lecturer")
	public List<Lecturer> getAllLecturer() {
		return lecturersRepository.findAll();
	}

	@GetMapping("/lecturer/{id}")
	public ResponseEntity<Lecturer> getLecturerById(@PathVariable(value = "id") Long lecturerId)
			throws ResourceNotFoundException {
		Lecturer lecturers = lecturersRepository.findById(lecturerId)
				.orElseThrow(() -> new ResourceNotFoundException("Lecturer not found for this id :: " + lecturerId));
		return ResponseEntity.ok().body(lecturers);
	}

	@PostMapping("/lecturer")
	public Lecturer createLecturer(@Valid @RequestBody Lecturer lectures) {
		return lecturersRepository.save(lectures);
	}

	@PutMapping("/lecturer/{id}")
	public ResponseEntity<Lecturer> updateLecturer(@PathVariable(value = "id") Long lecturersId,
			@Valid @RequestBody Lecturer lecturersDetails) throws ResourceNotFoundException {
		Lecturer lecturers = lecturersRepository.findById(lecturersId)
				.orElseThrow(() -> new ResourceNotFoundException("Lecturer not found for this id :: " + lecturersId));

		lecturers.setIdDosen(lecturersDetails.getIdDosen());
		lecturers.setLastName(lecturersDetails.getLastName());
		lecturers.setFirstName(lecturersDetails.getFirstName());
		lecturers.setAlamat(lecturersDetails.getAlamat());
		lecturers.setNoTlp(lecturersDetails.getNoTlp());
		final Lecturer updatedLecturer = lecturersRepository.save(lecturers);
		return ResponseEntity.ok(updatedLecturer);
	}

	@DeleteMapping("/lecturer/{id}")
	public Map<String, Boolean> deleteLecturer(@PathVariable(value = "id") Long lecturersId)
			throws ResourceNotFoundException {
		Lecturer lecturers = lecturersRepository.findById(lecturersId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + lecturersId));

		lecturersRepository.delete(lecturers);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}

