package energosoft.rs.services;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;

import energosoft.rs.modelclasses.Candidate;
import energosoft.rs.modelclasses.Concourse;

/**
 * The Interface CandidateServiceInterface.
 */
public interface CandidateServiceInterface {
	
	/**
	 * Find all.
	 *
	 * @param name the name
	 * @param surname the surname
	 * @return the response entity
	 */
	ResponseEntity<List<Candidate>> findAll(String name, String surname);
	
	/**
	 * Find one.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	ResponseEntity<Candidate> findOne(Integer id);
	
	/**
	 * Creates the.
	 *
	 * @param candidate the candidate
	 * @return the response entity
	 */
	ResponseEntity<Candidate> create(Candidate candidate);
	
	/**
	 * Update.
	 *
	 * @param candidate the candidate
	 * @return the response entity
	 */
	ResponseEntity<Candidate> update(Candidate candidate);
	
	/**
	 * Delete.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	ResponseEntity<Void> delete(Integer id);
	
	/**
	 * Gets the candidate concourses.
	 *
	 * @param candidateId the candidate id
	 * @return the candidate concourses
	 */
	ResponseEntity<Set<Concourse>> getCandidateConcourses(Integer candidateId);
	
	/**
	 * Adds the concourses.
	 *
	 * @param id the id
	 * @param concourses the concourses
	 * @return the response entity
	 */
	ResponseEntity<Candidate> addConcourses(Integer id, List<Integer> concourses);
	
	/**
	 * Gets the concourses.
	 *
	 * @param concourses the concourses
	 * @return the concourses
	 */
	Set<Concourse> getConcourses(List<Integer> concourses);
	
}
