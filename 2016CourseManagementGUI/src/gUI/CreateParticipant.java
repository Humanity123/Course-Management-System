package gUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;

public class CreateParticipant extends JPanel {
	private JTextField nameTextField;
	private JTextField addressTextField;
	private JTextField mobileTextField;
	private JTextField emailTextField;
	private JTextField organisationTextField;

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
	public void setOrganisationTextField(String organisationTextField) {
		this.organisationTextField.setText(organisationTextField);
	}
	public CreateParticipant() {
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setBounds(38, 45, 100, 16);
		add(lblNewLabel_1);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(38, 95, 100, 16);
		add(lblAddress);
		
		JLabel lblMobileNo = new JLabel("Mobile No:");
		lblMobileNo.setBounds(38, 145, 100, 16);
		add(lblMobileNo);
		
		JLabel lblEmailAddress = new JLabel("Email Address:");
		lblEmailAddress.setBounds(38, 195, 100, 16);
		add(lblEmailAddress);
		
		JLabel lblOrganisation = new JLabel("Organisation:");
		lblOrganisation.setBounds(38, 245, 100, 16);
		add(lblOrganisation);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(149, 40, 250, 26);
		add(nameTextField);
		nameTextField.setColumns(10);
		
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
		
		organisationTextField = new JTextField();
		organisationTextField.setColumns(10);
		organisationTextField.setBounds(149, 240, 250, 26);
		add(organisationTextField);

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
	public String getOrganisationTextField() {
		return ""+organisationTextField.getText();
	}
	

}
