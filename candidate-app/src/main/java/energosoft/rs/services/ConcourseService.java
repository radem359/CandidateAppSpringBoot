package energosoft.rs.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import energosoft.rs.models.Candidate;
import energosoft.rs.models.Concourse;

@Service
public class ConcourseService {
	
	private List<Concourse> concourses = new ArrayList<Concourse>(Arrays.asList(
			new Concourse(0, "Junior Java Developer", "JJDEV01", new ArrayList<Candidate>()),
			new Concourse(1, "Senior Java Developer", "SJDev01", new ArrayList<Candidate>()),
			new Concourse(2, ".NET Developer", "ASPDev01", new ArrayList<Candidate>())
			));
	
	public List<Concourse> getAllConcourses(){
		return concourses;
	}
	
	public Concourse getConcourse(int id) {
		return concourses.stream().filter(c -> c.getIdConcourse() == id).findFirst().get();
	}
	
	public void addConcourse(Concourse concourse) {
		concourses.add(concourse);
	}

	public void updateConcourse(Concourse concourse, int id) {
		for(int i = 0; i < concourses.size(); i++) {
			Concourse temp = concourses.get(i);
			if(temp.getIdConcourse() == id) {
				concourses.set(i, concourse);
				return;
			}
		}
	}

	public boolean deleteConcourse(int id) {
		concourses.removeIf(c -> c.getIdConcourse() == id);
		return true;
	}
	
}
