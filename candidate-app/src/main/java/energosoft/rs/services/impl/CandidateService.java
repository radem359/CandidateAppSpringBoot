package energosoft.rs.services.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import energosoft.rs.modelclasses.Candidate;
import energosoft.rs.modelclasses.Concourse;
import energosoft.rs.repository.CandidateRepository;
import energosoft.rs.services.CandidateServiceInterface;

@Service
public class CandidateService implements CandidateServiceInterface {
	
	@Autowired
	private CandidateRepository candidateRepository;

	/**
	 * Returns a ResponseEntity with the body containing a page of Candidate objects.
	 *
	 * @param name
	 *            Will return only students whose first name contains the value.
	 * @param surname
	 *            Will return only students whose last name contains the value.
	 *
	 * @return ResponseEntity with the body containing a page of Candidate objects.
	 * @see Candidate
	 */
	@Override
	public ResponseEntity<List<Candidate>> findAll(String name, String surname) {
		List<Candidate> candidates = (List<Candidate>) candidateRepository.findAllByNameIgnoreCaseContainsAndSurnameIgnoreCaseContains(name, surname);
		return new ResponseEntity<>(candidates, HttpStatus.OK);
	}

	/**
	 * Returns a Candidate object based on the given id.
	 *
	 * @param id
	 *            Identifier of the Candidate
	 * @return ResponseEntity with the body containing the Candidate with the given
	 *         id, or no body.
	 * @see Candidate
	 */
	@Override
	public ResponseEntity<Candidate> findOne(Integer id) {
		Candidate candidate = candidateRepository.findById(id).orElse(null);
		if(candidate != null)
			return new ResponseEntity<>(candidate, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	/**
	 * Creates a Candidate object.
	 *
	 * @param candidate
	 *            Candidate to be created.
	 * @return ResponseEntity with the body containing the created Candidate.
	 * @see Candidate
	 */
	@Override
	public ResponseEntity<Candidate> create(Candidate candidate) {
		return new ResponseEntity<Candidate>(candidateRepository.save(candidate), HttpStatus.CREATED);
	}

	/**
	 * Updates an existing Candidate object and returns it.
	 *
	 * @param candidate
	 *            Candidate containing the update information.
	 * @return ResponseEntity with the body containing the updated Candidate object or
	 *         no body.
	 * @see Candidate
	 */
	@Override
	public ResponseEntity<Candidate> update(Candidate candidate) {
		Candidate candidateTemp = candidateRepository.findById(candidate.getId()).orElse(null);
		if(candidateTemp == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else {
			return new ResponseEntity<Candidate>(candidateRepository.save(candidate), HttpStatus.OK);
		}
	}

	/**
	 * Deletes a Candidate with the given id.
	 *
	 * @param id
	 *            identifier of the User to be deleted
	 * @return ResponseEntity with no body.
	 */
	@Override
	public ResponseEntity<Void> delete(Integer id) {
		if(candidateRepository.findById(id) != null) {
			candidateRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Returns a ResponseEntity with the body containing a Set of Concourse objects
	 * for the given Candidate id.
	 *
	 * @param id
	 *            Identifier of the Concourse.
	 *
	 * @return ResponseEntity with the body containing a Set of Concourse objects, or
	 *         no body.
	 * @see Candidate, Concourse
	 */
	@Override
	public ResponseEntity<Set<Concourse>> getCandidateConcourses(Integer candidateId) {
		Candidate candidate = candidateRepository.findById(candidateId).orElse(null);
		if(candidate != null)
			return new ResponseEntity<>(candidate.getConcourses(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}
