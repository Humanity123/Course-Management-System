package gUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import data.Course;
import data.DataBase;
import data.Faculty;
import data.Participant;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.awt.event.ActionEvent;

public class CreateCourse extends JPanel {
	private JTextField nameTextField;
	private JTextField feesTextFiled;
	private JTextField startDateTextField;
	private JTextField durationTextField;
	Course course= new Course();
	/**
	 * Create the panel.
	 */
	public CreateCourse() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CREATE COURSE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		lblNewLabel.setBounds(0, 0, 500, 40);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setBounds(48, 100, 100, 16);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Fees:");
		lblNewLabel_2.setBounds(48, 150, 100, 16);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Start Date:");
		lblNewLabel_3.setBounds(48, 200, 100, 16);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Duration:");
		lblNewLabel_4.setBounds(48, 250, 100, 16);
		add(lblNewLabel_4);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(160, 88, 300, 40);
		add(nameTextField);
		nameTextField.setColumns(10);
		
		feesTextFiled = new JTextField();
		feesTextFiled.setBounds(160, 138, 300, 40);
		add(feesTextFiled);
		feesTextFiled.setColumns(10);
		
		startDateTextField = new JTextField();
		startDateTextField.setBounds(160, 188, 300, 40);
		add(startDateTextField);
		startDateTextField.setColumns(10);
		
		durationTextField = new JTextField();
		durationTextField.setBounds(160, 238, 300, 40);
		add(durationTextField);
		durationTextField.setColumns(10);
		
