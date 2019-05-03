package energosoft.rs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import energosoft.rs.modelclasses.Concourse;
import energosoft.rs.services.impl.ConcourseService;

@RestController
public class ConcourseController {
	
	@Autowired
	private ConcourseService concourseService;
	
	@RequestMapping("/Concourses")
	public List<Concourse> getAll() {
		return concourseService.getAllConcourses();
	}
	
	@RequestMapping("/Concourses/{id}")
	public Concourse getConcourse(@PathVariable int id) {
		return concourseService.getConcourse(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/Concourses")
	public void addConcourse(@RequestBody Concourse concourse) {
		concourseService.addConcourse(concourse);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/Concourses/{id}")
	public void updateConcourse(@RequestBody Concourse concourse, @PathVariable int id) {
		concourseService.updateConcourse(concourse, id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/Concourses/{id}")
	public void deleteConcourse(@PathVariable int id) {
		concourseService.deleteConcourse(id);
	}
	
}
