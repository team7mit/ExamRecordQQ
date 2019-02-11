package Form;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DataAccess.AcademicDA;
import DataAccess.MajorDA;
import DataAccess.MarkDA;
import DataAccess.SubjectDA;
import Model.AcademicModel;
import Model.CourseModel;
import Model.MajorModel;
import Model.StudentModel;
import Model.SubjectModel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public class ReMarksForm extends dataentry implements ActionListener {
	JFrame frame=new JFrame();
	JPanel panel = new JPanel();
	JPanel panel1=new JPanel();
	JButton b=new JButton("OK");
	JButton a=new JButton("Insert");
	DefaultTableModel model=new DefaultTableModel();
	JTable table=new JTable(model);
	JScrollPane jsp=new JScrollPane(table);
	Vector<String> column=new Vector<String>();
	StudentModel student=new StudentModel();
	
	public ReMarksForm() {
		
		frame.add(panel, BorderLayout.NORTH);
		frame.add(jsp,BorderLayout.CENTER);
		frame.add(panel1,BorderLayout.SOUTH);
		column.add("No");
		column.add("Name");
		column.add("Roll No");
		column.add("ReExam Mark");
		
		model.setColumnIdentifiers(column);
		panel.add(academicfield);
		panel.add(majorfield);
		panel.add(coursefield);
		panel.add(semesterfield);
		panel.add(subcodefield);
		panel.add(b);
		
		panel1.add(a);
		b.addActionListener(this);
		a.addActionListener(this);
		semesterfield.addActionListener(this);
		majorfield.addActionListener(this);
		coursefield.addActionListener(this);
		
		
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
			
			List<AcademicModel> list=AcademicDA.combo();
			academicfield.removeAllItems();
			for(AcademicModel g:list){
				academicfield.addItem(g);
			}
			System.out.println("ACADEMIC");
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
		
		frame.setSize(500,500);
		frame.setVisible(true);
		
	}
public static void main(String[] args) {
	new ReMarksForm();
}
@Override
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
if(e.getSource()==a) {
	
	try {
		student.setSubcode(subcodefield.getSelectedItem().toString());
		MarkDA.reInsert(model, student);
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
}
if(e.getSource()==b) {
	model.setRowCount(0);
	
	try {
		AcademicModel aca=new AcademicModel();
		aca=(AcademicModel)academicfield.getSelectedItem();
		student.setMajorID(majorfield.getSelectedItem().toString());
		student.setAcademicID(aca.academicID);
		student.setSubcode(subcodefield.getSelectedItem().toString());
		List<StudentModel> list=MarkDA.getReStudent(student);
		int i=1;
		for(StudentModel stu:list) {
			model.addRow(new Object[] {i++,stu.getStuname(),stu.getRollno()});
			
		}
	} catch (SQLException e1) {
		
		e1.printStackTrace();
	}
}
}
}
