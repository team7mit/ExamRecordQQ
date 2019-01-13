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
			subcodefield.removeAllItems();
			for(SubjectModel g:list){
				subcodefield.addItem(g.getSubcode());
			}
		} catch (SQLException sql) {

			sql.printStackTrace();
		}
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
