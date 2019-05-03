package energosoft.rs.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import energosoft.rs.modelclasses.Candidate;

public interface CandidateRepository extends CrudRepository<Candidate, Integer> {
	
	List<Candidate> findAllByNameIgnoreCaseContainsAndSurnameIgnoreCaseContains(String name, String surname);
	
}
