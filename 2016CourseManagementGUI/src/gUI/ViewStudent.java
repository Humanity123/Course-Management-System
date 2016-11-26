package gUI;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import data.Course;
import data.DataBase;
import data.Participant;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

public class ViewStudent extends JPanel {
	DefaultTableModel model=new DefaultTableModel();
	private JTable table=new JTable(model){
		public boolean isCellEditable(int x,int y){
			return false;
		}
	};
	String columns[]=new String[]{"S.no","Name","Address","MobileNo","Email","Organisation"};
	Course c;
	DataBase database;
	String fileName;
	/**
	 * Create the panel.
	 */
	public Dimension getPreferredSize() {
        return new Dimension(500, 370);
    }
	public ViewStudent(Course course,DataBase database,String fileName) {
		this.fileName=fileName;
		c=course;
		this.database=database;
		setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 488, 250);
		add(scrollPane);
		
		for(int i=0;i<6;++i){
			model.addColumn(columns[i]);
		}
		scrollPane.setViewportView(table);
		loadTable();
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index=table.getSelectedRow();
				if(index==-1) return;
				model.removeRow(index);
				c.removeParticipant(index);
				database.writeFile(fileName);
				JOptionPane.showMessageDialog(null, "PARTICIPANT REMOVED", "Information", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton.setBounds(350, 300, 117, 29);
		add(btnNewButton);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
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
					if(c.getNumParticipant()>=5){
						JOptionPane.showMessageDialog(null, "5 PARTICIPANTS ARE ALREADY ADDED", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
					Participant participant=database.createParticipant(name,address,mobileNo,email,organisation);
					c.addParticipant(participant);
					database.writeFile(fileName);
					loadTable();
					JOptionPane.showMessageDialog(null, "PARTICIPANT ADDED", "Information", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnAdd.setBounds(25, 300, 117, 29);
		add(btnAdd);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index=table.getSelectedRow();
				if(index==-1) return;
				ArrayList<Participant> students=c.getParticipants();
				Participant originalParticipant=students.get(index);
				CreateParticipant createParticipant=new CreateParticipant();
				createParticipant.setNameTextField(originalParticipant.getName());
				createParticipant.setMobileTextField(originalParticipant.getMobileNumber());
				createParticipant.setAddressTextField(originalParticipant.getHouseNo());
				createParticipant.setEmailTextField(originalParticipant.getEmailAddress());
				createParticipant.setOrganisationTextField(originalParticipant.getOrganisation());
				int value = JOptionPane.showConfirmDialog(getParent(),createParticipant,"CHANGE PARTICIPANT",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
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
					Participant participant=database.createParticipant(name,address,mobileNo,email,organisation);
					students.set(index, participant);
					database.writeFile(fileName);
					loadTable();
					JOptionPane.showMessageDialog(null, "PARTICIPANT CHANGED", "Information", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnEdit.setBounds(185, 300, 117, 29);
		add(btnEdit);

	}
	public void loadTable(){
		while(true){
			try{model.removeRow(0);}
			catch(ArrayIndexOutOfBoundsException e){
				break;
			}
		}
		ArrayList<Participant> student=c.getParticipants();
		for(int i=0;i<student.size();++i){
			Participant p=student.get(i);
			model.addRow(new String[]{""+(i+1),p.getName(),p.getHouseNo(),p.getMobileNumber(),p.getEmailAddress(),p.getOrganisation()});
		}
	}
}
