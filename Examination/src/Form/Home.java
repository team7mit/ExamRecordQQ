package Form;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.*;
import java.io.StreamTokenizer;
import java.sql.SQLException;
import java.util.List;

import javax.swing.*;

import DataAccess.AcademicDA;
import DataAccess.MajorDA;
import DataAccess.StudentDA;
import DataAccess.SubjectDA;
import Model.AcademicModel;
import Model.CourseModel;
import Model.MajorModel;
import Model.StudentModel;
import Model.SubjectModel;

public class Home extends dataentry implements ActionListener{

	JMenuBar mb=new JMenuBar();
	
	JMenu home=new JMenu("Home");
	JRadioButtonMenuItem insert=new JRadioButtonMenuItem("Insert");
	JRadioButtonMenuItem view=new JRadioButtonMenuItem("View");
	
	JMenu file=new JMenu("File");
	JMenu New=new JMenu("New");
	JMenuItem open=new JMenuItem("Open");
	JMenuItem save=new JMenuItem("Save");
	JMenuItem close=new JMenuItem("Close");
	JMenuItem exit=new JMenuItem("Exit");
	JMenuItem student=new JMenuItem("Student");
	JMenuItem subject=new JMenuItem("subject");
	JMenuItem major=new JMenuItem("Major");
	
	JMenu edit=new JMenu("Edit");
	
	JPanel insertdata=new JPanel();
	JPanel insertstudent=new JPanel();
	JPanel insertsubject=new JPanel();
	JPanel insertmajor=new JPanel();
	
	
	Container c=getContentPane();
	
	//variables declaration for student;
	JLabel studentIDLabel=new JLabel("Student ID");
	JLabel nameLabel=new JLabel("student Name");
	JLabel rollnolabel=new JLabel("Roll No");
	JLabel academiclabel=new JLabel("Academic ID");
	JLabel majorlabel=new JLabel("Major");
	
	JButton add=new JButton("ADD"),delete=new JButton("DELETE"),find=new JButton("FIND");
	
	JTextField stuIdField=new JTextField();
	JTextField stunamefield=new JTextField();
	JTextField rollnofield=new JTextField();
	
	JComboBox<AcademicModel> academicbox=new JComboBox<>();
	JComboBox<MajorModel> majorbox=new JComboBox<>();
	
	String academicid = null;
	String majorid=null;
	
	//variables declaration for subject;
	JLabel code=new JLabel("Subject Code");
	JLabel name=new JLabel("Subject Name");
	JLabel cou=new JLabel("Course");
	JLabel sem=new JLabel("Semester");
	JLabel maj=new JLabel("Major ID");
	
	JTextField codefield=new JTextField();
	JTextField namefield=new JTextField();
	JTextField coufield=new JTextField();
	JTextField semfield=new JTextField();
	JTextField majfield=new JTextField();
	
	JButton b1=new JButton("DELETE");
	JButton b2=new JButton("INSERT");
	
	//Variables declaration for major;
	
	JLabel l1=new JLabel("Major ID");
	JLabel l2=new JLabel("Major");
	
	 public static JTextField tf1=new JTextField();
	 public static JTextField tf2=new JTextField();
	 
	 JButton insertbutton=new JButton("INSERT");
	
