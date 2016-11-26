package data;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class Course implements java.io.Serializable , Comparable<Course>{  
	//TODO  check if ui is there or not if not remove Jpanel at the exception in add participant and instructor
	private  static final long serialVersionUID = 1L;
	private String courseName;
	private String courseFee;
	private Date courseStartDate;
	private String duration;
	private String courseCordinator;
	private Faculty coordinator;
	private ArrayList<Faculty> faculties=new ArrayList<Faculty>();
	private ArrayList<Participant> participants=new ArrayList<Participant>();
	
	public Course(){
	
	}
	public String getCourseName(){
		return this.courseName;
	}
	public  void setCourseName(String newCourseName){
		courseName=newCourseName;
	}
	
	public String getCourseFee(){
		return this.courseFee;
	}
	public void setCourseFee(String newCourseFee){
		this.courseFee=newCourseFee;
	}
	
	public Date getCourseStartDate(){
		return this.courseStartDate;
	}
	public void setCourseStartDate(Date newCourseStartDate){
		this.courseStartDate=newCourseStartDate;
	}
	
	public String getCourseDuration(){
		return this.duration;
	}
	public void setCourseDuration(String newCourseDuration){
		this.duration=newCourseDuration;
	}
	
	public String getCourseCordinator(){
		return this.courseCordinator;
	}
	public void setCourseCordinator(String newCourseCordinator){
		this.courseCordinator=newCourseCordinator;
	} 
	public int getNumFaculty(){
		return faculties.size();
	}
	public int getNumParticipant(){
		return participants.size();
	}
	public boolean isCordinator(){
		return coordinator!=null;
	}
	public void addCoordinator(Faculty coordinator){
		this.coordinator=coordinator;
	}
	public void addFaculty(Faculty faculty){
		faculties.add(faculty);
	}
	public void addParticipant(Participant participant){
		participants.add(participant);
	}
	public Faculty getCordinator(){
		return coordinator;
	}
	public ArrayList<Faculty> getFaculty(){
		return faculties;
	}
	public ArrayList<Participant> getParticipants(){
		return participants;
	}
	@Override
	public int compareTo(Course o) {
		// TODO Auto-generated method stu
		return this.courseStartDate.compareTo(o.getCourseStartDate());
	}
	public void removeParticipant(int index) {
		// TODO Auto-generated method stub
		participants.remove(index);
	}
	public void removeFaculty(int index) {
		// TODO Auto-generated method stub
		faculties.remove(index);
	}
}