		JButton createCordinatorButton = new JButton("Create Coordinator");
		createCordinatorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateFaculty createFaculty=new CreateFaculty();
				int value = JOptionPane.showConfirmDialog(getParent(),createFaculty,"CREATE COORDINATOR",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
				if(value==JOptionPane.OK_OPTION){
					String name=createFaculty.getNameTextField();
					String address=createFaculty.getAddressTextField();
					String mobileNo=createFaculty.getMobileTextField();
					String email=createFaculty.getEmailTextField();
					String department=createFaculty.getDepartmentTextField();
					if(name.length()==0||address.length()==0||mobileNo.length()==0||email.length()==0||department.length()==0){
						JOptionPane.showMessageDialog(null, "NO FIELD SHOULD BE EMPTY", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
					CourseManagementGui courseManagementGui=(CourseManagementGui) getParent().getParent().getParent().getParent();
					DataBase database=courseManagementGui.getDataBase();
					Faculty faculty=database.createFaculty(name,address,mobileNo,email,department);
					course.addCoordinator(faculty);
					JOptionPane.showMessageDialog(null, "COORDINATOR ADDED", "Information", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		createCordinatorButton.setBounds(48, 310, 155, 29);
		add(createCordinatorButton);
		
		JButton createFacultyButton = new JButton("Create Faculty");
		createFacultyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateFaculty createFaculty=new CreateFaculty();
				int value = JOptionPane.showConfirmDialog(getParent(),createFaculty,"CREATE FACULTY",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
				if(value==JOptionPane.OK_OPTION){
					String name=createFaculty.getNameTextField();
					String address=createFaculty.getAddressTextField();
					String mobileNo=createFaculty.getMobileTextField();
					String email=createFaculty.getEmailTextField();
					String department=createFaculty.getDepartmentTextField();
					if(name.length()==0||address.length()==0||mobileNo.length()==0||email.length()==0||department.length()==0){
						JOptionPane.showMessageDialog(null, "NO FIELD SHOULD BE EMPTY", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
					if(course.getNumFaculty()>=5){
						JOptionPane.showMessageDialog(null, "5 FACULTIES ARE ALREADY ADDED", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
					CourseManagementGui courseManagementGui=(CourseManagementGui) getParent().getParent().getParent().getParent();
					DataBase database=courseManagementGui.getDataBase();
					Faculty faculty=database.createFaculty(name,address,mobileNo,email,department);
					course.addFaculty(faculty);
					JOptionPane.showMessageDialog(null, "FACULTY ADDED", "Information", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		createFacultyButton.setBounds(48, 360, 155, 29);
		add(createFacultyButton);
		
		JButton createParticipantButton = new JButton("Create Participant");
		createParticipantButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateParticipant createParticipant=new CreateParticipant();
				int value = JOptionPane.showConfirmDialog(getParent(),createParticipant,"CREATE PARTICIPANT",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
				if(value==JOptionPane.OK_OPTION){
					String name=createParticipant.getNameTextField();
					String address=createParticipant.getAddressTextField();
					String mobileNo=createParticipant.getMobileTextField();
					String email=createParticipant.getEmailTextField();
					String organisation=createParticipant.getOrganisationTextField();
					if(name.length()==0||address.length()==0||mobileNo.length()==0||email.length()==0||organisation.length()==0){
						JOptionPane.showMessageDialog(null, "NO FIELD SHOULD BE EMPTY", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
					if(course.getNumParticipant()>=5){
						JOptionPane.showMessageDialog(null, "5 PARTICIPANTS ARE ALREADY ADDED", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
					CourseManagementGui courseManagementGui=(CourseManagementGui) getParent().getParent().getParent().getParent();
					DataBase database=courseManagementGui.getDataBase();
					Participant participant=database.createParticipant(name,address,mobileNo,email,organisation);
					course.addParticipant(participant);
					JOptionPane.showMessageDialog(null, "PARTICIPANT ADDED", "Information", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		createParticipantButton.setBounds(305, 360, 155, 29);
		add(createParticipantButton);
		
		JButton submitButton = new JButton("SUBMIT");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CourseManagementGui courseManagementGui=(CourseManagementGui) getParent().getParent().getParent().getParent();
				DataBase database=courseManagementGui.getDataBase();
				String name=nameTextField.getText();
				String fee=feesTextFiled.getText();
				String startDate=startDateTextField.getText();
				String duration=durationTextField.getText();
				int numError=0;
				if(name.length()==0){
					++numError;
				}
				if(fee.length()==0){
					++numError;
				}
				
				try{
					int intFee=Integer.parseInt(fee);
					if(intFee<0){
						++numError;
					}
				}
				catch(InputMismatchException error){
					++numError;
				}
				catch(NumberFormatException error){
					++numError;
				}
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				Date starDate=null;
				dateFormat.setLenient(false);
				try {
				    starDate = dateFormat.parse(startDate);
				    if(database.numValidCourses(starDate)>10){
						JOptionPane.showMessageDialog(null, "COURSES PER YEAR LIMIT REACHED", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
				} catch (ParseException except) {
						++numError;
				}
				
				if(duration.length()==0){
					++numError;
				}
				
				try{
					int intDuration=Integer.parseInt(duration);
					if(intDuration<0||intDuration>14){
						++numError;
					}
				}
				catch(InputMismatchException error){
					++numError;
				}
				catch(NumberFormatException error){
					++numError;
				}
				
				if(course.isCordinator()==false){
					++numError;
				}
				if(numError>0){
					JOptionPane.showMessageDialog(null, "SOME ERROR IN FORM\nNO FIELD SHOULD BE EMPTY\nFEES AND DURATION SHOULD BE POSITIVE INTEGER\nDURATION SHOULD BE LESS THAN 14\nDAYSDATE FORMAT IS dd/MM/yyyy", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				course.setCourseName(name);
				course.setCourseFee(fee);
				course.setCourseDuration(duration);
				course.setCourseStartDate(starDate);
				database.addCourse(course);
				JOptionPane.showMessageDialog(null, "COURSE ADDED", "Information", JOptionPane.INFORMATION_MESSAGE);
				database.writeFile(courseManagementGui.getFileName());
				inititate();
			}
		});
		submitButton.setBounds(193, 416, 117, 50);
		add(submitButton);

	}
	public void inititate(){
		course=new Course();
		nameTextField.setText(null);
		feesTextFiled.setText(null);
		startDateTextField.setText(null);
		durationTextField.setText(null);
	}
}
	