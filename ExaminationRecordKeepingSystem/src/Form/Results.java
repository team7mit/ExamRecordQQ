package Form;

import javax.swing.JScrollPane;
import java.awt.BorderLayout;
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
import DataAccess.SubjectDA;
import Model.StudentModel;
import javax.swing.JPanel;

public class Results extends dataentry implements ActionListener{
	private static JTable table;
	DefaultTableModel model=new DefaultTableModel();
	StudentModel student=new StudentModel();
	static Vector<String> column=new Vector<String>();
	public Results() throws SQLException {
		
		
		column.add("No");
		column.add("Name");
		column.add("Roll No");
		
		model.setColumnIdentifiers(column);
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		
		panel.add(academicfield);
		panel.add(semesterfield);
		panel.add(majorfield);
		panel.add(coursefield);
		next.setText("Result");
		panel.add(next);
		
		academicfield.addActionListener(this);
		semesterfield.addActionListener(this);
		majorfield.addActionListener(this);
		coursefield.addActionListener(this);

		next.addActionListener(this);
		
		Department_And_Subject.addComboBox();
		
		
		
		setSize(getMaximumSize());
		setVisible(true);
	}
	/*public static void checkComboBox(ActionEvent e) {
		if(e.getSource()==coursefield || e.getSource()==majorfield || e.getSource()==semesterfield){
			
			String sem=semesterfield.getSelectedItem().toString();
			String majors=majorfield.getSelectedItem().toString();
			String course=coursefield.getSelectedItem().toString();
			
			if(sem!=null && majors!=null && course!=null){
				subcodefield.setEnabled(true);
				StudentModel semester=new StudentModel();
				semester.setSemester(sem);
				semester.setMajorID(majors);
				semester.setCourse(course);
				try {
					List<StudentModel> list=SubjectDA.subjectcombo(semester);
					System.out.println(list);
					if(subcodefield.getSelectedItem()==null){
						Department_And_Subject.addsubcode(list);
					}
					else{
						subcodefield.removeAllItems();
						Department_And_Subject.addsubcode(list);
					}
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
			}
			
		}
	}*/
	public static void resetTable(DefaultTableModel model) {
		column.removeAllElements();
		column.add("No");
		column.add("Name");
		column.add("Roll No");
		model.setRowCount(0);
	}
	public static void getReuslts(DefaultTableModel model1,StudentModel student1) throws SQLException {
		for(int row=0;row<model1.getRowCount();row++) {
			for(int mark=3;mark < model1.getColumnCount()-1;mark++) {
				
				student1.setSubcode(model1.getColumnName(mark).toString());
				//System.out.println(student.getSubcode());
				student1.setRollno(model1.getValueAt(row,2).toString());
				//System.out.println(student.rollno);
				String a=ResultDA.getAllMarks(student1,model1);
				model1.setValueAt(a, row, mark);
				table.getColumnModel().getColumn(mark).setCellRenderer(new MyCellRenderer());
			}
		}
		
		for(int row=0;row<model1.getRowCount();row++) {
			int total=0;
			for(int mark=3;mark < model1.getColumnCount()-1;mark++) {
				 total=total+Integer.parseInt(model1.getValueAt(row,mark).toString());
				 model1.setValueAt(total, row,model1.getColumnCount()-1);
				 
			}
		}
	}
public static void main(String[] args) throws SQLException {
	new Results();
}
@Override
public void actionPerformed(ActionEvent e) {
	
	if(e.getSource()==next) {
		resetTable(model);
		
		student.setCourse(coursefield.getSelectedItem().toString());
		student.setSemester(semesterfield.getSelectedItem().toString());
		student.setMajorID(majorfield.getSelectedItem().toString());
		student.setAcademicID(academicfield.getSelectedItem().toString());

		
		try {
			
			List<StudentModel> list=MarkDA.insertMark(model, student);
			int i=1;
			for(StudentModel student: list) {
				model.addRow(new Object[] {i++,student.getStuname(),student.getRollno()});
			}
			column.addAll(ResultDA.result(student));
			column.add("Total");
			model.setColumnIdentifiers(column);
			System.out.println("column added");

			getReuslts(model,student);
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
	}
}
}
