package Model;

import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

@Table
public class Student {
	
	@PrimaryKeyColumn(ordinal=0)
	String id;
	String name;
	String classStd;
	int percentage;
	String cityId;
	

	@SuppressWarnings("unused")
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(String studentId, String name, String classStd, int percentage, String cityId) {
		this.id = studentId;
		this.name = name;
		this.classStd = classStd;
		this.percentage= percentage;
		this.cityId= cityId;
	}
	
	public String getCityId() {
		return cityId;
	}
	
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String studentId) {
		this.id = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClassStd() {
		return classStd;
	}
	public void setClassStd(String classStd) {
		this.classStd = classStd;
	}
	public int getPercentage() {
		return percentage;
	}
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	
	@Override
	public String toString() {
		return String.format("Student[studentId=%s, name='%s', classStd='%s']", this.id,
				this.name, this.classStd);
	}

	
}
