package Form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class dataentry extends JFrame{
	
		public JLabel schoolname=new JLabel("Mandalay Technological University",SwingConstants.CENTER);
		
		//Labels
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
		
		//ScrollPane
		static JScrollPane jsp;
		
		
		//TextField
		JTextField rollnofield =new JTextField();
		
		
		//ComboBox
		public static JComboBox coursefield=new JComboBox();
		public static JComboBox academicfield=new JComboBox();
		public static JComboBox majorfield=new JComboBox();
		public static JComboBox subcodefield=new JComboBox();
		public static JComboBox semesterfield=new JComboBox();

		//Button
		static JButton cancel=new JButton("CANCEL");
		JButton next=new JButton("NEXT");
		JButton back=new JButton("BACK");
		JButton exit=new JButton("EXIT");
		JButton save=new JButton("SAVE");
		
		
		
		//Table
		public static JTable table;
		public static DefaultTableModel model;
		
		public dataentry(){
			
			coursefield.setMaximumRowCount(3);
			academicfield.setMaximumRowCount(3);
			
		}
		
		

}
