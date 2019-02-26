package Form;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import DataAccess.SubjectDA;
import Model.SubjectModel;

public class Subject extends Home{
	
	static JLabel code=new JLabel("Subject Code");
	static JLabel name=new JLabel("Subject Name");
	
	
	static JTextField codefield=new JTextField();
	static JTextField namefield=new JTextField();
	
	static JButton b2=new JButton("DELETE");
	static JButton b1=new JButton("INSERT");
	
	public static void insertNewSubject(){
		
		
		
		subject.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent arg0) {
				
				insertdata.removeAll();
				insertdata.validate();
				insertdata.repaint();
				
				c.add(insertdata,BorderLayout.CENTER);
				insertdata.setLayout(null);
				
				code.setBounds(75,100,90,25);
				insertdata.add(code);
				name.setBounds(75,150,90,25);
				insertdata.add(name);
				courselabel.setBounds(75,200,90,25);
				insertdata.add(courselabel);
				semester.setBounds(75,250,90,25);
				insertdata.add(semester);
				majornamelabel.setBounds(75,300,90,25);
				insertdata.add(majornamelabel);
				
				codefield.setBounds(175,100,200,25);
				insertdata.add(codefield);
				namefield.setBounds(175,150,200,25);
				insertdata.add(namefield);
				coursefield.setBounds(175,200,200,25);
				insertdata.add(coursefield);
				semesterfield.setBounds(175,250,200,25);
				insertdata.add(semesterfield);
				majorfield.setBounds(175,300,200,25);
				insertdata.add(majorfield);
				
				b1.setBounds(295,400,80,20);
				insertdata.add(b1);
				b1.setFocusable(false);
				
				b2.setBounds(185,400,80,20);
				insertdata.add(b2);
				b2.setFocusable(false);
				
			}
			
		});
		
		Department_And_Subject.addComboBox();
		
		b1.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent arg0) {

				SubjectModel subject=new SubjectModel();
				subject.setSubcode(codefield.getText());
				subject.setSubname(namefield.getText());
				subject.setCourse(coursefield.getSelectedItem().toString());
				subject.setSemester(semesterfield.getSelectedItem().toString());
				subject.setMajorID(majorfield.getSelectedItem().toString());
				
				if(codefield.equals("") || codefield.equals(null) || namefield.equals("") || namefield.equals(null)){
					
					JOptionPane.showMessageDialog(c,"Fill Requirements...","WARNING",JOptionPane.WARNING_MESSAGE);
				}
				else {
					
					try {
						
						boolean op=SubjectDA.insertSubject(subject);
						
						if(op){
							
							codefield.setText(null);
							namefield.setText(null);
					
							JOptionPane.showMessageDialog(c,"Successfully Created");
							
						}
						else{
							JOptionPane.showMessageDialog(c," Insert Failed");
						}
						
						
						
					} catch (SQLException e1) {

						e1.printStackTrace();
					}
				}
				
				
			}
			
		});
		b2.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent arg0) {
				
				SubjectModel subject=new SubjectModel();
				subject.setSubcode(codefield.getText());
				subject.setSubname(namefield.getText());
				subject.setCourse(coursefield.getSelectedItem().toString());
				subject.setSemester(semesterfield.getSelectedItem().toString());
				subject.setMajorID(majorfield.getSelectedItem().toString());
				
				if(codefield.equals("") || codefield.equals(null) || namefield.equals("") || namefield.equals(null)){
					
					JOptionPane.showMessageDialog(c,"Fill Requirements...","WARNING",JOptionPane.WARNING_MESSAGE);
				}
				else{
				
				boolean op;
				try {
					op =SubjectDA.deleteSubject(subject);
					if(op){
						codefield.setText(null);
						namefield.setText(null);
						
						JOptionPane.showMessageDialog(null,"Delete Success!!!");
						
					}
					else{
						
						JOptionPane.showMessageDialog(null,"Delete Fail!!");
					}
				} catch (SQLException e1) {

					e1.printStackTrace();
				}
				
				}
			}
			
		});
	}

}
