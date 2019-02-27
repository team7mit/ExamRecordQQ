package Form;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DataAccess.MarkDA;
import DataAccess.MyCellRenderer;
import DataAccess.ResultDA;
import Model.AcademicModel;
import Model.StudentModel;

public class ReResult extends Home{
	
	private static JTable table;
	static JFrame frame=new JFrame();
	static DefaultTableModel model=new DefaultTableModel();
	static Vector<String> column=new Vector<String>();
	static JButton finbut=new JButton("Find");
	
	static StudentModel stu=new StudentModel();
	StudentModel student=new StudentModel();
	public ReResult() throws SQLException{
		
		column.add("No");
		column.add("Name");
		column.add("Roll No");
		Object[] columns={"No","Name","Roll","ReExam"};
			model.setColumnIdentifiers(columns);
		table = new JTable(model);
		table.setEnabled(false);
		JScrollPane scrollPane = new JScrollPane(table);
		
		JPanel panel = new JPanel();
		JButton button=new JButton("RESULTS");
		frame.add(panel, BorderLayout.NORTH);
		frame.add(scrollPane, BorderLayout.CENTER);
		
		panel.add(subcodefield);
		Department_And_Subject.subjectcode(stu);
		panel.add(button);
		
		button.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent arg0) {	
				
				
				model.setRowCount(0);
				
				try {
					
					stu.setSubcode(subcodefield.getSelectedItem().toString());
					
					student.setSubcode(stu.getSubcode());
					student.setAcademicID(stu.getAcademicID());
					student.setMajorID(stu.getMajorID());
					List<StudentModel> list=MarkDA.getReStudent(student);
					int i=1;
					int j=0;
					for(StudentModel stu:list) {
						model.addRow(new Object[] {i++,stu.getStuname(),stu.getRollno()});
						student.setRollno(stu.getRollno());
						//System.out.println(ResultDA.getReExamMarks(student)+ "GOTCHA");
						model.setValueAt(ResultDA.getReExamMarks(student),j++ ,3);	
					}
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}

		});
		
		
		finbut.addActionListener(this);
		frame.setSize(getMaximumSize());
		frame.setVisible(true);
		
	}
	
	public static void resetTable(DefaultTableModel model) {
		column.removeAllElements();
		column.add("No");
		column.add("Name");
		column.add("Roll No");
		model.setRowCount(0);
	}
	
	private void getMarksForStudents() {

		resetTable(model);
		stu.setCourse(coursefield.getSelectedItem().toString());
		stu.setSemester(semesterfield.getSelectedItem().toString());
		stu.setMajorID(majorfield.getSelectedItem().toString());
		AcademicModel academicmodel=(AcademicModel) academicfield.getSelectedItem();
		
		
		stu.setAcademicID(academicmodel.academicID);//change

		
		try {
			
			List<StudentModel> list=MarkDA.insertMark(stu);
			int i=1;
			for(StudentModel student: list) {
				model.addRow(new Object[] {i++,student.getStuname(),student.getRollno()});
			}
		//	column.addAll(ReResultDA.reResult(stu));
			column.add("Total");
			model.setColumnIdentifiers(column);
			//System.out.println("column added");

			getReuslts(model,stu);
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		
		
	}
	
	private void getReuslts(DefaultTableModel model1, StudentModel student1) throws SQLException {

		for(int row=0;row<model1.getRowCount();row++) {
			for(int mark=3;mark < model1.getColumnCount()-1;mark++) {
				
				student1.setSubcode(model1.getColumnName(mark).toString());
				student1.setSemester(stu.getSemester());
				student1.setRollno(model1.getValueAt(row,2).toString());
				String a=ResultDA.getAllMarks(student1,model1);
				model1.setValueAt(a, row, mark);
				table.getColumnModel().getColumn(mark).setCellRenderer(new MyCellRenderer());
			}
		}
		
		try {
			for(int row=0;row<model1.getRowCount();row++) {
				int total=0;
				for(int mark=3;mark < model1.getColumnCount()-1;mark++) {
					 total=total+Integer.parseInt(model1.getValueAt(row,mark).toString());
					 model1.setValueAt(total, row,model1.getColumnCount()-1);
					 
				}
			}
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(frame, "Marks Not Found, Insert Marks First","No Marks",JOptionPane.WARNING_MESSAGE);
		}
	
		
	}

	public static void showReResult(){

		reRes.addActionListener(new ActionListener(){

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
							
					finbut.setBounds(295,350,80,25);
					insertdata.add(finbut);
					
					
					Department_And_Subject.addComboBox();
					
					finbut.addActionListener(new ActionListener(){

						
						public void actionPerformed(ActionEvent e) {
							try {
								AcademicModel academicmodel=(AcademicModel) academicfield.getSelectedItem();
								stu.setAcademicID(academicmodel.academicID);
								stu.setCourse(coursefield.getSelectedItem().toString());
								stu.setSemester(semesterfield.getSelectedItem().toString());
								stu.setMajorID(majorfield.getSelectedItem().toString());
								
								
								new ReResult();
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							
						}
						
					});
					
			}
			
		});
	
	}

}
