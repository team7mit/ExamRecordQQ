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
	
	private JPanel panel=new JPanel();
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
		
		majornamelabel.setBounds(50,100,90,25);
		panel.add(majornamelabel);
		majorfield.setBounds(150,100,100,25);
		panel.add(majorfield);
		
		courselabel.setBounds(50,150,90,25);
		panel.add(courselabel);
		coursefield.setBounds(150,150,200,25);
		panel.add(coursefield);
		
		semester.setBounds(50,200,150,25);
		panel.add(semester);	
		semesterfield.setBounds(150,200,200,25);
		panel.add(semesterfield);
				
		cancel.setBounds(150,450,80,25);
		f.add(cancel);
		next.setBounds(250,450,80,25);
		f.add(next);
		
		
		next.addActionListener(this);
		cancel.addActionListener(this);
		
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
		
		f.setLocation(500,50);
		f.setSize(500,600);
		f.setVisible(true);
		
		//subcodefield.setEnabled(false);
		
		semesterfield.addActionListener(this);
		majorfield.addActionListener(this);
		coursefield.addActionListener(this);
	}
	
	
	@SuppressWarnings("unchecked")
	public void subjectcode(SubjectModel model){
		try {
			List<SubjectModel> list=SubjectDA.subjectcombo(model);
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
	public static void addsubcode(List<SubjectModel> list){
		for(SubjectModel g1: list){
					subcodefield.addItem(g1);
			}
			
		}
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==coursefield || e.getSource()==majorfield || e.getSource()==semesterfield){
			
			Object sem=semesterfield.getSelectedItem();
			Object majors=majorfield.getSelectedItem();
			Object course=coursefield.getSelectedItem();
			
			if(sem!=null && majors!=null && course!=null){
				subcodefield.setEnabled(true);
				SubjectModel semester=new SubjectModel();
				semester.setSemester(sem.toString());
				semester.setMajorID(majors.toString());
				semester.setCourse(course.toString());
				try {
					List<SubjectModel> list=SubjectDA.subjectcombo(semester);
					System.out.println(list);
					if(subcodefield.getSelectedItem()==null){
						addsubcode(list);
					}
					else{
						subcodefield.removeAllItems();
						addsubcode(list);
					}
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
			}
			
		}
	if(e.getSource()==cancel){
		f.dispose();
	}
	
	
	if(e.getSource()==next){
		if(subcodefield.getSelectedItem()==null){
			JOptionPane.showMessageDialog(panel, "Insert Subject");
		}
		else{
			StudentModel student=new StudentModel();
			student.setAcademicID(academicfield.getSelectedItem().toString());
			student.setSemester(semesterfield.getSelectedItem().toString());
			student.setCourse(coursefield.getSelectedItem().toString());
			student.setMajorID(majorfield.getSelectedItem().toString());
			
			//SemesterModel sem=(SemesterModel) semesterfield.getSelectedItem();
		//	MajorModel majors=(MajorModel) majorfield.getSelectedItem();
			//CourseModel course=(CourseModel) coursefield.getSelectedItem();
			
			new MarksForm(student);
		}
	}
	}
	


}