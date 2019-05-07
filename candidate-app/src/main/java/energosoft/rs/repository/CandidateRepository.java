package energosoft.rs.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import energosoft.rs.modelclasses.Candidate;

/**
 * The Interface CandidateRepository.
 */
public interface CandidateRepository extends CrudRepository<Candidate, Integer> {
	
	/**
	 * Find all by name ignore case contains and surname ignore case contains.
	 *
	 * @param name the name
	 * @param surname the surname
	 * @return the list
	 */
	List<Candidate> findAllByNameIgnoreCaseContainsAndSurnameIgnoreCaseContains(String name, String surname);
	
}
