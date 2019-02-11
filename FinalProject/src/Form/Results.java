package Form;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DataAccess.MarkDA;
import DataAccess.MyCellRenderer;
import DataAccess.ResultDA;
import Model.AcademicModel;
import Model.StudentModel;

public class Results extends Home implements ActionListener{
	private static JTable table;
	static JFrame frame=new JFrame();
	static DefaultTableModel model=new DefaultTableModel();
	static StudentModel student=new StudentModel();
	static Vector<String> column=new Vector<String>();
	
	public static void resetTable(DefaultTableModel model) {
		column.removeAllElements();
		column.add("No");
		column.add("Name");
		column.add("Roll No");
		model.setRowCount(0);
	}
	
	private static void getMarksForStudents() {
		resetTable(model);
		student.setCourse(coursefield.getSelectedItem().toString());
		student.setSemester(semesterfield.getSelectedItem().toString());
		student.setMajorID(majorfield.getSelectedItem().toString());
		AcademicModel academicmodel=(AcademicModel) academicfield.getSelectedItem();
		
		
		student.setAcademicID(academicmodel.academicID);//change

		
		try {
			
			List<StudentModel> list=MarkDA.insertMark(student);
			int i=1;
			for(StudentModel student: list) {
				model.addRow(new Object[] {i++,student.getStuname(),student.getRollno()});
			}
			column.addAll(ResultDA.result(student));
			column.add("Total");
			model.setColumnIdentifiers(column);
			//System.out.println("column added");

			getReuslts(model,student);
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	
	public static void getReuslts(DefaultTableModel model1,StudentModel student1) throws SQLException {
		for(int row=0;row<model1.getRowCount();row++) {
			for(int mark=3;mark < model1.getColumnCount()-1;mark++) {
				
				student1.setSubcode(model1.getColumnName(mark).toString());
				student1.setSemester(student.getSemester());
				//System.out.println(student.getSubcode());
				student1.setRollno(model1.getValueAt(row,2).toString());
				//System.out.println(student.rollno);
				String a=ResultDA.getAllMarks(student1,model1);
				model1.setValueAt(a, row, mark);
				//System.out.println(a+" EHLL "+student.rollno);
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
	
	
	
	
	
	public Results() throws SQLException {
		column.add("No");
		column.add("Name");
		column.add("Roll No");
		table = new JTable(model);
		table.setEnabled(false);
		JScrollPane scrollPane = new JScrollPane(table);
		
		JPanel panel = new JPanel();
		JButton button=new JButton("RESULTS");
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		frame.add(scrollPane, BorderLayout.CENTER);
		
		panel.add(academicfield);
		panel.add(semesterfield);
		panel.add(majorfield);
		panel.add(coursefield);
		panel.add(button);
		
		button.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent arg0) {		
				getMarksForStudents();												
			}});
		
		
		column.addAll(ResultDA.result(student));
		column.add("Total");
		model.setColumnIdentifiers(column);
			/*for(String s: column)
			System.out.println(s+"NLK");*/
			
			getMarksForStudents();
			
			nextbut.addActionListener(this);
			frame.setSize(getMaximumSize());
			frame.setVisible(true);
			
	}
	public static void showResult(){
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
					Department_And_Subject.addComboBox();
					nextbut.addActionListener(new ActionListener(){

						
						public void actionPerformed(ActionEvent e) {
							try {
								student.setCourse(coursefield.getSelectedItem().toString());
								student.setSemester(semesterfield.getSelectedItem().toString());
								student.setMajorID(majorfield.getSelectedItem().toString());
					
								new Results();
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							
						}
						
					});
					
			}
			
		});
	}
}
