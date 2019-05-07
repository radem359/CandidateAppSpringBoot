package energosoft.rs.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import energosoft.rs.modelclasses.Concourse;

/**
 * The Interface ConcourseRepository.
 */
public interface ConcourseRepository extends CrudRepository<Concourse, Integer>{
	
	/**
	 * Find all by job ignore case contains and job code ignore case contains.
	 *
	 * @param job the job
	 * @param jobCode the job code
	 * @return the list
	 */
	List<Concourse> findAllByJobIgnoreCaseContainsAndJobCodeIgnoreCaseContains(String job, String jobCode);
	
}
