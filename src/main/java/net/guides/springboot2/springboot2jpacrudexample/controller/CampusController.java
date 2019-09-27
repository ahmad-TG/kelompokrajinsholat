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
import net.guides.springboot2.springboot2jpacrudexample.model.Campus;
import net.guides.springboot2.springboot2jpacrudexample.repository.CampusRepository;

@RestController
@RequestMapping("/api/v1")
public class CampusController {
   @Autowired
	private CampusRepository CampusRepository;

	@GetMapping("/Campuss")
	public List<Campus> getAllCampuss() {
		return CampusRepository.findAll();
	}

	@GetMapping("/Campuss/{id}")
	public ResponseEntity<Campus> getCampusById(@PathVariable(value = "id") Long CampusId)
			throws ResourceNotFoundException {
		Campus Campus = CampusRepository.findById(CampusId)
				.orElseThrow(() -> new ResourceNotFoundException("Campus not found for this id :: " + CampusId));
		return ResponseEntity.ok().body(Campus);
	}

	@PostMapping("/Campuss")
	public Campus createCampus(@Valid @RequestBody Campus Campus) {
		return CampusRepository.save(Campus);
	}

	@PutMapping("/Campuss/{id}")
	public ResponseEntity<Campus> updateCampus(@PathVariable(value = "id") Long CampusId,
			@Valid @RequestBody Campus CampusDetails) throws ResourceNotFoundException {
		Campus Campus = CampusRepository.findById(CampusId)
				.orElseThrow(() -> new ResourceNotFoundException("Campus not found for this id :: " + CampusId));

		Campus.setEmailId(CampusDetails.getEmailId());
		Campus.setCampusName(CampusDetails.getCampusName());
		Campus.setRektorName(CampusDetails.getRektorName());
                Campus.setTahunLahir(CampusDetails.getTahunLahir());
		final Campus updatedCampus = CampusRepository.save(Campus);
		return ResponseEntity.ok(updatedCampus);
	}

	@DeleteMapping("/Campuss/{id}")
	public Map<String, Boolean> deleteCampus(@PathVariable(value = "id") Long CampusId)
			throws ResourceNotFoundException {
		Campus Campus = CampusRepository.findById(CampusId)
				.orElseThrow(() -> new ResourceNotFoundException("Campus not found for this id :: " + CampusId));

		CampusRepository.delete(Campus);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	} 
}
