package data;
import java.util.ArrayList;

public class Participant extends Person implements java.io.Serializable{
	private  static final long serialVersionUID = 1L;
	private String organisation;
	
	
	
	public Participant() {
		// TODO Auto-generated constructor stub
		
	}
	
	public Participant(String name, String houseNo, String city, String state, String mobileNumber, String emailAddress, String organisation){
		new Person(name, houseNo, city, state, mobileNumber, emailAddress);
		this.organisation=organisation;
	}
	
	public String getOrganisation(){
		return this.organisation;
	}
	public void setOrganisation(String organisation){
		this.organisation=organisation;
	}
	
	public void display(){
		getBasicInfo();
		System.out.println("ORGANISATION : "+organisation+"\n");
	}
}
