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
public class Department_And_Subject extends dataentry{
	
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
}
