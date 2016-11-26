package gUI;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class CreateFaculty extends JPanel {
	private JTextField nameTextField;
	private JTextField addressTextField;
	private JTextField mobileTextField;
	private JTextField emailTextField;
	private JTextField departmentTextField;

	/**
	 * Create the panel.
	 */
	public Dimension getPreferredSize() {
        return new Dimension(450, 320);
    }
	public void setNameTextField(String nameTextField) {
		this.nameTextField.setText(nameTextField);
	}
	public void setAddressTextField(String addressTextField) {
		this.addressTextField.setText(addressTextField);
	}
	public void setMobileTextField(String mobileTextField) {
		this.mobileTextField.setText(mobileTextField);
	}
	public void setEmailTextField(String emailTextField) {
		this.emailTextField.setText(emailTextField);
	}
	public void setDepartmentTextField(String departmentTextField) {
		this.departmentTextField.setText(departmentTextField);
	}
	public CreateFaculty() {
		setLayout(null);
		
		JLabel label_1 = new JLabel("Name:");
		label_1.setBounds(38, 45, 100, 16);
		add(label_1);
		
		JLabel label_2 = new JLabel("Address:");
		label_2.setBounds(38, 95, 100, 16);
		add(label_2);
		
		JLabel label_3 = new JLabel("Mobile No:");
		label_3.setBounds(38, 145, 100, 16);
		add(label_3);
		
		JLabel label_4 = new JLabel("Email Address:");
		label_4.setBounds(38, 195, 100, 16);
		add(label_4);
		
		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setBounds(38, 245, 100, 16);
		add(lblDepartment);
		
		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		nameTextField.setBounds(149, 40, 250, 26);
		add(nameTextField);
		
		addressTextField = new JTextField();
		addressTextField.setColumns(10);
		addressTextField.setBounds(149, 90, 250, 26);
		add(addressTextField);
		
		mobileTextField = new JTextField();
		mobileTextField.setColumns(10);
		mobileTextField.setBounds(149, 140, 250, 26);
		add(mobileTextField);
		
		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		emailTextField.setBounds(149, 190, 250, 26);
		add(emailTextField);
		
		departmentTextField = new JTextField();
		departmentTextField.setColumns(10);
		departmentTextField.setBounds(149, 240, 250, 26);
		add(departmentTextField);

	}
	public String getNameTextField() {
		return ""+nameTextField.getText();
	}
	public String getAddressTextField() {
		return ""+addressTextField.getText();
	}
	public String getMobileTextField() {
		return ""+mobileTextField.getText();
	}
	public String getEmailTextField() {
		return ""+emailTextField.getText();
	}
	public String getDepartmentTextField() {
		return ""+departmentTextField.getText();
	}

}
