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

@RestController
@RequestMapping("/Candidates")
public class CandidateController {
	
	@Autowired
	private CandidateServiceInterface candidateServiceInterface;
	
	/**
	 * Returns a ResponseEntity with the body containing a page of Candidate objects.
	 *
	 * @param name
	 *            If included, will return only candidates whose first name contains
	 *            the value.
	 * @param surname
	 *            If included, will return only candidates whose last name contains
	 *            the value.
	 * @return ResponseEntity with the body containing a page of Candidate objects.
	 * @see Candidate
	 */
	@GetMapping
	public ResponseEntity<List<Candidate>> getAll(@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "surname", defaultValue = "") String surname) {
		return candidateServiceInterface.findAll(name, surname);
	}
	
	/**
	 * Returns a Candidate object based on the given id.
	 *
	 * @param id
	 *            Identifier of the Candidate.
	 * @return ResponseEntity with the body containing the Candidate with the given
	 *         id, or no body.
	 * @see Candidate
	 */
	@GetMapping("/{id}")
	public ResponseEntity getOne(@PathVariable("id") Integer id) {
		return candidateServiceInterface.findOne(id);
	}
	
	/**
	 * Creates a Candidate object.
	 *
	 * @param candidate
	 *            Candidate to be created.
	 * @return ResponseEntity with the body containing the created Candidate or an
	 *         Error object, or no body.
	 * @see Candidate, Error
	 */
	@PostMapping
	public ResponseEntity addCandidate(@RequestBody Candidate candidate, Errors errors) {
		if(errors.hasErrors()) {
			return new ResponseEntity(errors.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		return candidateServiceInterface.create(candidate);
	}
	
	/**
	 * Updates and returns a Candidate object.
	 *
	 * @param id
	 *            identifier of the Candidate to be updated.
	 * @param candidate
	 *            Candidate containing the update information.
	 * @return ResponseEntity with the body containing the updated Candidate object or
	 *         an Error, or no body.
	 * @see Candidate, Error
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
	 * Deletes a Candidate with the given id.
	 *
	 * @param id
	 *            Identifier of the Candidate to be deleted.
	 * @return ResponseEntity with no body.
	 */
	@DeleteMapping("/{id}")
	public void deleteCandidate(@PathVariable("id") Integer id) {
		candidateServiceInterface.delete(id);
	}
	
	/**
	 * Returns a ResponseEntity with the body containing a Set of Concourse objects
	 * for the given Candidate id.
	 *
	 * @param id
	 *            Identifier of the Candidate.
	 *
	 * @return ResponseEntity with the body containing a Set of Concourse objects.
	 * @see Candidate, Concourse
	 */
	@GetMapping("/{id}/Concourses")
	public ResponseEntity getCandidateConcourses(@PathVariable("id") Integer id) {
		return candidateServiceInterface.getCandidateConcourses(id);
	}
	
	/**
	 * Replaces the concourses property of the Candidate object with the given id. The
	 * property will be replaced by a Set of Concourse objects with the given
	 * identifiers.
	 *
	 * @param id
	 *            Identifier of the Candidate.
	 * @param concourses
	 *            List of Integer values, each representing a Concourse id.
	 * 
	 * @return ResponseEntity with the body containing the Candidate object.
	 * @see Concourse, Candidate
	 */
	@PostMapping("/{id}/Concourses")
	public ResponseEntity postCandidateConcourses(@PathVariable("id") Integer id, @RequestBody List<Integer> concourses) {
		return candidateServiceInterface.addConcourses(id, concourses);
	}
	
}
