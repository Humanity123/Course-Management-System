package gUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import data.Course;
import data.DataBase;
import data.Faculty;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class ViewPanel extends JPanel {
	DefaultTableModel model=new DefaultTableModel();
	private JTable table=new JTable(model){
		public boolean isCellEditable(int x,int y){
			return false;
		}
	};
	String columns[]={"S.no","Year","Name","Fees","Start Date","Duration"};

	/**
	 * Create the panel.
	 */
	public ViewPanel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VIEW COURSES");
		lblNewLabel.setBounds(0, 0, 500, 40);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Students");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index=table.getSelectedRow();
				if(index==-1) return ;
				CourseManagementGui  courseManagementGui=(CourseManagementGui) getParent().getParent().getParent().getParent();
				DataBase database=courseManagementGui.getDataBase();
				ArrayList<Course> courses=database.getCourses();
				ViewStudent  viewStudent=new ViewStudent(courses.get(index),database,courseManagementGui.getFileName());
				int value = JOptionPane.showConfirmDialog(getParent(),viewStudent,"STUDENTS",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnNewButton.setBounds(30, 400, 117, 29);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cordinator");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CourseManagementGui  courseManagementGui=(CourseManagementGui) getParent().getParent().getParent().getParent();
				DataBase database=courseManagementGui.getDataBase();
				int index=table.getSelectedRow();
				if(index==-1) return ;
				Course course=database.getCourse(table.getSelectedRow());
				Faculty coordinator=course.getCordinator();
				CreateFaculty createFaculty=new CreateFaculty();
				createFaculty.setNameTextField(coordinator.getName());
				createFaculty.setAddressTextField(coordinator.getHouseNo());
				createFaculty.setEmailTextField(coordinator.getEmailAddress());
				createFaculty.setDepartmentTextField(coordinator.getDepartment());
				createFaculty.setMobileTextField(coordinator.getMobileNumber());
				int value = JOptionPane.showConfirmDialog(getParent(),createFaculty,"COORDINATOR CHANGED",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
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
					Faculty faculty=database.createFaculty(name,address,mobileNo,email,department);
					course.addCoordinator(faculty);
					JOptionPane.showMessageDialog(null, "COORDINATOR IS SET", "Information", JOptionPane.INFORMATION_MESSAGE);
					database.writeFile(courseManagementGui.getFileName());
				}
			}
		});
		btnNewButton_1.setBounds(190, 400, 117, 29);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Faculty");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index=table.getSelectedRow();
				if(index==-1) return ;
				CourseManagementGui  courseManagementGui=(CourseManagementGui) getParent().getParent().getParent().getParent();
				DataBase database=courseManagementGui.getDataBase();
				ArrayList<Course> courses=database.getCourses();
				ViewFaculty viewFaculty=new ViewFaculty(courses.get(index),database,courseManagementGui.getFileName());
				int value = JOptionPane.showConfirmDialog(getParent(),viewFaculty,"FACULTIES",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnNewButton_2.setBounds(350, 400, 117, 29);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Edit Course");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index=table.getSelectedRow();
				if(index==-1) return ;
				CourseManagementGui  courseManagementGui=(CourseManagementGui) getParent().getParent().getParent().getParent();
				DataBase database=courseManagementGui.getDataBase();
				ArrayList<Course> courses=database.getCourses();
				ViewCourse viewCourse=new ViewCourse();
				viewCourse.inititate(courses.get(index));
				int value = JOptionPane.showConfirmDialog(getParent(),viewCourse,"COURSE",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
				if(value==JOptionPane.OK_OPTION){
					String name=viewCourse.getNameTextField();
					String fee=viewCourse.getFeesTextFiled();
					String startDate=viewCourse.getStartDateTextField();
					String duration=viewCourse.getDurationTextField();
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
					
					if(numError>0){
						JOptionPane.showMessageDialog(null, "SOME ERROR IN FORM\nNO FIELD SHOULD BE EMPTY\nFEES AND DURATION SHOULD BE POSITIVE INTEGER\nDURATION SHOULD BE LESS THAN 14\nDAYSDATE FORMAT IS dd/MM/yyyy", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
					Course course=courses.get(index);
					course.setCourseName(name);
					course.setCourseFee(fee);
					course.setCourseDuration(duration);
					course.setCourseStartDate(starDate);
					JOptionPane.showMessageDialog(null, "COURSE CHANGED", "Information", JOptionPane.INFORMATION_MESSAGE);
					database.writeFile(courseManagementGui.getFileName());
					loadTables();
				}
			}
		});
		btnNewButton_3.setBounds(190, 456, 117, 29);
		add(btnNewButton_3);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CourseManagementGui  courseManagementGui=(CourseManagementGui) getParent().getParent().getParent().getParent();
				DataBase database=courseManagementGui.getDataBase();
				int index=table.getSelectedRow();
				if(index==-1) return ;
				database.removeCourse(table.getSelectedRow());
				database.writeFile(courseManagementGui.getFileName());
				loadTables();
			}
		});
		btnDelete.setBounds(190, 352, 117, 29);
		add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 70, 440, 247);
		add(scrollPane);
		
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		for(int i=0;i<6;++i){
			model.addColumn(columns[i]);
		}
		scrollPane.setViewportView(table);
	}
	public void loadTables(){
		while(true){
			try{model.removeRow(0);}
			catch (ArrayIndexOutOfBoundsException e){
				break;
			}
		}
		CourseManagementGui  courseManagementGui=(CourseManagementGui) getParent().getParent().getParent().getParent();
		DataBase dataBase=courseManagementGui.getDataBase();
		dataBase.sortCourses();
		ArrayList<Course> courses=dataBase.getCourses();
		String isValid;
		for(int i=0;i<courses.size();++i){
			Course c=courses.get(i);
			if(dataBase.isCourseValid(c.getCourseStartDate(), new Date())){
				isValid=(1900+c.getCourseStartDate().getYear())+"";
			}else{
				isValid="Invalid";
			}
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			model.addRow(new String[]{""+(i+1),isValid,c.getCourseName(),c.getCourseFee(),dateFormat.format(c.getCourseStartDate()),c.getCourseDuration()});
		}
		
	}
}
