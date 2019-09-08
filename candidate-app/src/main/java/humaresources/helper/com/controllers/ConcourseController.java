package humaresources.helper.com.controllers;

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

import humaresources.helper.com.entities.Concourse;
import humaresources.helper.com.services.ConcourseServiceInterface;

@RestController
@RequestMapping("/Concourses")
public class ConcourseController {
	
	@Autowired
	private ConcourseServiceInterface concourseServiceInterface;
	
	/**
	 * Returns a ResponseEntity with the body containing a page of Concourse objects.
	 *
	 * @param job
	 *            If included, will return only concourses whose job name contains
	 *            the value.
	 * @param jobCode
	 *            If included, will return only concourses whose job code contains
	 *            the value.
	 * @return ResponseEntity with the body containing a page of Student objects.
	 * @see Concourse
	 */
	@GetMapping
	public ResponseEntity<List<Concourse>> getAll(@RequestParam(value = "job", defaultValue = "") String job,
			@RequestParam(value = "jobCode", defaultValue = "") String jobCode) {
		return concourseServiceInterface.findAll(job, jobCode);
	}
	
	/**
	 * Returns a Concourse object based on the given id.
	 *
	 * @param id
	 *            Identifier of the Concourse.
	 * @return ResponseEntity with the body containing the Concourse with the given
	 *         id, or no body.
	 * @see Concourse
	 */
	@GetMapping("/{id}")
	public ResponseEntity getConcourse(@PathVariable("id") Integer id) {
		return concourseServiceInterface.findOne(id);
	}
	
	/**
	 * Creates a Concourse object.
	 *
	 * @param concourse
	 *            Concourse to be created.
	 * @return ResponseEntity with the body containing the created Concourse or an
	 *         Error object, or no body.
	 * @see Concourse, Error
	 */
	@PostMapping
	public ResponseEntity addConcourse(@RequestBody Concourse concourse, Errors errors) {
		if(errors.hasErrors())
			return new ResponseEntity(errors.getAllErrors(), HttpStatus.BAD_REQUEST);
		return concourseServiceInterface.create(concourse);
	}
	
	/**
	 * Updates and returns a Concourse object.
	 *
	 * @param id
	 *            identifier of the Concourse to be updated.
	 * @param concourse
	 *            Concourse containing the update information.
	 * @return ResponseEntity with the body containing the updated Concourse object or
	 *         an Error, or no body.
	 * @see Concourse, Error
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
	 * Deletes a Concourse with the given id.
	 *
	 * @param id
	 *            Identifier of the Concourse to be deleted.
	 * @return ResponseEntity with no body.
	 */
	@DeleteMapping("/{id}")
	public void deleteConcourse(@PathVariable("id") Integer id) {
		concourseServiceInterface.delete(id);
	}
	
	/**
	 * Returns a ResponseEntity with the body containing a Set of Candidate objects
	 * for the given Concourse id.
	 *
	 * @param id
	 *            Identifier of the Concourse.
	 *
	 * @return ResponseEntity with the body containing a Set of Candidate objects.
	 * @see Concourse, Candidate
	 */
	@GetMapping("/{id}/Candidates")
	public ResponseEntity getConcourseCandidate(@PathVariable("id") Integer id) {
		return concourseServiceInterface.getConcourseCandidate(id);
	}
	
	/**
	 * Replaces the candidates property of the Concourse object with the given id. The
	 * property will be replaced by a Set of Candidate objects with the given
	 * identifiers.
	 *
	 * @param id
	 *            Identifier of the Concourse.
	 * @param candidates
	 *            List of Integer values, each representing a Candidate id.
	 * 
	 * @return ResponseEntity with the body containing the Concourse object.
	 * @see Concourse, Candidate
	 */
	@PostMapping("/{id}/Candidates")
	public ResponseEntity postConcoursesCandidates(@PathVariable("id") Integer id, @RequestBody List<Integer> candidates) {
		return concourseServiceInterface.addCandidates(id, candidates);
	}
	
}
