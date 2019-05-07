package energosoft.rs.services.impl;

import java.util.HashSet;
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

/**
 * The Class CandidateService.
 */
@Service
public class CandidateService implements CandidateServiceInterface {
	
	/** The candidate repository. */
	@Autowired
	private CandidateRepository candidateRepository;
	
	/** The concourse service. */
	@Autowired
	private ConcourseService concourseService;

	/**
	 * Find all.
	 *
	 * @param name the name
	 * @param surname the surname
	 * @return the response entity
	 */
	@Override
	public ResponseEntity<List<Candidate>> findAll(String name, String surname) {
		List<Candidate> candidates = (List<Candidate>) candidateRepository.findAllByNameIgnoreCaseContainsAndSurnameIgnoreCaseContains(name, surname);
		return new ResponseEntity<>(candidates, HttpStatus.OK);
	}

	/**
	 * Find one.
	 *
	 * @param id the id
	 * @return the response entity
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
	 * Creates the.
	 *
	 * @param candidate the candidate
	 * @return the response entity
	 */
	@Override
	public ResponseEntity<Candidate> create(Candidate candidate) {
		return new ResponseEntity<Candidate>(candidateRepository.save(candidate), HttpStatus.CREATED);
	}

	/**
	 * Update.
	 *
	 * @param candidate the candidate
	 * @return the response entity
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
	 * Delete.
	 *
	 * @param id the id
	 * @return the response entity
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
	 * Gets the candidate concourses.
	 *
	 * @param candidateId the candidate id
	 * @return the candidate concourses
	 */
	@Override
	public ResponseEntity<Set<Concourse>> getCandidateConcourses(Integer candidateId) {
		Candidate candidate = candidateRepository.findById(candidateId).orElse(null);
		if(candidate != null)
			return new ResponseEntity<>(candidate.getConcourses(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	/**
	 * Adds the concourses.
	 *
	 * @param id the id
	 * @param concourses the concourses
	 * @return the response entity
	 */
	@Override
	public ResponseEntity<Candidate> addConcourses(Integer id, List<Integer> concourses) {
		Candidate candidate = candidateRepository.findById(id).orElse(null);
		if(candidate != null) {
			candidate.getConcourses().forEach(con -> con.getCandidates().remove(candidate));
			candidate.setConcourses(getConcourses(concourses));
			candidate.getConcourses().forEach(con -> con.getCandidates().add(candidate));
			return new ResponseEntity<>(candidateRepository.save(candidate), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Gets the concourses.
	 *
	 * @param concourses the concourses
	 * @return the concourses
	 */
	@Override
	public Set<Concourse> getConcourses(List<Integer> concourses) {
		Set<Concourse> concouseSet = new HashSet<Concourse>();
		for(Integer c : concourses) {
			Concourse concourse = concourseService.findOne(c).getBody();
			if(concourse != null) {
				concouseSet.add(concourse);
			}
		}
		return concouseSet;
	}
	
	
	
}
