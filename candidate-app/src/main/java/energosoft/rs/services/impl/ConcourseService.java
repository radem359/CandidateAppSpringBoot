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
import energosoft.rs.repository.ConcourseRepository;
import energosoft.rs.services.ConcourseServiceInterface;

/**
 * The Class ConcourseService.
 */
@Service
public class ConcourseService implements ConcourseServiceInterface{
	
	/** The concourse repository. */
	@Autowired
	private ConcourseRepository concourseRepository;
	
	/** The candidate service. */
	@Autowired
	private CandidateService candidateService;

	/**
	 * Find all.
	 *
	 * @param job the job
	 * @param jobCode the job code
	 * @return the response entity
	 */
	@Override
	public ResponseEntity<List<Concourse>> findAll(String job, String jobCode) {
		List<Concourse> concourses = (List<Concourse>)concourseRepository.findAllByJobIgnoreCaseContainsAndJobCodeIgnoreCaseContains(job, jobCode);
		return new ResponseEntity<>(concourses, HttpStatus.OK);
	}

	/**
	 * Find one.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@Override
	public ResponseEntity<Concourse> findOne(Integer id) {
		Concourse concourse = concourseRepository.findById(id).orElse(null);
		if(concourse != null)
			return new ResponseEntity<>(concourse, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	/**
	 * Creates the.
	 *
	 * @param concourse the concourse
	 * @return the response entity
	 */
	@Override
	public ResponseEntity<Concourse> create(Concourse concourse) {
		return new ResponseEntity<Concourse>(concourseRepository.save(concourse), HttpStatus.CREATED);
	}

	/**
	 * Update.
	 *
	 * @param concourse the concourse
	 * @return the response entity
	 */
	@Override
	public ResponseEntity<Concourse> update(Concourse concourse) {
		Concourse concourseTemp = concourseRepository.findById(concourse.getId()).orElse(null);
		if(concourseTemp == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Concourse>(concourseRepository.save(concourse), HttpStatus.OK);
	}

	/**
	 * Delete.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@Override
	public ResponseEntity<Void> delete(Integer id) {
		if(concourseRepository.findById(id) != null) {
			concourseRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Gets the concourse candidate.
	 *
	 * @param concourseId the concourse id
	 * @return the concourse candidate
	 */
	@Override
	public ResponseEntity<Set<Candidate>> getConcourseCandidate(Integer concourseId) {
		Concourse concourse = concourseRepository.findById(concourseId).orElse(null);
		if(concourse != null)
			return new ResponseEntity<>(concourse.getCandidates(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	/**
	 * Adds the candidates.
	 *
	 * @param id the id
	 * @param candidates the candidates
	 * @return the response entity
	 */
	@Override
	public ResponseEntity<Concourse> addCandidates(Integer id, List<Integer> candidates) {
		Concourse concourse = concourseRepository.findById(id).orElse(null);
		if(concourse != null) {
			concourse.getCandidates().forEach(can -> can.getConcourses().remove(concourse));
			concourse.setCandidates(getCandidates(candidates));
			concourse.getCandidates().forEach(can -> can.getConcourses().add(concourse));
			return new ResponseEntity<>(concourseRepository.save(concourse), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Gets the candidates.
	 *
	 * @param candidates the candidates
	 * @return the candidates
	 */
	@Override
	public Set<Candidate> getCandidates(List<Integer> candidates) {
		Set<Candidate> candidatesSet = new HashSet<Candidate>();
		for(Integer c : candidates) {
			Candidate candidate = candidateService.findOne(c).getBody();
			if(candidate != null) {
				candidatesSet.add(candidate);
			}
		}
		return candidatesSet;
	}
	
}
