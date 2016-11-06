package com.example;


import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;

import Model.Student;
import dao.StudentRepository;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"controller", "service"})
public class StudentCassandraApplication implements CommandLineRunner {
	
	@Autowired
	private StudentRepository repository;
	private static Cluster cluster;
	private static Session session;
	
	@Before
	private void beforeeach() {
		assertNotNull(repository);
		//deleteAllEntities();
	}

	public static void main(String[] args) {

		try {			
			cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
			session = cluster.connect("datasource");
			
			/*//Query
		      String query = "CREATE KEYSPACE student_db WITH replication "
		         + "= {'class':'Student', 'replication_factor':1};";
		      //Executing the query
		      session.execute(query);*/
			CassandraOperations cassandraOps = new CassandraTemplate(session);
			final String[] columns = new String[] { "id", "name" , "classStd", "percentage"};
			Select select = QueryBuilder.select(columns).from("students");
			final List<Student> results = cassandraOps.select(select, Student.class);
			
			System.out.println("Spring Data Cassandra Example");
			for (Student student : results) {
				System.out.println("Student Id is: " + student.getId());
				System.out.println("Student name is: " + student.getName());
				System.out.println("Student standard is: " + student.getClassStd());
				System.out.println("Percantage is: " + student.getPercentage());
				System.out.println("City is :"+student.getCityId());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cluster.close();
		}
	}
	
	@Override
	public void run(String... args) throws Exception {
		this.repository.deleteAll();
		this.repository.save(new Student("s001", "Alice", "First Class", 80, "FBD"));
		this.repository.save(new Student("s002", "Bob", "Second Class", 70, "RHK"));
		this.repository.save(new Student("s003", "Chris", "Third Class", 60, "GGN"));
		this.repository.save(new Student("s004", "Robin", "Fourth Class", 94, "CHD"));
		this.repository.save(new Student("s005", "Bobin", "Second Class", 76, "NDLS"));
	}
}
