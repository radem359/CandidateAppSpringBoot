package humaresources.helper.com.services;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;

import humaresources.helper.com.entities.Candidate;
import humaresources.helper.com.entities.Concourse;

public interface CandidateServiceInterface {
	
	ResponseEntity<List<Candidate>> findAll(String name, String surname);
	
	ResponseEntity<Candidate> findOne(Integer id);
	
	ResponseEntity<Candidate> create(Candidate candidate);
	
	ResponseEntity<Candidate> update(Candidate candidate);
	
	ResponseEntity<Void> delete(Integer id);
	
	ResponseEntity<Set<Concourse>> getCandidateConcourses(Integer candidateId);
	
	ResponseEntity<Candidate> addConcourses(Integer id, List<Integer> concourses);
	
	Set<Concourse> getConcourses(List<Integer> concourses);
	
}
