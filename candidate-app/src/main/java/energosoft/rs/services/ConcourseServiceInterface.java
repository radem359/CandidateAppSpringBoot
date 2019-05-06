package energosoft.rs.services;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;

import energosoft.rs.modelclasses.Candidate;
import energosoft.rs.modelclasses.Concourse;

public interface ConcourseServiceInterface {
	
	ResponseEntity<List<Concourse>> findAll(String job, String jobCode);
	
	ResponseEntity<Concourse> findOne(Integer id);
	
	ResponseEntity<Concourse> create(Concourse concourse);
	
	ResponseEntity<Concourse> update(Concourse concourse);
	
	ResponseEntity<Void> delete(Integer id);
	
	ResponseEntity<Set<Candidate>> getConcourseCandidate(Integer concourseId);
	
	ResponseEntity<Concourse> addCandidates(Integer id, List<Integer> candidates);
	
	Set<Candidate> getCandidates(List<Integer> candidates);
	
}
