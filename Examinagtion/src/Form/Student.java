package Form;

import java.awt.event.*;
import java.sql.SQLException;
import java.util.List;

import javax.swing.*;

import DataAccess.AcademicDA;
import Model.AcademicModel;
import DataAccess.MajorDA;
import DataAccess.StudentDA;
import Model.MajorModel;
import Model.StudentModel;

public class Student extends dataentry implements ActionListener{
	JLabel studentIDLabel,nameLabel,rollnolabel,academiclabel,majorlabel;
	JTextField stuIdField,tf2,rollnofield;
	JButton add,delete,find;
	
	
	String academicid = null;
	String majorid=null;
	
	JFrame f=new JFrame();
	public Student()
	{
		
		studentIDLabel=new JLabel("Student ID");
		nameLabel=new JLabel("student Name");
		rollnolabel=new JLabel("Roll No");
		academiclabel=new JLabel("Academic ID");
		majorlabel=new JLabel("Major");
		
		stuIdField=new JTextField();
		tf2=new JTextField();
		rollnofield=new JTextField();
		
		
		add=new JButton("ADD");
		delete=new JButton("DELETE");
		find=new JButton("FIND");
	
		
		studentIDLabel.setBounds(20,50,100,20);
		nameLabel.setBounds(20,90,100,20);
		rollnolabel.setBounds(20,130,100,20);
		academiclabel.setBounds(20,170,100,20);
		majorlabel.setBounds(20,210,100,20);
		
		stuIdField.setBounds(150,50,150,20);
		tf2.setBounds(150,90,150,20);
		rollnofield.setBounds(150,130,150,20);
		academicfield.setBounds(150,170,150,20);
		majorfield.setBounds(150,210,150,20);
		
		add.setBounds(30,270,80,20); add.setFocusable(false);
		delete.setBounds(150,270,80,20);delete.setFocusable(false);
		find.setBounds(270,270,80,20); find.setFocusable(false);
		
		
		
		add.addActionListener(this);
		delete.addActionListener(this);
		find.addActionListener(this);
		academicfield.addActionListener(this);
		majorfield.addActionListener(this);
		
		try {
			List<StudentModel> list=AcademicDA.combo();
			for(StudentModel g:list){
				academicfield.addItem(g.getAcademicID());
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		try {
				List<StudentModel> list=MajorDA.majorcombo();
				for(StudentModel g: list){
					majorfield.addItem(g.getMajorID());
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		
		f.setTitle("TEAM-7(MIT)");
		f.add(studentIDLabel);f.add(nameLabel);f.add(rollnolabel);f.add(academiclabel);f.add(majorlabel);
		f.add(stuIdField);f.add(tf2);f.add(rollnofield);f.add(academicfield);f.add(majorfield);
		f.add(add);f.add(delete);f.add(find);
		f.setSize(400,400);
		f.setLayout(null);
		f.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{	
		if(e.getSource()==add){
			
		System.out.println(academicid);
		
			if(stuIdField.getText().equals("") || tf2.getText().equals("") || rollnofield.getText().equals("")){
				JOptionPane.showMessageDialog(f,"Fill Requirements");
			}
			else{
				
				StudentModel student=new StudentModel();
				student.setAcademicID(academicfield.getSelectedItem().toString());
				student.setMajorID(majorfield.getSelectedItem().toString());
				student.setRollno(rollnofield.getText());
				student.setStuid(stuIdField.getText().toUpperCase());
				student.setStuname(tf2.getText().toUpperCase());
				
				try {
					boolean check=StudentDA.show(student);
					
					if(check){
						
						JOptionPane.showMessageDialog(f," Student ID OR ROLL NO Already EXISTS");
					}
					else{
						boolean mission=StudentDA.insertStudent(student);
						if(mission){
							JOptionPane.showMessageDialog(f,"Insert Success");
							}
						else{
							JOptionPane.showMessageDialog(f, "Insert Failed ");
					}
					}
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		}
		if(e.getSource()==delete){
			
			StudentModel student=new StudentModel();
			student.setStuid(stuIdField.getText());
			if(stuIdField.getText().equals("")){
				JOptionPane.showMessageDialog(f,"INSERT STUDENT_ID TO DELETE!!!!");
			}
			else{
				try {
					boolean check=StudentDA.delete(student);
					//JOptionPane.showConfirmDialog(f, "Are You sure want to delete");
					if(check){
						JOptionPane.showMessageDialog(f,"Student Delete");
					}
					else{
						JOptionPane.showMessageDialog(f, "CHECK ID AGAIN ");
					}
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
			}
		}
		if(e.getSource()==find){
			StudentModel student=new StudentModel();
			student.setStuid(stuIdField.getText());
			student.setAcademicID(academicid);
		}
	}
	public static void main(String[] args)
	{
		new Student();
		
	}

}
