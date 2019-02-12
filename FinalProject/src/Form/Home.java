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
import javax.swing.table.DefaultTableModel;

import DataAccess.AcademicDA;
import DataAccess.MajorDA;
import DataAccess.MarkDA;
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
	JMenu INSERT=new JMenu("Insert");
	JMenuItem insert=new JMenuItem("ExamMarks");
	JMenuItem reMarksInsert=new JMenuItem("ReExam Marks");
	JMenu view=new JMenu("View");
	
	static JMenuItem showStuMarks=new JMenuItem("Marks By Each Subject");
	static JMenuItem sortRollno=new JMenuItem("Updating Roll No");
	static JMenuItem result=new JMenuItem("Result");
	static JMenuItem reRes=new JMenuItem("ReExam Result");
	static JMenuItem viewEachStuMark=new JMenuItem("Marks By Each Student");

	
	JMenu file=new JMenu("File");
	JMenu New=new JMenu("New");
	
	JMenuItem exit=new JMenuItem("Exit");
	static JMenuItem academic=new JMenuItem("Academic");
	static JMenuItem student=new JMenuItem("Student");
	JMenuItem subject=new JMenuItem("subject");
	static JMenuItem major=new JMenuItem("Major");
	
	JLabel pic=new JLabel(new ImageIcon("mtugate.jpg"));
	
	static JPanel insertdata=new JPanel();
	
	static 	JButton show=new JButton("Show Marks");
	static JButton insertmajorbutton=new JButton("INSERT");
	//static JButton deletebuton=new JButton("DELETE");
	static 	JButton insertAcaButon=new JButton("INSERT");
	
	//variable declaration for sorting roll no;
	static JButton ok=new JButton("OK");
	
	//variable declaration for result;
	static JButton nextbut=new JButton("RESULTS");
	
	//variables declaration for student;
	 static JLabel studentIDLabel=new JLabel("Student ID");
	static JLabel nameLabel=new JLabel("student Name");
	static JLabel rollnolabel=new JLabel("Roll No");
	static JLabel academiclabel=new JLabel("Academic ID");
	static JLabel majorlabel=new JLabel("Major");
	
	static JTextField stuIdField=new JTextField();
	static JTextField stunamefield=new JTextField();
	static JTextField rollnofield=new JTextField();
	
	static JButton add=new JButton("ADD");

	static JButton delete=new JButton("DELETE");

	static JButton find=new JButton("FIND");
	
	 static JFrame c=new JFrame();
	
	public Home(){
		
		setTitle("Team-7(MIT)");
		
		insertdata.add(pic);
		
		ButtonGroup bg=new ButtonGroup();
		
		bg.add(insert);
		bg.add(view);
		
		home.add(INSERT);
		home.add(view);
		//home.add(reMarksInsert);
		
		INSERT.add(insert);
		INSERT.add(reMarksInsert);
		
		view.add(showStuMarks);
		view.add(viewEachStuMark);
		view.add(sortRollno);
		view.add(result);
		view.add(reRes);
		
		New.add(academic);
		New.add(student);
		New.add(subject);
		New.add(major);
		
		file.add(New);
		file.addSeparator();
		file.add(exit);
		
		mb.add(home);
		mb.add(file);
		
		c.add(mb,BorderLayout.NORTH);
		c.add(insertdata, BorderLayout.CENTER);
		
		
		insertData();
		next.addActionListener(this);
		ShowStuMarks.ShowStudentMark();
		show.addActionListener(this);
		RollNo.UpdateRollNos();
		Results.showResult();
		
		//ComboBoxs Listener
		semesterfield.addActionListener(this);
		majorfield.addActionListener(this);
		coursefield.addActionListener(this);
		
	
		Academic.insertNewAcademic();
		//new Academic();		
		Students.insertStudents();
		//insertStudent();
		add.addActionListener(this);
		delete.addActionListener(this);
		find.addActionListener(this);
		
		insertSubject();
		Major.insertNewMajor();	
		ReMarksForm();
		ReResult.showReResult();
		MarksByEachStudent.viewEachStudentMark();
		//Department_And_Subject.addComboBox();
		exit.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
			
		});
		
		c.setLocation(500,50);
		c.setSize(500,600);
		c.setVisible(true);
			
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
							academicfield.addItem(g);
						}
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
					
					try {
						List<MajorModel> list=MajorDA.majorcombo();
						majorfield.removeAllItems();
						for(MajorModel g: list){
							majorfield.addItem(g.getMajorID());
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
		//adding data to Subject code comboBox;
		public static void addsubcode(List<SubjectModel> list){
			for(SubjectModel g1: list){
						subcodefield.addItem(g1);
				}
				
			}
		
		//ReExam result
		
		public void ReMarksForm(){
			
			reMarksInsert.addActionListener(new ActionListener(){

				
				public void actionPerformed(ActionEvent arg0) {
					StudentModel students=new StudentModel();
					JTable t;
					DefaultTableModel m;
					
					JButton show=new JButton("OK");
					JButton insertReMarks=new JButton("Insert");
					
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
					
					show.setBounds(100,300,100,30);
					insertdata.add(show);
					
					insertReMarks.setBounds(250,300,100,30);
					insertdata.add(insertReMarks);
					
					Object[] columns={"No","Name","Roll","ReExam"};
					m=new DefaultTableModel();
					m.setColumnIdentifiers(columns);
					t=new JTable();
					t.setModel(m);
					t.setRowHeight(20);
					jsp=new JScrollPane(t);
					jsp.setBounds(350,50,1000,600);
					insertdata.add(jsp);
					t.setCellSelectionEnabled(false);
					
					subcodefield.setMaximumRowCount(3);
					Department_And_Subject.addComboBox();
					
					c.setExtendedState(MAXIMIZED_BOTH);
					
					
					insertReMarks.addActionListener(new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent arg0) {
							try {
								AcademicModel aca=new AcademicModel();
								aca=(AcademicModel)academicfield.getSelectedItem();
								students.setMajorID(majorfield.getSelectedItem().toString());
								students.setAcademicID(aca.academicID);
								students.setSubcode(subcodefield.getSelectedItem().toString());
								students.setSubcode(subcodefield.getSelectedItem().toString());
								if(ReMarksForm.checkmark(m)){
									if(MarkDA.reInsert(m, students)){
										JOptionPane.showMessageDialog(c," INSERT SUCCESS ","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
									}
								}
								else{
									
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						}
						
					});
					
					
					
					show.addActionListener(new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent arg0) {
							
								m.setRowCount(0);
								StudentModel students=new StudentModel();
								try {
									AcademicModel aca=new AcademicModel();
									aca=(AcademicModel)academicfield.getSelectedItem();
									students.setMajorID(majorfield.getSelectedItem().toString());
									students.setAcademicID(aca.academicID);
									students.setSubcode(subcodefield.getSelectedItem().toString());
									List<StudentModel> list=MarkDA.getReStudent(students);
									int i=1;
									for(StudentModel stu:list) {
										m.addRow(new Object[] {i++,stu.getStuname(),stu.getRollno()});
										
									}
								} catch (SQLException e1) {
									
									e1.printStackTrace();
								}
							
						}
						
					});
				}
				
			});
			
		}
		
		
	//Main
	public static void main(String args[])
	{
		new Home();
	}
	
	public static void addComboBox() {
		try {
		
			List<AcademicModel> list=AcademicDA.combo();
			academicfield.removeAllItems();
			for(AcademicModel g:list){
				academicfield.addItem(g);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		try {
			List<MajorModel> list=MajorDA.majorcombo();
			majorfield.removeAllItems();
			for(MajorModel g: list){
				majorfield.addItem(g.getMajorID());
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		try {
			
		List<CourseModel> list= SubjectDA.coursecombo();
		coursefield.removeAllItems();
			for(CourseModel g:list){
				coursefield.addItem(g.getCourse());
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
				
		
		try {
			List<SubjectModel> list = SubjectDA.semestercombo();
			semesterfield.removeAllItems();
			for(SubjectModel g: list){
				semesterfield.addItem(g.getSemester());
			}
		} catch (SQLException e1) {
		
			e1.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void subjectcode(StudentModel model){
		try {
			List<StudentModel> list=SubjectDA.subjectcombo(model);
			for(StudentModel g:list){
				subcodefield.addItem(g.getSubcode());
			}
		} catch (SQLException sql) {

			sql.printStackTrace();
		}
	}
	
	public void actionPerformed(ActionEvent e) {
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
		
		//next button from insert Menu in Home menu ;
		if(e.getSource()==next){
			StudentModel student=new StudentModel();
			AcademicModel acadmicids=(AcademicModel)academicfield.getSelectedItem();
			student.setAcademicID(acadmicids.academicID);
			student.setSemester(semesterfield.getSelectedItem().toString());
			student.setCourse(coursefield.getSelectedItem().toString());
			student.setMajorID(majorfield.getSelectedItem().toString());
			
			new MarksForm(student);
			
		}
		
	}
}

