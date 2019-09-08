package humaresources.helper.com.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import humaresources.helper.com.entities.Candidate;

public interface CandidateRepository extends CrudRepository<Candidate, Integer> {
	
	List<Candidate> findAllByNameIgnoreCaseContainsAndSurnameIgnoreCaseContains(String name, String surname);
	
}
