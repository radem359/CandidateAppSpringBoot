package energosoft.rs.services;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;

import energosoft.rs.modelclasses.Candidate;
import energosoft.rs.modelclasses.Concourse;

public interface CandidateServiceInterface {
	
	ResponseEntity<List<Candidate>> findAll(String name, String surname);
	
	ResponseEntity<Candidate> findOne(Integer id);
	
	ResponseEntity<Candidate> create(Candidate candidate);
	
	ResponseEntity<Candidate> update(Candidate candidate);
	
	ResponseEntity<Void> delete(Integer id);
	
	ResponseEntity<Set<Concourse>> getCandidateConcourses(Integer candidateId);

	//ResponseEntity<Candidate> save(Candidate candidate);
	
}
