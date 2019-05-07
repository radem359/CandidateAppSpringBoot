package energosoft.rs.services;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;

import energosoft.rs.modelclasses.Candidate;
import energosoft.rs.modelclasses.Concourse;

/**
 * The Interface ConcourseServiceInterface.
 */
public interface ConcourseServiceInterface {
	
	/**
	 * Find all.
	 *
	 * @param job the job
	 * @param jobCode the job code
	 * @return the response entity
	 */
	ResponseEntity<List<Concourse>> findAll(String job, String jobCode);
	
	/**
	 * Find one.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	ResponseEntity<Concourse> findOne(Integer id);
	
	/**
	 * Creates the.
	 *
	 * @param concourse the concourse
	 * @return the response entity
	 */
	ResponseEntity<Concourse> create(Concourse concourse);
	
	/**
	 * Update.
	 *
	 * @param concourse the concourse
	 * @return the response entity
	 */
	ResponseEntity<Concourse> update(Concourse concourse);
	
	/**
	 * Delete.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	ResponseEntity<Void> delete(Integer id);
	
	/**
	 * Gets the concourse candidate.
	 *
	 * @param concourseId the concourse id
	 * @return the concourse candidate
	 */
	ResponseEntity<Set<Candidate>> getConcourseCandidate(Integer concourseId);
	
	/**
	 * Adds the candidates.
	 *
	 * @param id the id
	 * @param candidates the candidates
	 * @return the response entity
	 */
	ResponseEntity<Concourse> addCandidates(Integer id, List<Integer> candidates);
	
	/**
	 * Gets the candidates.
	 *
	 * @param candidates the candidates
	 * @return the candidates
	 */
	Set<Candidate> getCandidates(List<Integer> candidates);
	
}
