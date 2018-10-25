package gui;

import javax.swing.*;

/*
 The following statements are written by Hein Htet Thura on 22 October 2018
 The following class contains components for further uses.
 */
public class dataentry extends JFrame {
	
	public String schoolname="Mandalay Technological University";

	public static String DeptID[]={"CE","Arch","Mech","CEIT","EC","EP","MC","Ch.E","Mining","Nuclear","Biotech"};
	public static String Course[]={"First Year","Second Year","Third Year","Fourth Year","Fifth Year","Sixth Year","Master","PhD"};
	public static String academicyear[]=new String[10];
	 
	//Labels
	JLabel stunamelabel = new JLabel("Student Name");
	JLabel rollnolabel  = new JLabel("Roll No");
	JLabel stuidlabel   = new JLabel("Student ID");
	JLabel deptidlabel  = new JLabel("Department ID");
	JLabel courselabel  = new JLabel("Course");
	JLabel acayearlabel      = new JLabel("Academic Year");
	JLabel subcodelabel=new JLabel("Subject Code");
	
	//RadioButton
	JRadioButton radiofirst  = new JRadioButton("First Semester");
	JRadioButton radiosecond = new JRadioButton("Second Semester");
	ButtonGroup semester      = new ButtonGroup();
	
	
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
	
	//insert academic year (eg..(2012-2013))
	protected static void academiccreation(){
		int first=2012;
		int second=2013;
		for(int i=0;i<10;i++){
			academicyear[i]=String.valueOf(first++)+"-"+String.valueOf(second++);
		}
	}
	public dataentry(){
		super("TEAM-7(MIT)");

		semester.add(radiofirst);
		semester.add(radiosecond);
		
		coursefield.setMaximumRowCount(5);
		academicfield.setMaximumRowCount(5);
		
		stunamefield.setText("Auto Generated");
		rollnofield.setText("Auto Generated");
		deptidfield.setText("Auto Generated");
		stunamefield.setEditable(false);
		rollnofield.setEditable(false);
		deptidfield.setEditable(false);
	
	}
	
}
