package dao;


import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import Model.Student;
import java.lang.String;


public interface StudentRepository extends CassandraRepository<Student>{


		@Query("Select * from student where studentId=?0")
		public Student findById(String id);
		
		@Query("Select * from student where cityId=?0")
		List<Student> findByCityId(String cityid);
		


}
