package Form;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DataAccess.AcademicDA;
import DataAccess.MajorDA;
import DataAccess.ShowStuMarksDA;
import DataAccess.SubjectDA;
import Model.AcademicModel;
import Model.CourseModel;
import Model.MajorModel;
import Model.StudentModel;
import Model.SubjectModel;

@SuppressWarnings("serial")
public class ShowStuMarks extends Home implements ActionListener {
	
	public static JTable table;
	public static DefaultTableModel model;
	
	static JButton show=new JButton("Show Marks");
	
	@SuppressWarnings("unchecked")
	/*public ShowStuMarks(){
		
		setTitle("TEAM-7(MIT)");
		setLayout(null);
				
		
		setLayout(null);
		

		acayearlabel.setBounds(50,50,90,25);
		add(acayearlabel);
		academicfield.setBounds(150,50,150,25);
		add(academicfield);
		
		majornamelabel.setBounds(50,100,90,25);
		add(majornamelabel);
		majorfield.setBounds(150,100,150,25);
		add(majorfield);
		
		courselabel.setBounds(50,150,90,25);
		add(courselabel);
		coursefield.setBounds(150,150,150,25);
		add(coursefield);
		
		semester.setBounds(50,200,150,25);
		add(semester);	
		semesterfield.setBounds(150,200,150,25);
		add(semesterfield);
		
		subcodelabel.setBounds(50,250,90,25);
		add(subcodelabel);
		subcodefield.setBounds(150,250,150,25);
		add(subcodefield);
		
		show.setBounds(100,300,150,30);
		add(show);
		
		subcodefield.setMaximumRowCount(3);
		
		Object[] columns={"Name","Roll","Tutorial","Exam","Practical","Total"};
		model=new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		table=new JTable();
		table.setModel(model);
		table.setRowHeight(20);
		jsp=new JScrollPane(table);
		jsp.setBounds(350,50,1000,600);
		add(jsp);
		table.setCellSelectionEnabled(false);
		
		//Department_And_Subject.addComboBox();
		
		semesterfield.addActionListener(this);
		majorfield.addActionListener(this);
		coursefield.addActionListener(this);
		show.addActionListener(this);
		
		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);

	}*/
	
public static void ShowStudentMark(){
		
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
				Department_And_Subject.addComboBox();
				
			}
		});
	}
	@SuppressWarnings("unchecked")
	public static void addsubcode(List<SubjectModel> list){
		for(SubjectModel g1: list){
					subcodefield.addItem(g1);
			}
			
		}
	
public void actionPerformed(ActionEvent e) {
	
		if(e.getSource()==show){
			if(subcodefield.getSelectedItem()==null){
				JOptionPane.showMessageDialog(this,"Enter Subcode");
			}
			
			else{
			model.setRowCount(0);// Reset Table
			table.setEnabled(false);
			StudentModel student=new StudentModel();
			
		student.setAcademicID(academicfield.getSelectedItem().toString());//change
		student.setMajorID(majorfield.getSelectedItem().toString());
		student.setSubcode(subcodefield.getSelectedItem().toString());
		
			System.out.println(student.academicID);
			System.out.println(student.majorID);
			System.out.println(student.subcode);
			
			try {
				// Get Students' Data from DataBase and add to table
				List<StudentModel> list=ShowStuMarksDA.showMarks(model,student);
				for(StudentModel studentlist: list){
				model.addRow(new Object[]{studentlist.getStuname(),studentlist.getRollno(),studentlist.getTutorial(),studentlist.getPractical(),studentlist.getExam(),studentlist.getTotal()});
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		}
}
}
