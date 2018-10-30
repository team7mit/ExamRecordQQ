package gui;

import javax.swing.*;

/*
 The following statements are written by Hein Htet Thura on 22 October 2018
 The following class contains components for further uses.
 */
public class dataentry extends JFrame {
	public String ss;
	public JLabel schoolname=new JLabel("Mandalay Technological University",SwingConstants.CENTER);
	
	//public JLabel ceit=new JLabel("Computer Engineering & Information Technology",SwingConstants.CENTER);
	//public JLabel academic=new JLabel(ss+" Academic Year");
	public JLabel coding=new JLabel("Coding Marks");
	public JLabel sturesult=new JLabel("Student Result");
	public JLabel tutoandpra=new JLabel("Tutorial and Pratical Marks");
	
	public static String DeptID[]={"CE","Arch","Mech","CEIT","EC","EP","MC","Ch.E","Mining","Nuclear","Biotech"};
	public static String DeptName[]={"Civil Engineering",
									"Architecture",
									"Mechanical Engineering",
									"Computer Engineering and Information Technology",
									"Electrical and Electronic Engineering",
									"Electrical Power Engineering",
									"Mechatronic Engineering",
									"Chemical Engineering",
									"Mining Engineering",
									"Nuclearing Engineering",
									"BioTechnology"	
									};
	
	public static String Course[]={"First Year","Second Year","Third Year","Fourth Year","Fifth Year","Sixth Year","Master","Ph.D"};
	public static String academicyear[]=new String[10];
	 //
	JTable table=new JTable();
	//Panels
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JPanel p3=new JPanel();
	//Labels
	JLabel stunamelabel = new JLabel("Student Name");
	JLabel rollnolabel  = new JLabel("Roll No");
	JLabel stuidlabel   = new JLabel("Student ID");
	JLabel deptidlabel  = new JLabel("Department");
	JLabel courselabel  = new JLabel("Course");
	JLabel acayearlabel      = new JLabel("Academic Year");
	JLabel subcodelabel=new JLabel("Subject Code");
	JLabel firstsemester=new JLabel("First Semester");
	JLabel secondsemester=new JLabel("Second Semester");
	JLabel subjectnamelabel=new JLabel("Subject Name");
	
	//RadioButton
	JRadioButton radiofirst  = new JRadioButton("First Semester");
	JRadioButton radiosecond = new JRadioButton("Second Semester");
	JRadioButton deptsub=new JRadioButton("Insert marks");
	JRadioButton student= new JRadioButton("View marks");
	JRadioButton search=new JRadioButton("Search Marks By Student");
	ButtonGroup button      = new ButtonGroup();
	
	
	//TextField
	JTextField stuidfield = new JTextField(20);
	JTextField stunamefield =new JTextField(20);
	JTextField rollnofield =new JTextField(20);
	JTextField deptidfield=new JTextField(20);
	JTextField subcodefield=new JTextField(20);
	
	//ComboBox
	JComboBox coursefield=new JComboBox(Course);
	JComboBox academicfield=new JComboBox(academicyear);

	//Button
	JButton cancel=new JButton("CANCEL");
	JButton next=new JButton("NEXT");
	JButton back=new JButton("BACK");
	JButton exit=new JButton("EXIT");
	JButton save=new JButton("SAVE");
	JButton update=new JButton("UPDATE");
	
	JCheckBox tutobox=new JCheckBox("Tutorial & Practical");
	JCheckBox exambox=new JCheckBox("Semester Examination");
	
	JScrollPane jsp;
	
	//insert academic year (eg..(2012-2013))
	protected static void academiccreation(){
		int first=2012;
		int second=2013;
		for(int i=0;i<10;i++){
			academicyear[i]=String.valueOf(first++)+" - "+String.valueOf(second++);
		}
	}
	public dataentry(){
		

		button.add(radiofirst);
		button.add(radiosecond);
		
		button.add(deptsub);
		button.add(student);
		button.add(search);
		
		coursefield.setMaximumRowCount(5);
		academicfield.setMaximumRowCount(5);
		
		stunamefield.setText("Auto Generated");
		//rollnofield.setText("Auto Generated");
		deptidfield.setText("Auto Generated");
		stunamefield.setEditable(false);
		//rollnofield.setEditable(false);
		deptidfield.setEditable(false);
		academiccreation();
		
	}
	
}
