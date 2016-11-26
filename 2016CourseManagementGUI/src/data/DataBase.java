package data;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class DataBase implements java.io.Serializable{
	private transient Scanner console=new Scanner(System.in);
	private static final long serialVersionUID = 1L;
	private String fileName;
	private int courseId;
	private int facultyId;
	private int participantId;
	private ArrayList<Course> courses=new ArrayList<Course>();
	public void  setFileName(String fileName){
		this.fileName=fileName;
	}
	public DataBase() {
	}
	@SuppressWarnings("unchecked")
	public DataBase(String FileName) throws FileNotFoundException, ClassNotFoundException{
		DataBase temp;
		try{
			ObjectInputStream is=new ObjectInputStream(new FileInputStream(FileName+"_courses.ser"));
			this.courses=(ArrayList<Course>)is.readObject();
			is.close();
		}catch (FileNotFoundException e){
			throw e;
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "WRONG INPUT FORMAT", "Error", JOptionPane.INFORMATION_MESSAGE);  //may remove
			System.exit(1);
		} catch (ClassNotFoundException e) {
			throw e;
		}
	}
	public void readFile(String FileName){
		DataBase temp;
		try {			
			ObjectInputStream is=new ObjectInputStream(new FileInputStream(FileName+"_courses.ser"));
			this.courses=(ArrayList<Course>)is.readObject();
			is.close();
		}catch (FileNotFoundException e){
	
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "WRONG INPUT FORMAT", "Error", JOptionPane.INFORMATION_MESSAGE);  //may remove
			System.exit(1);
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "CLASS NOT FOUND", "Error", JOptionPane.INFORMATION_MESSAGE);
			System.exit(1);
		}
	}
	public void writeFile(String FileName){
		try {
			ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream(FileName+"_courses.ser"));
			os.writeObject(this.courses);
			os.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int numCourses(){
		return courses.size();
	}
	public Boolean isCourseValid(Date startDate,Date currentDate){
		long diff=currentDate.getYear()-startDate.getYear();
		if(diff<5){
			return true;
		}
		return false;
	}
	public int diffYear(Date currentDate,Date referDate){
		return (currentDate.getYear()-referDate.getYear());
	}
	public int numValidCourses(Date referDate){
		int count=0;
		for(int i=0;i<courses.size();++i){
			if(isCourseValid(courses.get(i).getCourseStartDate(),referDate)){
				++count;
			}
		}
		return count;
	}
	
	public static int getInt(){
		while(true){
			@SuppressWarnings("resource")
			Scanner tempScanner=new Scanner(System.in);
			try{
				String temp=tempScanner.nextLine();
				int input=Integer.parseInt(temp);
				return input;
			}
			catch(InputMismatchException e){
				System.out.println("***INVALID INPUT TYPE: TYPE AN INTEGER");
			}
			catch(NumberFormatException e){
				System.out.println("***INVALID INPUT TYPE: TYPE AN INTEGER");
			}
		}
	}
	public Course getCourse(int index){
		return courses.get(index);
	}
	public void sortCourses(){
		courses.sort(null);
	}
	public ArrayList<Course> getCourses(){
		return courses;
	}
	public void addCourse(Course course){
		courses.add(course);
	}
	public Participant createParticipant(String name,String address,String mobileNo,String email,String organisation){
		Participant participant=new Participant();
		participant.setName(name);
		participant.setHouseNo(address);
		participant.setMobileNumber(mobileNo);
		participant.setEmailAddress(email);
		participant.setOrganisation(organisation);
		return participant;
	}
	public Faculty createFaculty(String name, String address, String mobileNo, String email, String department) {
		// TODO Auto-generated method stub
		Faculty faculty=new Faculty();
		faculty.setName(name);
		faculty.setMobileNumber(mobileNo);
		faculty.setDepartment(department);
		faculty.setEmailAddress(email);
		faculty.setHouseNo(address);
		return faculty;
	}
	public void removeCourse(int index) {
		// TODO Auto-generated method stub
		courses.remove(index);
	}

}
