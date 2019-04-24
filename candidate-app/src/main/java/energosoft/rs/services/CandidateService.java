package energosoft.rs.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import energosoft.rs.models.Candidate;
import energosoft.rs.models.Concourse;

@Service
public class CandidateService {
	
	private List<Candidate> candidates = new ArrayList<Candidate>(Arrays.asList(
			new Candidate(0, "Nikola", "Mijovic", "0123564789", 1998, "n@gmail.com", "0652035987", new ArrayList<Concourse>(), "", true, "nestonesto"),
			new Candidate(1, "Nemanja", "Maracic", "0123564789", 1989, "n@gmail.com", "063506543654", new ArrayList<Concourse>(), "", false, "nestonesto"),
			new Candidate(2, "Pero", "Perovic", "0123564789", 1956, "n@gmail.com", "066416856825", new ArrayList<Concourse>(), "", true, "nestonesto")
			));
	
	public List<Candidate> getAllCandidates() {
		return candidates;
	}

	public Candidate getCandidate(int id) {
		return candidates.stream().filter(c -> c.getCandidateId() == id).findFirst().get();
	}

	public void addCandidate(Candidate candidate) {
		candidates.add(candidate);
	}

	public void updateCandidate(Candidate candidate, int id) {
		for(int i = 0; i < candidates.size(); i++) {
			Candidate temp = candidates.get(i);
			if(temp.getCandidateId() == id) {
				candidates.set(i, candidate);
				return;
			}
		}
	}

	public boolean deleteCandidate(int id) {
		candidates.removeIf(c -> c.getCandidateId() == id);
		return true;
	}

	
	
}
