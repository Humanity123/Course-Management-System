package gUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.DataBase;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class CourseManagementGui extends JFrame {

	private DataBase dataBase=new DataBase();
	private String fileName= "yashCourseManagement";
	private JPanel contentPane;
	private CardLayout cards=new CardLayout(0,0);
	private CreateCourse createCourse=new CreateCourse();
	private JPanel welcomeScreen=new JPanel();
	private ViewPanel viewPanel=new ViewPanel();
	/**
	 * Launch the application.
	 */
	
	public DataBase getDataBase(){
		return dataBase;
	}
	public String getFileName(){
		return fileName;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourseManagementGui frame = new CourseManagementGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CourseManagementGui() {
		dataBase.readFile(fileName);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 550);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dataBase.writeFile(fileName);
			}
		});
		mnFile.add(mntmSave);
		
		JMenuItem mntmSaveAndExit = new JMenuItem("Save and Exit");
		mntmSaveAndExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dataBase.writeFile(fileName);
				System.exit(0);
			}
		});
		mnFile.add(mntmSaveAndExit);
		
		JMenu mnCreate = new JMenu("Create");
		menuBar.add(mnCreate);
		
		JMenuItem mntmCourses = new JMenuItem("Courses");
		mntmCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cards.show(contentPane, "createCourse");
			}
		});
		mnCreate.add(mntmCourses);
		
		JMenu mnView = new JMenu("View/Edit");
		menuBar.add(mnView);
		
		JMenuItem mntmCourses_1 = new JMenuItem("Courses");
		mntmCourses_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewPanel.loadTables();
				cards.show(contentPane, "viewPanel");
			}
		});
		mnView.add(mntmCourses_1);
		
		JMenuItem mntmHomeScreent = new JMenuItem("Home Screen");
		mntmHomeScreent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cards.show(contentPane, "welcomeScreen");
			}
		});
		menuBar.add(mntmHomeScreent);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(cards);
		contentPane.add(welcomeScreen,"welcomeScreen");
		welcomeScreen.setLayout(null);
		
		JLabel lblWelomtToCourse = new JLabel("Welome To Course  System");
		lblWelomtToCourse.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelomtToCourse.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		lblWelomtToCourse.setBounds(0, 0, 490, 400);
		welcomeScreen.add(lblWelomtToCourse);
		contentPane.add(createCourse,"createCourse");
		contentPane.add(viewPanel,"viewPanel");
	}
}
