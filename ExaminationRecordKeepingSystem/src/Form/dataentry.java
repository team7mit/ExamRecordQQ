package Form;

import javax.swing.*;

import Model.StudentModel;

public class dataentry extends JFrame{
	
		public String ss;
		public JLabel schoolname=new JLabel("Mandalay Technological University",SwingConstants.CENTER);
		
		//public JLabel ceit=new JLabel("Computer Engineering & Information Technology",SwingConstants.CENTER);
		//public JLabel academic=new JLabel(ss+" Academic Year");
		public JLabel coding=new JLabel("Coding Marks");
		public JLabel sturesult=new JLabel("Student Result");
		public JLabel tutoandpra=new JLabel("Tutorial and Pratical Marks");
		
		
		JTable table=new JTable();
		//Panels
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
		//Labels
		JLabel stunamelabel = new JLabel("Student Name");
		JLabel rollnolabel  = new JLabel("Roll No");
		JLabel stuidlabel   = new JLabel("Student ID");
		JLabel majornamelabel  = new JLabel("Major");
		JLabel courselabel  = new JLabel("Course");
		JLabel acayearlabel      = new JLabel("Academic Year");
		JLabel subcodelabel=new JLabel("Subject Code");
		JLabel firstsemester=new JLabel("First Semester");
		JLabel secondsemester=new JLabel("Second Semester");
		JLabel subjectnamelabel=new JLabel("Subject Name");
		JLabel semester=new JLabel("Semester");
		
		//RadioButton
		JRadioButton radiofirst  = new JRadioButton("First Semester");
		JRadioButton radiosecond = new JRadioButton("Second Semester");
		JRadioButton deptsub=new JRadioButton("Insert marks");
		JRadioButton view= new JRadioButton("View marks");
		JRadioButton search=new JRadioButton("Search Marks By Student");
		ButtonGroup button      = new ButtonGroup();
		
		
		//TextField
		JTextField stuidfield = new JTextField(20);
		JTextField stunamefield =new JTextField(20);
		JTextField rollnofield =new JTextField(20);
		JTextField deptidfield=new JTextField(20);
		//JTextField subcodefield=new JTextField(20);
		
		//ComboBox
		public static JComboBox<String> coursefield=new JComboBox<String>();
		public static JComboBox<String> academicfield=new JComboBox<String>();
		public static JComboBox<String> majorfield=new JComboBox<String>();
		public static JComboBox<String> subcodefield=new JComboBox<String>();
		public static JComboBox <String>semesterfield=new JComboBox<String>();

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
		
		public dataentry(){
			

			button.add(radiofirst);
			button.add(radiosecond);
			
			button.add(deptsub);
			button.add(view);
			button.add(search);
			
			coursefield.setMaximumRowCount(5);
			academicfield.setMaximumRowCount(5);
			
			stunamefield.setText("Auto Generated");
			//rollnofield.setText("Auto Generated");
			deptidfield.setText("Auto Generated");
			stunamefield.setEditable(false);
			//rollnofield.setEditable(false);
			deptidfield.setEditable(false);
			//academiccreation();
			
		}
		

}
