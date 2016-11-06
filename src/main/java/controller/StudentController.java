package controller;

import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Model.Student;
import service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	StudentService s;
	
	
	@RequestMapping("/all")
	private Hashtable<String, Student> getAll() {
		return s.getAll();
	}
	@RequestMapping("/state/{id}")
	private Hashtable<String, String> getStudentCountByState(@PathVariable("id") String id) {
		return s.getStudentNoByState(id);
	}
	@RequestMapping("/city/{id}")
	private Hashtable<String, String> getStudentCountByCity(@PathVariable("id") String id) {
		return s.getNoByCity(id);
	}
	@RequestMapping("/cityall/{id}")
	private Hashtable<String, Student> getAllByCity(@PathVariable("id") String id) {
		return s.getAllByCity(id);
	}

	@RequestMapping("{id}")
	public Student getStudent(@PathVariable("id") String id) {
		return s.getStudent(id);
	}
}
