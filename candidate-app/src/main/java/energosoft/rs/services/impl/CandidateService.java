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

	@Override
	public ResponseEntity<List<Candidate>> findAll(String name, String surname) {
		List<Candidate> candidates = (List<Candidate>) candidateRepository.findAllByNameIgnoreCaseContainsAndSurnameIgnoreCaseContains(name, surname);
		return new ResponseEntity<>(candidates, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Candidate> findOne(Integer id) {
		Candidate candidate = candidateRepository.findById(id).orElse(null);
		if(candidate != null)
			return new ResponseEntity<>(candidate, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<Candidate> create(Candidate candidate) {
		return new ResponseEntity<Candidate>(candidateRepository.save(candidate), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Candidate> update(Candidate candidate) {
		Candidate candidateTemp = candidateRepository.findById(candidate.getId()).orElse(null);
		if(candidateTemp == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else {
			return new ResponseEntity<Candidate>(candidateRepository.save(candidate), HttpStatus.OK);
		}
	}

	@Override
	public ResponseEntity<Void> delete(Integer id) {
		if(candidateRepository.findById(id) != null) {
			candidateRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<Set<Concourse>> getCandidateConcourses(Integer candidateId) {
		Candidate candidate = candidateRepository.findById(candidateId).orElse(null);
		if(candidate != null)
			return new ResponseEntity<>(candidate.getConcourses(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}
