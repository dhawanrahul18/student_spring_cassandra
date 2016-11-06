package Model;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table
public class State {
	
	@PrimaryKey
	String stateID;
	String stateName;
	
	
	public State() {
		// TODO Auto-generated constructor stub
	}
	
	public State(String stateId, String stateName) {
		this.stateID = stateId;
		this.stateName = stateName;
	}
	
	public String getStateID() {
		return stateID;
	}
	public void setStateID(String stateID) {
		this.stateID = stateID;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

}