	public Home(){
		
		setTitle("Team-7(MIT)");
		
		home.add(insert);
		home.add(view);
		
		New.add(student);
		New.add(subject);
		New.add(major);
		
		file.add(New);
		file.add(open);
		file.add(save);
		file.add(close);
		file.addSeparator();
		file.add(exit);
		
		mb.add(home);
		mb.add(file);
		mb.add(edit);
		
		c.add(mb,BorderLayout.NORTH);
		
		//For student data entry;
		semesterfield.addActionListener(this);
		majorfield.addActionListener(this);
		coursefield.addActionListener(this);
		
		//student insert entry;
		academicbox.addActionListener(this);
		majorbox.addActionListener(this);
		
		//ActionListener for next button in student;
		next.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {

				StudentModel student=new StudentModel();
				student.setAcademicID(academicfield.getSelectedItem().toString());
				student.setSemester(semesterfield.getSelectedItem().toString());
				student.setCourse(coursefield.getSelectedItem().toString());
				student.setMajorID(majorfield.getSelectedItem().toString());
				
				new MarksForm(student);
			}
			
		});
		
		
		
		//actionListener for student ,add button;
		add.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent arg0) {

				
				System.out.println(academicid);
				
					if(stuIdField.getText().equals("") || stunamefield.getText().equals("") || rollnofield.getText().equals("")){
						JOptionPane.showMessageDialog(null,"Fill Requirements");
					}
					else{
						
						StudentModel student=new StudentModel();
						student.setAcademicID(academicid);
						student.setMajorID(majorid);
						student.setRollno(rollnofield.getText());
						student.setStuid(stuIdField.getText().toUpperCase());
						student.setStuname(stunamefield.getText().toUpperCase());
						
						
						try {
							boolean check=StudentDA.show(student);
							
							if(check){
								
								JOptionPane.showMessageDialog(null," Student ID OR ROLL NO Already EXISTS");
							}
							else{
								boolean mission=StudentDA.insertStudent(student);
								if(mission){
									JOptionPane.showMessageDialog(null,"Insert Success");
									}
								else{
									JOptionPane.showMessageDialog(null, "Insert Failed ");
							}
							}
							
						} catch (SQLException e1) {
							
							e1.printStackTrace();
						}
					}
				
			}
			
		});
		
		//actionListener for student,delete button;
		delete.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent arg) {
				
				StudentModel student=new StudentModel();
				student.setStuid(stuIdField.getText());
				if(stuIdField.getText().equals("")){
					JOptionPane.showMessageDialog(null,"INSERT STUDENT_ID TO DELETE!!!!");
				}
				else{
					try {
						boolean check=StudentDA.delete(student);
						//JOptionPane.showConfirmDialog(f, "Are You sure want to delete");
						if(check){
							JOptionPane.showMessageDialog(null,"Student Delete");
						}
						else{
							JOptionPane.showMessageDialog(null, "CHECK ID AGAIN ");
						}
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
					
				}
				
			}
			
		});
		

		
		//when choose insert menu item form home menu;
		/*insert.addItemListener(new ItemListener(){
			
			public void itemStateChanged(ItemEvent i) {
				
					//insertstudent.removeAll();
						
					c.add(insertdata,BorderLayout.CENTER);
					insertdata.setLayout(null);	

					acayearlabel.setBounds(75,100,90,25);
					insertdata.add(acayearlabel);
					academicfield.setBounds(175,100,200,25);
					insertdata.add(academicfield);
					
					majornamelabel.setBounds(75,150,90,25);
					insertdata.add(majornamelabel);
					majorfield.setBounds(175,150,200,25);
					insertdata.add(majorfield);
					
					courselabel.setBounds(75,200,90,25);
					insertdata.add(courselabel);
					coursefield.setBounds(175,200,200,25);
					insertdata.add(coursefield);
					
					semester.setBounds(75,250,150,25);
					insertdata.add(semester);	
					semesterfield.setBounds(175,250,200,25);
					insertdata.add(semesterfield);
							
					next.setBounds(295,350,80,25);
					insertdata.add(next);
					
					
					try {
					
						List<AcademicModel> list=AcademicDA.combo();
						academicfield.removeAllItems();
						for(AcademicModel g:list){
							academicfield.addItem(g.academicID);
						}
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
					
					try {
						List<MajorModel> list=MajorDA.majorcombo();
						majorfield.removeAllItems();
						for(MajorModel g: list){
							majorfield.addItem(g.majorID);
						}
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
					
					try {
						
					List<CourseModel> list= SubjectDA.coursecombo();
					coursefield.removeAllItems();
						for(CourseModel g:list){
							coursefield.addItem(g);
						}
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
							
					try {
						List<SubjectModel> list = SubjectDA.semestercombo();
						semesterfield.removeAllItems();
						for(SubjectModel g: list){
							semesterfield.addItem(g.semester);
						}
					} catch (SQLException e1) {
					
						e1.printStackTrace();
					}
			}
			
		});*/
		
		//when choose student menu item from new menu in file menu;
		student.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent arg0) {
				//insertdata.removeAll();
				c.add(insertstudent,BorderLayout.CENTER);
				insertstudent.setLayout(null);
				
				studentIDLabel.setBounds(75,100,90,25);
				insertstudent.add(studentIDLabel);
				nameLabel.setBounds(75,150,100,25);
				insertstudent.add(nameLabel);
				rollnolabel.setBounds(75,200,100,25);
				insertstudent.add(rollnolabel);
				academiclabel.setBounds(75,250,100,25);
				insertstudent.add(academiclabel);
				majorlabel.setBounds(75,300,100,25);
				insertstudent.add(majorlabel);
				
				stuIdField.setBounds(175,100,200,25);
				insertstudent.add(stuIdField);
				stunamefield.setBounds(175,150,200,25);
				insertstudent.add(stunamefield);
				rollnofield.setBounds(175,200,200,25);
				insertstudent.add(rollnofield);
				academicbox.setBounds(175,250,200,25);
				insertstudent.add(academicbox);
				majorbox.setBounds(175,300,200,25);
				insertstudent.add(majorbox);
				
				add.setBounds(70,400,80,20); 
				insertstudent.add(add);
				add.setFocusable(false);
				
				delete.setBounds(185,400,80,20);
				insertstudent.add(delete);
				delete.setFocusable(false);
				
				find.setBounds(295,400,80,20);
				insertstudent.add(find);
				find.setFocusable(false);
				
				
				try {
					List<AcademicModel> list=AcademicDA.combo();
					for(AcademicModel g:list){
						academicbox.addItem(g);
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				try {
						List<MajorModel> list=MajorDA.majorcombo();
						for(MajorModel g: list){
							majorbox.addItem(g);
						}
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
			}
			
		});
		
		//when choose subject menu item from new menu in file menu;
		subject.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent arg0) {
				
				//insertdata.removeAll();
				c.add(insertsubject,BorderLayout.CENTER);
				insertsubject.setLayout(null);
				
				code.setBounds(75,100,90,25);
				insertsubject.add(code);
				name.setBounds(75,150,90,25);
				insertsubject.add(name);
				cou.setBounds(75,200,90,25);
				insertsubject.add(cou);
				sem.setBounds(75,250,90,25);
				insertsubject.add(sem);
				maj.setBounds(75,300,90,25);
				insertsubject.add(maj);
				
				codefield.setBounds(175,100,200,25);
				insertsubject.add(codefield);
				namefield.setBounds(175,150,200,25);
				insertsubject.add(namefield);
				coufield.setBounds(175,200,200,25);
				insertsubject.add(coufield);
				semfield.setBounds(175,250,200,25);
				insertsubject.add(semfield);
				majfield.setBounds(175,300,200,25);
				insertsubject.add(majfield);
				
				b1.setBounds(185,400,80,20);
				insertsubject.add(b1);
				b1.setFocusable(false);
				
				b2.setBounds(295,400,80,20);
				insertsubject.add(b2);
				b2.setFocusable(false);
				

				
			}
			
		});
		
		//when choose major menu item form new menu in file menu;
		/*major.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent arg0) {

				//insertdata.removeAll();
				c.add(insertmajor,BorderLayout.CENTER);
				insertmajor.setLayout(null);
				
				l1.setBounds(20,50,150,20);
				insertmajor.add(l1);
				l2.setBounds(20,90,150,20);
				insertmajor.add(l2);
				
				tf1.setBounds(150,50,150,20);
				insertmajor.add(tf1);
				tf2.setBounds(150,90,150,20);
				insertmajor.add(tf2);
				b2.setBounds(160,150,80,20);
				insertmajor.add(b2);
				
			}
			
		});*/
		
		setLocation(500,50);
		setSize(500,600);
		setVisible(true);
		
		
	}
	
	public static void main(String args[])
	{
		new Home();
	}
	public void actionPerformed(ActionEvent e) {
		
	}

}