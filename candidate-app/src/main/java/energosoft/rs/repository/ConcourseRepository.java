package energosoft.rs.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import energosoft.rs.modelclasses.Candidate;
import energosoft.rs.modelclasses.Concourse;

public interface ConcourseRepository extends CrudRepository<Concourse, Integer>{
	
	List<Concourse> findAllByJobIgnoreCaseContainsAndJobCodeIgnoreCaseContains(String job, String jobCode);
	
}
