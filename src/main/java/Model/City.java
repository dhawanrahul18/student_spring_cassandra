package Model;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table
public class City {
	
	@PrimaryKey
	String cityId;
	String cityName;
	String stateID;
	
	public City() {
		// TODO Auto-generated constructor stub
	}
	
	public City(String cityId, String cityName, String stateID) {
		this.cityId = cityId;
		this.cityName=cityName;
		this.stateID = stateID;
	}
	
	
	public String getStateID() {
		return stateID;
	}
	public void setStateID(String stateID) {
		this.stateID = stateID;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	

}
