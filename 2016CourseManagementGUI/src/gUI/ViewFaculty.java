package gUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import data.Course;
import data.DataBase;
import data.Faculty;
import data.Participant;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewFaculty extends JPanel {
	DefaultTableModel model=new DefaultTableModel();
	private JTable table=new JTable(model){
		public boolean isCellEditable(int x,int y){
			return false;
		}
	};
	String columns[]=new String[]{"S.no","Name","Address","MobileNo","Email","Department"};
	Course c;
	DataBase database;
	String fileName;

	public Dimension getPreferredSize() {
        return new Dimension(500, 370);
    }
	/**
	 * Create the panel.
	 */
	public ViewFaculty(Course course,DataBase database,String fileName) {
		c=course;
		this.database=database;
		this.fileName=fileName;
		setLayout(null);
		
		JButton button = new JButton("Delete");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index=table.getSelectedRow();
				if(index==-1) return;
				model.removeRow(index);
				c.removeFaculty(index);
				database.writeFile(fileName);
				JOptionPane.showMessageDialog(null, "FACULTY DELETED", "Information", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		button.setBounds(350, 300, 117, 29);
		add(button);
		
		JButton button_1 = new JButton("Add");
		button_1.addActionListener(new ActionListener() {
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
					Faculty faculty=database.createFaculty(name,address,mobileNo,email,department);
					c.addFaculty(faculty);
					database.writeFile(fileName);
					loadTable();
					JOptionPane.showMessageDialog(null, "FACULTY ADDED", "Information", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		button_1.setBounds(25, 300, 117, 29);
		add(button_1);
		
		JButton button_2 = new JButton("Edit");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index=table.getSelectedRow();
				if(index==-1) return;
				ArrayList<Faculty> teacher=c.getFaculty();
				Faculty originalFaculty=teacher.get(index);
				CreateFaculty createFaculty=new CreateFaculty();
				createFaculty.setNameTextField(originalFaculty.getName());
				createFaculty.setDepartmentTextField(originalFaculty.getDepartment());
				createFaculty.setMobileTextField(originalFaculty.getMobileNumber());
				createFaculty.setEmailTextField(originalFaculty.getEmailAddress());
				createFaculty.setAddressTextField(originalFaculty.getHouseNo());
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
					Faculty faculty=database.createFaculty(name,address,mobileNo,email,department);
					teacher.set(index, faculty);
					database.writeFile(fileName);
					loadTable();
					JOptionPane.showMessageDialog(null, "FACULTY CHANGED", "Information", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		button_2.setBounds(185, 300, 117, 29);
		add(button_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 488, 250);
		add(scrollPane);
	
		scrollPane.setViewportView(table);
		for(int i=0;i<6;++i){
			model.addColumn(columns[i]);
		}
		loadTable();
	}
	public void loadTable(){
		while(true){
			try{model.removeRow(0);}
			catch(ArrayIndexOutOfBoundsException e){
				break;
			}
		}
		ArrayList<Faculty> teacher=c.getFaculty();
		for(int i=0;i<teacher.size();++i){
			Faculty p=teacher.get(i);
			model.addRow(new String[]{""+(i+1),p.getName(),p.getHouseNo(),p.getMobileNumber(),p.getEmailAddress(),p.getDepartment()});
		}
	}
}
