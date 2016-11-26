package data;

public class Person implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String houseNo;
	private String city;
	private String state;
	private String mobileNumber;
	private String emailAddress;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	public Person(String name, String houseNo, String city, String state, String mobileNumber, String emailAddress) {
		this.name=name;
		this.houseNo=houseNo;
		this.city=city;
		this.state=state;
		this.mobileNumber=mobileNumber;
		this.emailAddress=emailAddress;
	}
	
	public String getName(){
		return this.name;
	}
	public void  setName(String name){
		 this.name=name;
	}
	
	public String getHouseNo(){
		return this.houseNo;
	}
	public void setHouseNo(String houseNo){
		this.houseNo=houseNo;
	}
	
	public String getCity(){
		return this.city;
	}
	public void setCity(String city){
		this.city=city;
	}
	
	public String getState(){
		return this.state;
	}
	public void setState(String state){
		this.state=state;
	}
	
	public String getMobileNumber(){
		return this.mobileNumber;
	}
	public void setMobileNumber(String mobileNumber){
		this.mobileNumber=mobileNumber;
	}
	
	public String getEmailAddress(){
		return this.emailAddress;
	}
	public void setEmailAddress(String emailAddress){
		this.emailAddress=emailAddress;
	}
	protected void getBasicInfo(){
		System.out.println("NAME         : "+name);
		System.out.println("HOUSE-NO     : "+houseNo);
		System.out.println("CITY         : "+city);
		System.out.println("STATE        : "+state);
		System.out.println("MOBILE NUMBER: "+mobileNumber);
		System.out.println("EMAIL        : "+emailAddress);
	}
}
