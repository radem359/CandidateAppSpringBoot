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

import energosoft.rs.modelclasses.Concourse;
import energosoft.rs.services.ConcourseServiceInterface;

/**
 * The Class ConcourseController.
 */
@RestController
@RequestMapping("/Concourses")
public class ConcourseController {
	
	/** The concourse service interface. */
	@Autowired
	private ConcourseServiceInterface concourseServiceInterface;
	
	/**
	 * Gets the all.
	 *
	 * @param job the job
	 * @param jobCode the job code
	 * @return the all
	 */
	@GetMapping
	public ResponseEntity<List<Concourse>> getAll(@RequestParam(value = "job", defaultValue = "") String job,
			@RequestParam(value = "jobCode", defaultValue = "") String jobCode) {
		return concourseServiceInterface.findAll(job, jobCode);
	}
	
	/**
	 * Gets the concourse.
	 *
	 * @param id the id
	 * @return the concourse
	 */
	@GetMapping("/{id}")
	public ResponseEntity getConcourse(@PathVariable("id") Integer id) {
		return concourseServiceInterface.findOne(id);
	}
	
	/**
	 * Adds the concourse.
	 *
	 * @param concourse the concourse
	 * @param errors the errors
	 * @return the response entity
	 */
	@PostMapping
	public ResponseEntity addConcourse(@RequestBody Concourse concourse, Errors errors) {
		if(errors.hasErrors())
			return new ResponseEntity(errors.getAllErrors(), HttpStatus.BAD_REQUEST);
		return concourseServiceInterface.create(concourse);
	}
	
	/**
	 * Update concourse.
	 *
	 * @param id the id
	 * @param concourse the concourse
	 * @param errors the errors
	 * @return the response entity
	 */
	@PutMapping("/{id}")
	public ResponseEntity updateConcourse(@PathVariable("id") Integer id, @RequestBody Concourse concourse,
			Errors errors) {
		if(errors.hasErrors())
			return new ResponseEntity(errors.getAllErrors(), HttpStatus.BAD_REQUEST);
		if(concourse.getId() != id)
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		else
			return concourseServiceInterface.update(concourse);
	}
	
	/**
	 * Delete concourse.
	 *
	 * @param id the id
	 */
	@DeleteMapping("/{id}")
	public void deleteConcourse(@PathVariable("id") Integer id) {
		concourseServiceInterface.delete(id);
	}
	
	/**
	 * Gets the concourse candidate.
	 *
	 * @param id the id
	 * @return the concourse candidate
	 */
	@GetMapping("/{id}/Candidates")
	public ResponseEntity getConcourseCandidate(@PathVariable("id") Integer id) {
		return concourseServiceInterface.getConcourseCandidate(id);
	}
	
	/**
	 * Post concourses candidates.
	 *
	 * @param id the id
	 * @param candidates the candidates
	 * @return the response entity
	 */
	@PostMapping("/{id}/Candidates")
	public ResponseEntity postConcoursesCandidates(@PathVariable("id") Integer id, @RequestBody List<Integer> candidates) {
		return concourseServiceInterface.addCandidates(id, candidates);
	}
	
}
