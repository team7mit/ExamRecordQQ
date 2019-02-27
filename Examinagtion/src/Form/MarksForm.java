package Form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import DataAccess.MarkDA;
import Model.StudentModel;

import java.awt.BorderLayout;
import java.awt.Font;

@SuppressWarnings("serial")
public class MarksForm extends JFrame implements ActionListener{
	JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblFirstSemester;
	private JPanel panel_1;
	private JTable table;
	JButton btnSave = new JButton("Save");
	DefaultTableModel model=new DefaultTableModel();
	public MarksForm(){
		
		String columns[]={"No","Name","Roll","Tutorial","Exam","Practical","Total"};
		//String data[][]={};
		
		model.setColumnIdentifiers(columns);
		
		panel=new JPanel();
		//panel.setLayout(null);
		
		
		try {
			MarkDA.insertMark(model);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		getContentPane().add(panel,"North");
		panel.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel = new JLabel("MANDALAY TECHNOLOGICAL UNIVERSTIY");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel, BorderLayout.NORTH);
		
		lblNewLabel_1 = new JLabel("COMPUTER ENGINEERING AND INFORMATION TECHNOLOGY\r\n");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1, BorderLayout.CENTER);
		
		lblFirstSemester = new JLabel("2018-2019");
		lblFirstSemester.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblFirstSemester, BorderLayout.SOUTH);
		
		panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblCourse = new JLabel("Course:");
		lblCourse.setBounds(57, 36, 64, 14);
		panel_1.add(lblCourse);
		
		JLabel label = new JLabel("----------");
		label.setBounds(131, 36, 46, 14);
		panel_1.add(label);
		
		JLabel lblSubjectCode = new JLabel("Subject Code:");
		lblSubjectCode.setBounds(26, 67, 95, 14);
		panel_1.add(lblSubjectCode);
		
		JLabel label_1 = new JLabel("----------");
		label_1.setBounds(131, 67, 46, 14);
		panel_1.add(label_1);
		
		JLabel lblSemester = new JLabel("Semester:");
		lblSemester.setBounds(1140, 50, 62, 14);
		panel_1.add(lblSemester);
		
		JLabel label_2 = new JLabel("-----------");
		label_2.setBounds(1229, 50, 46, 14);
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
		
		
		btnSave.setBounds(1237, 606, 89, 23);
		panel_1.add(btnSave);
		
		
		btnSave.addActionListener(this);
		
		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
		
	}
	
public static void main(String args[]){
	new MarksForm();
}

public void actionPerformed(ActionEvent e) {
	if(e.getSource()==btnSave){
		
		StudentModel student= new StudentModel();
		
		student.setMajorID("");
		student.setAcademicID("");
		student.setSubcode("");
		
		try {
			MarkDA.insertexamMark(model, student);
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}		
		
	}
}
}