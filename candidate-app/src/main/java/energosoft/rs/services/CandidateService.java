package energosoft.rs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import energosoft.rs.modelclasses.Candidate;
import energosoft.rs.repository.CandidateRepository;

@Service
public class CandidateService {
	
	@Autowired
	private CandidateRepository candidateRepository;
	
	public List<Candidate> getAllCandidates() {
		return (List<Candidate>) candidateRepository.findAll();
	}

	public Candidate getCandidate(int id) {
		return candidateRepository.findById(id).orElse(null);
	}

	public void addCandidate(Candidate candidate) {
		candidateRepository.save(candidate);
	}

	public void updateCandidate(Candidate candidate, int id) {
		candidateRepository.save(candidate);
	}

	public void deleteCandidate(int id) {
		candidateRepository.deleteById(id);
	}

	
	
}
