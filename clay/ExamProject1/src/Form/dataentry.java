package Form;

import javax.swing.*;

import Model.AcademicModel;

public class dataentry extends JFrame{
	
		//Panels
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
		
		//Labels
		public JLabel schoolname=new JLabel("Mandalay Technological University",SwingConstants.CENTER);
		public JLabel coding=new JLabel("Coding Marks");
		public JLabel sturesult=new JLabel("Student Result");
		public JLabel tutoandpra=new JLabel("Tutorial and Practical Marks");
		
		JLabel stunamelabel = new JLabel("Student Name");
		JLabel rollnolabel  = new JLabel("Roll No");
		JLabel stuidlabel   = new JLabel("Student ID");
		static JLabel majornamelabel  = new JLabel("Major");
		static JLabel courselabel  = new JLabel("Course");
		static JLabel acayearlabel      = new JLabel("Academic Year");
		static JLabel subcodelabel=new JLabel("Subject Code");
		static JLabel firstsemester=new JLabel("First Semester");
		static JLabel secondsemester=new JLabel("Second Semester");
		static JLabel subjectnamelabel=new JLabel("Subject Name");
		static JLabel semester=new JLabel("Semester");
		
		//RadioButton
		JRadioButton radiofirst  = new JRadioButton("First Semester");
		JRadioButton radiosecond = new JRadioButton("Second Semester");
		ButtonGroup button = new ButtonGroup();
		
		
		//TextField
		JTextField stuidfield = new JTextField(20);
		JTextField stunamefield =new JTextField(20);
		JTextField rollnofield =new JTextField(20);
		JTextField deptidfield=new JTextField(20);
		
		//ComboBox
		public static JComboBox coursefield=new JComboBox();
		public static JComboBox academicfield=new JComboBox();
		public static JComboBox majorfield=new JComboBox();
		public static JComboBox subcodefield=new JComboBox();
		public static JComboBox semesterfield=new JComboBox();

		//Button
		JButton cancel=new JButton("CANCEL");
		JButton next=new JButton("NEXT");
		JButton back=new JButton("BACK");
		JButton exit=new JButton("EXIT");
		JButton save=new JButton("SAVE");
		JButton update=new JButton("UPDATE");
		
		//JScrollPane
		JScrollPane jsp;
		
		public dataentry(){
			

			button.add(radiofirst);
			button.add(radiosecond);
			
			coursefield.setMaximumRowCount(5);
			academicfield.setMaximumRowCount(5);
			
		}
		

}