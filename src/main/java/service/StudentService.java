package service;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Model.City;
import Model.Student;
import dao.CityRepository;
import dao.StudentRepository;

@Service
public class StudentService {
	
	Hashtable<String, Student> students = new Hashtable<String, Student>();
	
	@Autowired
	private StudentRepository repository;
	@Autowired
	private CityRepository cityRepository;
	
	public Hashtable<String, String> getStudentNoByState(String id) {
		Hashtable<String, String> stuCount = new Hashtable<String, String>();
		stuCount.put("StateId : ", id);
		Integer count =0;
		List<City> cities = cityRepository.findByStateID(id);
		Iterator<City> i = cities.iterator();
		while(i.hasNext()){
			City c = i.next();
			List<Student> s= repository.findByCityId(c.getCityId());
			count+=s.size();
		}
		stuCount.put("Total No : ", count.toString());
		return stuCount;
	}

	public Hashtable<String, String> getNoByCity(String id) {
		Hashtable<String, String> stuCount = new Hashtable<String, String>();
		stuCount.put("CityId : ", id);
		List<Student> s= repository.findByCityId(id);
		Integer i = new Integer(s.size());
		stuCount.put("Total no : ", i.toString());
		return stuCount;
	}

	public Hashtable<String, Student> getAllByCity(String id) {
		Hashtable<String, Student> stutable = new Hashtable<String, Student>();
		List<Student> students = repository.findByCityId(id);
		Iterator<Student> i = students.iterator();
		while(i.hasNext()){
			Student stu = i.next();
			stutable.put(id, stu);
		}
		return stutable;
	}

	
	public StudentService() {        // this function will fetch json/xml data and assign variable to it
		Student s = new Student();
		s.setId("s001");
		s.setName("Rahul");
		s.setClassStd("FIRST STD");
		s.setPercentage(60);
		students.put("s001", s);
		
		s = new Student();
		s.setId("s002");
		s.setName("XYZ");
		s.setClassStd("THIRD STD");
		s.setPercentage(80);
		students.put("s002", s);
		
		s = new Student();
		s.setId("s003");
		s.setName("ABC");
		s.setClassStd("SECOND STD");
		s.setPercentage(90);
		students.put("s003", s);
		
	}
	
	public Student getStudent(String id) {
		System.out.println(id);
		if(students.containsKey(id)){
			System.out.println("if");
			return students.get(id);
		}else{
			System.out.println("else");
			return null;
		}
	}
	
	public Hashtable<String, Student> getAll() {
		return students;
	}

	
}
