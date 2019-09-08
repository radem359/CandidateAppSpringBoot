package humaresources.helper.com.services.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import humaresources.helper.com.entities.Candidate;
import humaresources.helper.com.entities.Concourse;
import humaresources.helper.com.repository.CandidateRepository;
import humaresources.helper.com.services.CandidateServiceInterface;

@Service
public class CandidateService implements CandidateServiceInterface {
	
	@Autowired
	private CandidateRepository candidateRepository;
	
	@Autowired
	private ConcourseService concourseService;

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
