package data;
import java.util.ArrayList;

public class Faculty extends Person implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private String department;
	
	public Faculty() {
		// TODO Auto-generated constructor stu
		
	}
	
	public Faculty(String name, String houseNo, String city, String state, String mobileNumber, String emailAddress, String department){
		new Person(name,houseNo,city,state,mobileNumber,emailAddress);
		this.department=department;
	}
	
	public String getDepartment(){
		return this.department;
	}
	public void setDepartment(String department){
		this.department=department;
	}
}
