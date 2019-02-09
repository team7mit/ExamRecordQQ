package Form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.*;

import DataAccess.AcademicDA;
import DataAccess.Department_And_SubjectDA;
import DataAccess.MajorDA;
import DataAccess.SubjectDA;
import Model.AcademicModel;
import Model.CourseModel;
import Model.MajorModel;
import Model.SemesterModel;
import Model.StudentModel;
import Model.SubjectModel;

@SuppressWarnings("serial")
public class Department_And_Subject extends dataentry implements ActionListener{
	
	/*private JPanel panel=new JPanel();
	JButton news1=new JButton("NEW");
	JButton news2=new JButton("NEW");
	JButton news3=new JButton("NEW");
	private JFrame f=new JFrame();
	@SuppressWarnings("unchecked")
	public Department_And_Subject(){
		
		f.setTitle("TEAM-7(MIT)");
		f.setResizable(false);
		f.setLayout(null);
				
		f.add(panel);
		panel.setLayout(null);
		panel.setBounds(50, 50, 400, 350);
		panel.setBorder(BorderFactory.createTitledBorder("Subject Data Entry"));;

		acayearlabel.setBounds(50,50,90,25);
		panel.add(acayearlabel);
		academicfield.setBounds(150,50,100,25);
		panel.add(academicfield);
		news1.setBounds(275,50,75,25);
		panel.add(news1);
		
		
		majornamelabel.setBounds(50,100,90,25);
		panel.add(majornamelabel);
		majorfield.setBounds(150,100,100,25);
		panel.add(majorfield);
		news2.setBounds(275, 100, 75, 25);
		panel.add(news2);
		
		courselabel.setBounds(50,150,90,25);
		panel.add(courselabel);
		coursefield.setBounds(150,150,200,25);
		panel.add(coursefield);
		
		semester.setBounds(50,200,150,25);
		panel.add(semester);	
		semesterfield.setBounds(150,200,200,25);
		panel.add(semesterfield);
		
		subcodelabel.setBounds(50,250,90,25);
		panel.add(subcodelabel);
		subcodefield.setBounds(150,250,100,25);
		panel.add(subcodefield);
		news3.setBounds(275, 250, 75, 25);
		panel.add(news3);
		
		subcodefield.setMaximumRowCount(3);
		
		cancel.setBounds(150,450,80,25);
		f.add(cancel);
		next.setBounds(250,450,80,25);
		f.add(next);
		
		
		next.addActionListener(this);
		cancel.addActionListener(this);
		
		
		news1.addActionListener(this);
		news2.addActionListener(this);
		news3.addActionListener(this);
		
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
		
		f.setLocation(500,50);
		f.setSize(500,600);
		f.setVisible(true);
		
		//subcodefield.setEnabled(false);
		
		semesterfield.addActionListener(this);
		majorfield.addActionListener(this);
		coursefield.addActionListener(this);
	}
	
	
	@SuppressWarnings("unchecked")*/
	
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
			for(SubjectModel g:list){
				subcodefield.addItem(g.getSubcode());
			}
		} catch (SQLException sql) {

			sql.printStackTrace();
		}
	}
	
	public void addMajor() throws SQLException{
		Department_And_SubjectDA das=new Department_And_SubjectDA();
		ArrayList<String>list=das.getMajor();
		for(int i=0;i<list.size();i++)
		{
			majorfield.addItem(i);
		}
	}
	
	
	public static void main(String[] args) {
		//academiccreation();
		new Department_And_Subject();
		
	}
	/*public static void addsubcodeList<StudentModel> list){
		for(SubjectModel g1: list){
					subcodefield.addItem(g1);
			}
			
		}*/
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
				try {
					List<StudentModel> list=SubjectDA.subjectcombo(semester);
					System.out.println(list);
					if(subcodefield.getSelectedItem()==null){
						subjectcode(semester);				}
					else{
						subcodefield.removeAllItems();
						subjectcode(semester);
					}
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
			}
			
		}
	}
	


}
