package Form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.*;
import DataAccess.AcademicDA;
import DataAccess.MajorDA;
import DataAccess.SubjectDA;
import Model.AcademicModel;
import Model.CourseModel;
import Model.MajorModel;
import Model.StudentModel;
import Model.SubjectModel;

@SuppressWarnings("serial")
public class Department_And_Subject extends dataentry implements ActionListener{
	
	private JPanel panel=new JPanel();
	private JFrame f=new JFrame();
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
		
		addComboBox();
		
		f.setLocation(500,50);
		f.setSize(500,600);
		f.setVisible(true);
		
		//subcodefield.setEnabled(false);
		
		semesterfield.addActionListener(this);
		majorfield.addActionListener(this);
		coursefield.addActionListener(this);
	}
	public static void addComboBox() {
		try {
		
			List<StudentModel> list=AcademicDA.combo();
			academicfield.removeAllItems();
			for(StudentModel g:list){
				academicfield.addItem(g.getAcademicID());
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		try {
			List<StudentModel> list=MajorDA.majorcombo();
			majorfield.removeAllItems();
			for(MajorModel g: list){
				majorfield.addItem(g.getMajorID());
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		try {
			
		List<StudentModel> list= SubjectDA.coursecombo();
		coursefield.removeAllItems();
			for(StudentModel g:list){
				coursefield.addItem(g.getCourse());
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
				
		
		try {
			List<StudentModel> list = SubjectDA.semestercombo();
			semesterfield.removeAllItems();
			for(StudentModel g: list){
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
	public static void addsubcode(List<StudentModel> list){
		subcodefield.setEnabled(true);
		for(StudentModel g1: list){
					subcodefield.addItem(g1.getSubcode());
			}
			
		}
	@SuppressWarnings("unchecked")
	public  void addMajor() throws SQLException{
		List<StudentModel> list=MajorDA.majorcombo();
		for(StudentModel student: list)
		{
			majorfield.addItem(student.getMajorID());
		}
	}
	
	
	public static void main(String[] args) {
		
		new Department_And_Subject();
		
	}

	public void actionPerformed(ActionEvent e) {
		
		//checkComboBox(e);
		
	if(e.getSource()==cancel){
		f.dispose();
	}
	
	
	if(e.getSource()==next){
		
		
			StudentModel student=new StudentModel();
			student.setAcademicID(academicfield.getSelectedItem().toString());
			student.setSemester(semesterfield.getSelectedItem().toString());
			student.setCourse(coursefield.getSelectedItem().toString());
			student.setMajorID(majorfield.getSelectedItem().toString());
			
			new MarksForm(student);
		}
	}

}
