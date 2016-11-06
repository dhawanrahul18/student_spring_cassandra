package dao;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import Model.State;
import java.lang.String;
import java.util.List;

public interface StateRepository extends CassandraRepository<State>{
	
	@Query("Select * from state where stateID=?0")
	List<State> findByStateID(String stateid);
	
	@Query("Select * from state where stateName=?0")
	List<State> findByStateName(String statename);
	
}
