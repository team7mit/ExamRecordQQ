package Form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import DataAccess.MarkDA;
import DataAccess.MyCellRenderer;
import DataAccess.SubjectDA;
import Model.AcademicModel;
import Model.CourseModel;
import Model.MajorModel;
import Model.SemesterModel;
import Model.StudentModel;
import Model.SubjectModel;

import java.awt.BorderLayout;
import java.awt.Font;

@SuppressWarnings("serial")
public class MarksForm extends dataentry implements ActionListener{
	
	JFrame frame=new JFrame();
	JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblFirstSemester;
	private JPanel panel_1;
	private static JTable table;
	JButton btnSave = new JButton("Save");
	JButton btnTotal=new JButton("Total");
	static DefaultTableModel model=new DefaultTableModel();
	int i=1;
	static StudentModel student1=new StudentModel();
	//{"No","Name","Roll","Tutorial","Practical","Exam"};
	Vector<String> columns=new Vector<String>();
	
	
	public MarksForm(StudentModel student){
		
		student1.setAcademicID(student.getAcademicID());
		student1.setMajorID(student.getMajorID());
		student1.setCourse(student.getCourse());
		columns.add("No");
		columns.add("Name");
		columns.add("Roll");
		columns.addElement("Tutorial");
		columns.add("Practical");
		columns.add("Exam");
		
		model.setColumnIdentifiers(columns);
		
		panel=new JPanel();
		
		getContentPane().add(panel,"North");
		panel.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel = new JLabel("MANDALAY TECHNOLOGICAL UNIVERSTIY");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel, BorderLayout.NORTH);
		
		lblNewLabel_1 = new JLabel(student.getMajorname());
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1, BorderLayout.CENTER);
		
		lblFirstSemester = new JLabel(student.getAcademic());
		lblFirstSemester.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblFirstSemester, BorderLayout.SOUTH);
		
		panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblCourse = new JLabel("Course:");
		lblCourse.setBounds(57, 36, 64, 14);
		panel_1.add(lblCourse);
		
		JLabel label = new JLabel(student.getCourse());
		label.setBounds(131, 36, 100, 14);
		panel_1.add(label);
		
		JLabel lblSubjectCode = new JLabel("Subject Code:");
		lblSubjectCode.setBounds(26, 67, 95, 14);
		panel_1.add(lblSubjectCode);
		
		 subcodefield = new JComboBox<>();
		subcodefield.setBounds(121, 67, 100, 25);
		panel_1.add(subcodefield);
		subcodefield.setMaximumRowCount(5);
		
		JLabel lblSemester = new JLabel("Semester:");
		lblSemester.setBounds(1140, 50, 62, 14);
		panel_1.add(lblSemester);
		
		JLabel label_2 = new JLabel(student.getSemester());
		label_2.setBounds(1229, 50, 150, 14);
		panel_1.add(label_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 108, 1300,477);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(90);
		
		scrollPane.setViewportView(table);
		
		StudentModel sub=new StudentModel();
		sub.setSemester(student.getSemester());
		sub.setMajorID(student.getMajorID());
		sub.setCourse(student.getCourse());
		
			if(subcodefield.getSelectedItem()==null){
				
				Department_And_Subject.subjectcode(sub);
				
			}
			else{
				subcodefield.removeAllItems();
				Department_And_Subject.subjectcode(sub);
			}
			
		
		
		btnSave.setBounds(1237, 606, 89, 23);
		panel_1.add(btnSave);
		
		btnTotal.setBounds(1100,606,89,23);
		panel_1.add(btnTotal);
		
		btnSave.addActionListener(this);
		btnTotal.addActionListener(this);
		subcodefield.addActionListener(this);
		
		start();
		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
		
	}

	public static boolean checkmark(DefaultTableModel model1) {
		int row=model1.getRowCount();
		int column=model1.getColumnCount();
		int tuto;
		int practical;
		double total;
		double exam;
		boolean check=false;
for(int i=0;i<row;i++){
	
	tuto=Integer.parseInt(model1.getValueAt(i,3).toString());
	practical=Integer.parseInt(model1.getValueAt(i,4).toString());
	exam=Integer.parseInt(model1.getValueAt(i, 5).toString()) * 0.8;
		total=tuto+practical+exam;
	if( (tuto+practical) > 20 || total > 100 || tuto < 0 || exam < 0 || practical < 0 ) {
		check = false;
	}
	else check= true;
}
		return check;
		
	}
	
	public static void getTotalMark(DefaultTableModel model1) {
		
		
		int row=model1.getRowCount();
		int column=model1.getColumnCount()-1;
		int tuto;
		int practical;
		double total;
		double exam;
		
		for(int i=0;i<row;i++) {
			
			tuto=Integer.parseInt(model1.getValueAt(i,3).toString());
			practical=Integer.parseInt(model1.getValueAt(i,4).toString());
			exam=Integer.parseInt(model1.getValueAt(i,5).toString()) * 0.8;
			
			total=tuto+practical+exam;
		
			model1.setValueAt((int)total, i, column);
			table.getColumnModel().getColumn(column).setCellRenderer(new MyCellRenderer());
			
			
		}
		
	}
	public static void start() {
		try {
			model.setRowCount(0);
			student1.setSubcode(subcodefield.getSelectedItem().toString());
			List<StudentModel> list=MarkDA.insertMark(student1);
			int i=1;
			for(StudentModel student: list) {
				model.addRow(new Object[] {i++,student.getStuname(),student.getRollno()});
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
public void actionPerformed(ActionEvent e) {

	if(e.getSource()==subcodefield) {
		start();
	}
	
	if(e.getSource()==btnTotal) {
		if(i==1) {
		model.addColumn("Total");
		i++;
		}
		getTotalMark(model);
	}
	

	if(e.getSource()==btnSave){
		
	
		if(checkmark(model))
		{
			student1.setSubcode(subcodefield.getSelectedItem().toString());
			try {
				boolean check=MarkDA.insertexamMark(model, student1);
					if(check)
						JOptionPane.showMessageDialog(this, "Insert Successfully","Success", JOptionPane.INFORMATION_MESSAGE);
					else 
						JOptionPane.showMessageDialog(this, "Insert Failed Check Again", "Failed", JOptionPane.ERROR_MESSAGE);
			} catch (SQLException e1) {
				
				e1.printStackTrace(); 
			}		
		}
		else {
			JOptionPane.showMessageDialog(this, "Insert Failed Check Again", "Failed", JOptionPane.ERROR_MESSAGE);
		}
	}
}
}
