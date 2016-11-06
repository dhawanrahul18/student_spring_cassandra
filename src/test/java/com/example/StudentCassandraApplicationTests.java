package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

import Model.City;
import Model.State;
import Model.Student;
import dao.CityRepository;
import dao.StateRepository;
import dao.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentCassandraApplicationTests {
	
	@Mock private Cluster mockCluster;
	@Mock private Session mockSession;
	@Mock private StudentRepository repository;
	@Mock private StateRepository staterepository;
	@Mock private CityRepository cityrepository;
	private CassandraSessionFactoryBean factoryBean;

	@Before
	public void setup() {
		when(mockCluster.connect()).thenReturn(mockSession);
		when(mockSession.getCluster()).thenReturn(mockCluster);
		factoryBean.setCluster(mockCluster);
	}

	@Test
	public void saveStudentTest() {
		Student s = this.repository.save(new Student("s001", "Alice", "First Class", 80, "FBD"));
		Student result = repository.findById(s.getId());
		assert(result).equals(s);
	}
	
	@Test
	public void saveStudentNegativeTest() {
		Student s = this.repository.save(new Student("s001", "Alice", "First Class", 80, "FBD"));
		Student result = repository.findById(s.getId());
		assertNotEquals("s004", result.getId());
	}
	
	@Test
	public void saveStateNagativeTest() {
		State s = staterepository.save(new State("HRY", "Haryana"));
		List<State> result = staterepository.findByStateID(s.getStateID());
		assertNotEquals("FBD", result.get(0).getStateID());
	}
	
	@Test
	public void saveStateTest() {
		State s = staterepository.save(new State("HRY", "Haryana"));
		List<State> result = staterepository.findByStateID(s.getStateID());
		assertEquals("HRY", result.get(0).getStateID());
	}
	
	@Test
	public void saveCityTest() {
		City c = cityrepository.save(new City("GGN", "Gurgaon", "HRY"));
		List<City> result = cityrepository.findByCityId(c.getCityId());
		assertEquals("HRY", result.get(0).getStateID());
		assertEquals("GGN", result.get(0).getCityId());
		assertEquals("Gurgaon", result.get(0).getCityName());
	}
	
	@Test
	public void saveCityNegativeTest() {
		City c = cityrepository.save(new City("GGN", "Gurgaon", "HRY"));
		List<City> result = cityrepository.findByCityId(c.getCityId());
		assertNotEquals("ABC", result.get(0).getStateID());
		assertNotEquals("ABC", result.get(0).getCityId());
		assertNotEquals("ABC", result.get(0).getCityName());
	}
	
	

}
