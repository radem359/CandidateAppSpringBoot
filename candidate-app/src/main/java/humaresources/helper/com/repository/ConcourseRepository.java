package humaresources.helper.com.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import humaresources.helper.com.entities.Candidate;
import humaresources.helper.com.entities.Concourse;

public interface ConcourseRepository extends CrudRepository<Concourse, Integer>{
	
	List<Concourse> findAllByJobIgnoreCaseContainsAndJobCodeIgnoreCaseContains(String job, String jobCode);
	
}
