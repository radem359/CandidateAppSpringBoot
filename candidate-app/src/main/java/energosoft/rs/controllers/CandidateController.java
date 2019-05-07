package energosoft.rs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import energosoft.rs.modelclasses.Candidate;
import energosoft.rs.services.CandidateServiceInterface;

/**
 * The Class CandidateController.
 */
@RestController
@RequestMapping("/Candidates")
public class CandidateController {
	
	/** The candidate service interface. */
	@Autowired
	private CandidateServiceInterface candidateServiceInterface;
	
	/**
	 * Gets the all.
	 *
	 * @param name the name
	 * @param surname the surname
	 * @return the all
	 */
	@GetMapping
	public ResponseEntity<List<Candidate>> getAll(@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "surname", defaultValue = "") String surname) {
		return candidateServiceInterface.findAll(name, surname);
	}
	
	/**
	 * Gets the one.
	 *
	 * @param id the id
	 * @return the one
	 */
	@GetMapping("/{id}")
	public ResponseEntity getOne(@PathVariable("id") Integer id) {
		return candidateServiceInterface.findOne(id);
	}
	
	/**
	 * Adds the candidate.
	 *
	 * @param candidate the candidate
	 * @param errors the errors
	 * @return the response entity
	 */
	@PostMapping
	public ResponseEntity addCandidate(@RequestBody Candidate candidate, Errors errors) {
		if(errors.hasErrors()) {
			return new ResponseEntity(errors.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		return candidateServiceInterface.create(candidate);
	}
	
	/**
	 * Update candidate.
	 *
	 * @param id the id
	 * @param candidate the candidate
	 * @param errors the errors
	 * @return the response entity
	 */
	@PutMapping("/{id}")
	public ResponseEntity updateCandidate(@PathVariable("id") Integer id, @RequestBody Candidate candidate,
			Errors errors) {
		if(errors.hasErrors())
			return new ResponseEntity(errors.getAllErrors(), HttpStatus.BAD_REQUEST);
		if(candidate.getId() != id)
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		else {
			return candidateServiceInterface.update(candidate);
		}
	}
	
	/**
	 * Delete candidate.
	 *
	 * @param id the id
	 */
	@DeleteMapping("/{id}")
	public void deleteCandidate(@PathVariable("id") Integer id) {
		candidateServiceInterface.delete(id);
	}
	
	/**
	 * Gets the candidate concourses.
	 *
	 * @param id the id
	 * @return the candidate concourses
	 */
	@GetMapping("/{id}/Concourses")
	public ResponseEntity getCandidateConcourses(@PathVariable("id") Integer id) {
		return candidateServiceInterface.getCandidateConcourses(id);
	}
	
	/**
	 * Post candidate concourses.
	 *
	 * @param id the id
	 * @param concourses the concourses
	 * @return the response entity
	 */
	@PostMapping("/{id}/Concourses")
	public ResponseEntity postCandidateConcourses(@PathVariable("id") Integer id, @RequestBody List<Integer> concourses) {
		return candidateServiceInterface.addConcourses(id, concourses);
	}
	
}
