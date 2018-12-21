package Form;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DataAccess.MarkDA;
import Model.StudentModel;

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
		
		Department_And_Subject.addComboBox();
		
		frame.setSize(500,500);
		frame.setVisible(true);
		
	}
public static void main(String[] args) {
	new ReMarksForm();
}
@Override
public void actionPerformed(ActionEvent e) {
ShowStuMarks.putSubject(e);
StudentModel student=new StudentModel();
	student.setAcademicID(academicfield.getSelectedItem().toString());
	student.setMajorID(majorfield.getSelectedItem().toString());
	
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
