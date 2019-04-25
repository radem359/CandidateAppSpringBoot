package energosoft.rs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import energosoft.rs.modelclasses.Concourse;
import energosoft.rs.repository.ConcourseRepository;

@Service
public class ConcourseService {
	
	@Autowired
	private ConcourseRepository concourseRepository;
	
	public List<Concourse> getAllConcourses(){
		return (List<Concourse>) concourseRepository.findAll();
	}
	
	public Concourse getConcourse(int id) {
		return concourseRepository.findById(id).orElse(null);
	}
	
	public void addConcourse(Concourse concourse) {
		concourseRepository.save(concourse);
	}

	public void updateConcourse(Concourse concourse, int id) {
		concourseRepository.save(concourse);
	}

	public void deleteConcourse(int id) {
		concourseRepository.deleteById(id);
	}
	
}
