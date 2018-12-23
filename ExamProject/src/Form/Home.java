package Form;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

import DataAccess.AcademicDA;
import DataAccess.MajorDA;
import DataAccess.ShowStuMarksDA;
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
	JMenuItem insert=new JMenuItem("Insert");
	JMenu view=new JMenu("View");
	
	JMenuItem showStuMarks=new JMenuItem("Marks By Each Subject");
	JMenuItem sortRollno=new JMenuItem("Updating Roll No");
	JMenuItem result=new JMenuItem("Result");
	
	JMenu file=new JMenu("File");
	JMenu New=new JMenu("New");
	JMenuItem open=new JMenuItem("Open");
	JMenuItem save=new JMenuItem("Save");
	JMenuItem close=new JMenuItem("Close");
	JMenuItem exit=new JMenuItem("Exit");
	JMenuItem academic=new JMenuItem("Academic");
	JMenuItem student=new JMenuItem("Student");
	JMenuItem subject=new JMenuItem("subject");
	JMenuItem major=new JMenuItem("Major");
	
	JMenu edit=new JMenu("Edit");
	
	JLabel pic=new JLabel(new ImageIcon("mtugate.jpg"));
	
	JPanel insertdata=new JPanel();
	
	JButton show=new JButton("Show Marks");
	JButton insertbutton=new JButton("INSERT");
	JButton insertAcaButon=new JButton("INSERT");
	
	//variable declaration for sorting roll no;
	JButton ok=new JButton("OK");
	
	//variable declaration for result;
	JButton nextbut=new JButton("NEXT");
	
	//variables declaration for student;
	JLabel studentIDLabel=new JLabel("Student ID");
	JLabel nameLabel=new JLabel("student Name");
	JLabel rollnolabel=new JLabel("Roll No");
	JLabel academiclabel=new JLabel("Academic ID");
	JLabel majorlabel=new JLabel("Major");
	
	JTextField stuIdField=new JTextField();
	JTextField stunamefield=new JTextField();
	JTextField rollnofield=new JTextField();
	
	JComboBox<AcademicModel> academicbox=new JComboBox<>();
	JComboBox<MajorModel> majorbox=new JComboBox<>();
	
	String academicid = null;
	String majorid=null;
	JButton add=new JButton("ADD"),delete=new JButton("DELETE"),find=new JButton("FIND");
	
	Container c=getContentPane();
	
	public Home(){
		
		setTitle("Team-7(MIT)");
		
		insertdata.add(pic);
		
		ButtonGroup bg=new ButtonGroup();
		
		bg.add(insert);
		bg.add(view);
		
		home.add(insert);
		home.add(view);
		
		view.add(showStuMarks);
		view.add(sortRollno);
		view.add(result);
		
		New.add(academic);
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
		c.add(insertdata, BorderLayout.CENTER);
		
		
		insertData();
		next.addActionListener(this);
		ShowStudentMarks();
		show.addActionListener(this);
		UpdateRollNo();
		showResult();
		
		//ComboBoxs Listener
		semesterfield.addActionListener(this);
		majorfield.addActionListener(this);
		coursefield.addActionListener(this);
		
		insertAcademic();
		
		insertStudent();
		add.addActionListener(this);
		delete.addActionListener(this);
		find.addActionListener(this);
		
		insertSubject();
		insertMajor();
		
		setLocation(500,50);
		setSize(500,600);
		setVisible(true);
			
	}
	//insert
	public void insertData(){
			insert.addActionListener(new ActionListener(){
			
				public void actionPerformed(ActionEvent arg) {
				
				insertdata.removeAll();
				insertdata.validate();
				insertdata.repaint();
						
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
		});
		
	}
	
	//view
	public void ShowStudentMarks(){
		
		showStuMarks.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg) {
				
				
				insertdata.removeAll();
				insertdata.validate();
				insertdata.repaint();
				
				c.add(insertdata,BorderLayout.CENTER);
				insertdata.setLayout(null);
				

				acayearlabel.setBounds(50,50,90,25);
				insertdata.add(acayearlabel);
				academicfield.setBounds(150,50,150,25);
				insertdata.add(academicfield);
				
				majornamelabel.setBounds(50,100,90,25);
				insertdata.add(majornamelabel);
				majorfield.setBounds(150,100,150,25);
				insertdata.add(majorfield);
				
				courselabel.setBounds(50,150,90,25);
				insertdata.add(courselabel);
				coursefield.setBounds(150,150,150,25);
				insertdata.add(coursefield);
				
				semester.setBounds(50,200,150,25);
				insertdata.add(semester);	
				semesterfield.setBounds(150,200,150,25);
				insertdata.add(semesterfield);
				
				subcodelabel.setBounds(50,250,90,25);
				insertdata.add(subcodelabel);
				subcodefield.setBounds(150,250,150,25);
				insertdata.add(subcodefield);
				
				show.setBounds(100,300,150,30);
				insertdata.add(show);
				
				subcodefield.setMaximumRowCount(3);
				
				try {
					List<AcademicModel> list=AcademicDA.combo();
					for(AcademicModel g:list){
						academicfield.addItem(g.academicID);
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
				try {
					List<MajorModel> list=MajorDA.majorcombo();
					for(MajorModel g: list){
						majorfield.addItem(g.majorID);
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
				try {
					
				List<CourseModel> list= SubjectDA.coursecombo();
					for(CourseModel g:list){
						coursefield.addItem(g);
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
						
				try {
					List<SubjectModel> list = SubjectDA.semestercombo();
					for(SubjectModel g: list){
						semesterfield.addItem(g.semester);
					}
				} catch (SQLException e1) {
				
					e1.printStackTrace();
				}
				
			}
		});
	}
	
	public void UpdateRollNo(){
		sortRollno.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent arg0) {
				
				insertdata.removeAll();
				insertdata.validate();
				insertdata.repaint();
				
				c.add(insertdata,BorderLayout.CENTER);
				insertdata.setLayout(null);
				
				acayearlabel.setBounds(50,50,90,25);
				insertdata.add(acayearlabel);
				academicfield.setBounds(150,50,150,25);
				insertdata.add(academicfield);
				
				majornamelabel.setBounds(50,100,90,25);
				insertdata.add(majornamelabel);
				majorfield.setBounds(150,100,150,25);
				insertdata.add(majorfield);
				
				courselabel.setBounds(50,150,90,25);
				insertdata.add(courselabel);
				coursefield.setBounds(150,150,150,25);
				insertdata.add(coursefield);
				
				ok.setBounds(100,300,150,30);
				insertdata.add(ok);
				
				try {
					List<AcademicModel> list=AcademicDA.combo();
					for(AcademicModel g:list){
						academicfield.addItem(g.academicID);
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
				try {
					List<MajorModel> list=MajorDA.majorcombo();
					for(MajorModel g: list){
						majorfield.addItem(g.majorID);
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
				try {
					
				List<CourseModel> list= SubjectDA.coursecombo();
					for(CourseModel g:list){
						coursefield.addItem(g);
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
			}
			
		});
	}
	
	public void showResult(){
		result.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg) {

				insertdata.removeAll();
				insertdata.validate();
				insertdata.repaint();
				
				c.add(insertdata,BorderLayout.CENTER);
				insertdata.setLayout(null);
				
				insertdata.removeAll();
				insertdata.validate();
				insertdata.repaint();
						
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
							
					nextbut.setBounds(295,350,80,25);
					insertdata.add(nextbut);
					
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
			
		});
	}
	
	//insert academic;
	public void insertAcademic(){
		
		JLabel acaID=new JLabel("Academic ID");
		JLabel aca=new JLabel("Academic");
		
		JTextField t1=new JTextField();
		JTextField t2=new JTextField();
		
		academic.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent arg0) {
				
				insertdata.removeAll();
				insertdata.validate();
				insertdata.repaint();
				

				c.add(insertdata,BorderLayout.CENTER);
				insertdata.setLayout(null);
		
				acaID.setBounds(20,50,150,20);
				insertdata.add(acaID);
				aca.setBounds(20,90,150,20);
				insertdata.add(aca);
		
				t1.setBounds(150,50,150,20);
				insertdata.add(t1);
				t2.setBounds(150,90,150,20);
				insertdata.add(t2);
		
				insertbutton.setBounds(220,150,80,20);
				insertdata.add(insertbutton);
				
		}
			
			});
	}
	
	//insert student;
	public void insertStudent(){
		
			student.addActionListener(new ActionListener(){

			
				public void actionPerformed(ActionEvent arg0) {
					
					insertdata.removeAll();
					insertdata.validate();
					insertdata.repaint();
				c.add(insertdata,BorderLayout.CENTER);
				insertdata.setLayout(null);
				
				studentIDLabel.setBounds(75,100,90,25);
				insertdata.add(studentIDLabel);
				nameLabel.setBounds(75,150,100,25);
				insertdata.add(nameLabel);
				rollnolabel.setBounds(75,200,100,25);
				insertdata.add(rollnolabel);
				academiclabel.setBounds(75,250,100,25);
				insertdata.add(academiclabel);
				majorlabel.setBounds(75,300,100,25);
				insertdata.add(majorlabel);
				
				stuIdField.setBounds(175,100,200,25);
				insertdata.add(stuIdField);
				stunamefield.setBounds(175,150,200,25);
				insertdata.add(stunamefield);
				rollnofield.setBounds(175,200,200,25);
				insertdata.add(rollnofield);
				academicbox.setBounds(175,250,200,25);
				insertdata.add(academicbox);
				majorbox.setBounds(175,300,200,25);
				insertdata.add(majorbox);
				
				add.setBounds(70,400,80,20); 
				insertdata.add(add);
				add.setFocusable(false);
				
				delete.setBounds(185,400,80,20);
				insertdata.add(delete);
				delete.setFocusable(false);
				
				find.setBounds(295,400,80,20);
				insertdata.add(find);
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
	}
	
	
	//insert subject;
	public void insertSubject(){
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
		
		subject.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent arg0) {
				
				insertdata.removeAll();
				insertdata.validate();
				insertdata.repaint();
				
				c.add(insertdata,BorderLayout.CENTER);
				insertdata.setLayout(null);
				
				code.setBounds(75,100,90,25);
				insertdata.add(code);
				name.setBounds(75,150,90,25);
				insertdata.add(name);
				cou.setBounds(75,200,90,25);
				insertdata.add(cou);
				sem.setBounds(75,250,90,25);
				insertdata.add(sem);
				maj.setBounds(75,300,90,25);
				insertdata.add(maj);
				
				codefield.setBounds(175,100,200,25);
				insertdata.add(codefield);
				namefield.setBounds(175,150,200,25);
				insertdata.add(namefield);
				coufield.setBounds(175,200,200,25);
				insertdata.add(coufield);
				semfield.setBounds(175,250,200,25);
				insertdata.add(semfield);
				majfield.setBounds(175,300,200,25);
				insertdata.add(majfield);
				
				b1.setBounds(185,400,80,20);
				insertdata.add(b1);
				b1.setFocusable(false);
				
				b2.setBounds(295,400,80,20);
				insertdata.add(b2);
				b2.setFocusable(false);
				

				
			}
			
		});
	}
	//insert major;
		public void insertMajor(){
		JLabel l1=new JLabel("Major ID");
		JLabel l2=new JLabel("Major");
		
		 JTextField tf1=new JTextField();
		 JTextField tf2=new JTextField();
		 major.addActionListener(new ActionListener(){

				
				public void actionPerformed(ActionEvent arg0) {

					insertdata.removeAll();
					insertdata.validate();
					insertdata.repaint();
					
					c.add(insertdata,BorderLayout.CENTER);
					insertdata.setLayout(null);
					
					l1.setBounds(20,50,150,20);
					insertdata.add(l1);
					l2.setBounds(20,90,150,20);
					insertdata.add(l2);
					
					tf1.setBounds(150,50,150,20);
					insertdata.add(tf1);
					tf2.setBounds(150,90,150,20);
					insertdata.add(tf2);
					insertbutton.setBounds(160,150,80,20);
					insertdata.add(insertbutton);
				}
		 });
		 
		
	}
		//adding data to Subject code comboBox;
		public static void addsubcode(List<SubjectModel> list){
			for(SubjectModel g1: list){
						subcodefield.addItem(g1);
				}
				
			}
	//Main
	public static void main(String args[])
	{
		new Home();
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		//next button from insert radioButtonMenuItem in Home menu ;
		if(e.getSource()==next){
			StudentModel student=new StudentModel();
			student.setAcademicID(academicfield.getSelectedItem().toString());
			student.setSemester(semesterfield.getSelectedItem().toString());
			student.setCourse(coursefield.getSelectedItem().toString());
			student.setMajorID(majorfield.getSelectedItem().toString());
			
			new MarksForm(student);
			
		}
		
		//action for comboBoc in view Part;
		if(e.getSource()==coursefield || e.getSource()==majorfield || e.getSource()==semesterfield){
			
			Object sem=semesterfield.getSelectedItem();
			Object majors=majorfield.getSelectedItem();
			Object course=coursefield.getSelectedItem();
			
			if(sem!=null && majors!=null && course!=null){
				subcodefield.setEnabled(true);
				StudentModel semester=new StudentModel();
				semester.setSemester(sem.toString());
				semester.setMajorID(majors.toString());
				semester.setCourse(course.toString());
				
					if(subcodefield.getSelectedItem()==null){
						Department_And_Subject.subjectcode(semester);
					}
					else{
						subcodefield.removeAllItems();
						Department_And_Subject.subjectcode(semester);
					}
					
				}
				
			}
		
		//show button from view radioButtonMenuItem in Home Menu;
		if(e.getSource()==show){
			
		}
		
		//ActionListener for student;
		if(e.getSource()==academicbox){
			
			JComboBox<AcademicModel> c = (JComboBox<AcademicModel>) e.getSource();
		      AcademicModel item = (AcademicModel) c.getSelectedItem();
		      System.out.println(item.getAcademicID());
		      academicid=item.getAcademicID();
		      
		}
		if(e.getSource()==majorbox){
			@SuppressWarnings("unchecked")
			JComboBox<MajorModel> c = (JComboBox<MajorModel>) e.getSource();
		      MajorModel item = (MajorModel) c.getSelectedItem();
		      System.out.println(item.getMajorID());
		      majorid=item.getMajorID();
		}
		
		if(e.getSource()==add){
			
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
		if(e.getSource()==delete){
			
			StudentModel student=new StudentModel();
			student.setStuid(stuIdField.getText());
			if(stuIdField.getText().equals("")){
				JOptionPane.showMessageDialog(this,"INSERT STUDENT_ID TO DELETE!!!!");
			}
			else{
				try {
					boolean check=StudentDA.delete(student);	
					if(check){
						JOptionPane.showMessageDialog(this,"Student Delete");
					}
					else{
						JOptionPane.showMessageDialog(null, "CHECK ID AGAIN ");
					}
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
			}
		}
		if(e.getSource()==find){
			StudentModel student=new StudentModel();
			student.setStuid(stuIdField.getText());
			student.setAcademicID(academicid);
		}
		}
	

}
