package gUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;
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

public class ViewCourse extends JPanel {
	private JTextField nameTextField;
	private JTextField feesTextFiled;
	private JTextField startDateTextField;
	private JTextField durationTextField;
	/**
	 * Create the panel.
	 */
	public Dimension getPreferredSize() {
        return new Dimension(500, 320);
    }
	public ViewCourse() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VIEW COURSE");
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
		
	}
	public String getNameTextField() {
		return nameTextField.getText();
	}
	public String getFeesTextFiled() {
		return feesTextFiled.getText();
	}
	public String getStartDateTextField() {
		return startDateTextField.getText();
	}
	public String getDurationTextField() {
		return durationTextField.getText();
	}
	public void inititate(Course c){
		nameTextField.setText(c.getCourseName());
		feesTextFiled.setText(c.getCourseFee());
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		startDateTextField.setText(dateFormat.format(c.getCourseStartDate()));
		durationTextField.setText(c.getCourseDuration());
	}
}
	