package dao;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import Model.City;
import java.lang.String;
import java.util.List;

public interface CityRepository extends CassandraRepository<City>{

	@Query("Select * from city where cityId=?0")
	List<City> findByCityId(String cityid);
	
	@Query("Select * from city where stateID=?0")
	List<City> findByStateID(String stateid);
	
	@Query("Select * from city where cityName=?0")
	List<City> findByCityName(String cityname);
}
