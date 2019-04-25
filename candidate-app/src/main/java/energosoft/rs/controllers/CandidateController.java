package energosoft.rs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import energosoft.rs.modelclasses.Candidate;
import energosoft.rs.services.CandidateService;

@RestController
public class CandidateController {
	
	@Autowired
	private CandidateService candidateService;
	
	@RequestMapping("/Candidates")
	public List<Candidate> getAll() {
		return candidateService.getAllCandidates();
	}
	
	@RequestMapping("/Candidates/{id}")
	public Candidate getCandidate(@PathVariable int id) {
		return candidateService.getCandidate(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/Candidates")
	public void addCandidate(@RequestBody Candidate candidate) {
		candidateService.addCandidate(candidate);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/Candidates/{id}")
	public void updateCandidate(@RequestBody Candidate candidate, @PathVariable int id) {
		candidateService.updateCandidate(candidate, id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/Candidates/{id}")
	public void deleteCandidate(@PathVariable int id) {
		candidateService.deleteCandidate(id);
	}
	
}
