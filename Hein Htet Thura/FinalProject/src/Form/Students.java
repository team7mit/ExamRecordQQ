package Form;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DataAccess.AcademicDA;
import DataAccess.MajorDA;
import DataAccess.StudentDA;
import Model.AcademicModel;
import Model.MajorModel;
import Model.StudentModel;

public class Students extends Home implements ActionListener {

	
	 static JLabel studentIDLabel=new JLabel("Student ID");
		static JLabel nameLabel=new JLabel("student Name");
		static JLabel rollnolabel=new JLabel("Roll No");
		static JLabel academiclabel=new JLabel("Academic ID");
		static JLabel majorlabel=new JLabel("Major");
		
		static JTextField stuIdField=new JTextField("MNT-");
		static JTextField stunamefield=new JTextField();
		static JTextField rollnofield=new JTextField();
		
		static JButton add=new JButton("ADD");
		static JButton delete=new JButton("DELETE");
		
		public static boolean checkRollNoAndMajor(StudentModel student) {
			boolean check=false;
			
				String roll=student.getRollno();
				String major=student.getMajorID();
				String majors="";
				StringTokenizer rolls=new StringTokenizer(roll, ".-");
				while(rolls.hasMoreTokens()) {
					String year=rolls.nextToken();
					String convo=rolls.nextToken();
					 majors=rolls.nextToken();
					String num=rolls.nextToken();
				}
				
				if(majors.equals("major")) {
					check=true;
				}
			return check;
		}
		
	public static void insertStudents(){
		
		student.addActionListener(new ActionListener(){

		
			public void actionPerformed(ActionEvent arg0) {
				
				insertdata.removeAll();
				insertdata.validate();
				insertdata.repaint();
			c.add(insertdata,BorderLayout.CENTER);
			insertdata.setLayout(null);
			
			studentIDLabel.setBounds(75,100,90,25);
			insertdata.add(studentIDLabel);
			nameLabel.setBounds(75,150,100,25);
			insertdata.add(nameLabel);
			rollnolabel.setBounds(75,200,100,25);
			insertdata.add(rollnolabel);
			academiclabel.setBounds(75,250,100,25);
			insertdata.add(academiclabel);
			majorlabel.setBounds(75,300,100,25);
			insertdata.add(majorlabel);
			
			stuIdField.setBounds(175,100,200,25);
			insertdata.add(stuIdField);
			stunamefield.setBounds(175,150,200,25);
			insertdata.add(stunamefield);
			rollnofield.setBounds(175,200,200,25);
			insertdata.add(rollnofield);
			academicfield.setBounds(175,250,200,25);
			insertdata.add(academicfield);
			majorfield.setBounds(175,300,200,25);
			insertdata.add(majorfield);
			
			add.setBounds(70,400,80,20); 
			insertdata.add(add);
			add.setFocusable(false);
			
			delete.setBounds(185,400,80,20);
			insertdata.add(delete);
			delete.setFocusable(false);
			
			add.addActionListener(new ActionListener(){

					
				
				public void actionPerformed(ActionEvent e) {
					StudentModel student=new StudentModel();
					
					student.setAcademicID(academicfield.getSelectedItem().toString());
					
					student.setMajorID(majorfield.getSelectedItem().toString());
					
					student.setRollno(rollnofield.getText());
					student.setStuid(stuIdField.getText().toUpperCase());
					student.setStuname(stunamefield.getText().toUpperCase());
					
					
					if(stuIdField.getText().equals("") || stunamefield.getText().equals("") || rollnofield.getText().equals("")){
						JOptionPane.showMessageDialog(c,"Fill Requirements");
					}
					else
					{
						try {
							if(checkRollNoAndMajor(student)) {
							
								boolean check=StudentDA.show(student);
							
									if(check){
								
										JOptionPane.showMessageDialog(c," Student ID OR ROLL NO Already EXISTS");
									}
									else{
										boolean mission=StudentDA.insertStudent(student);
											if(mission){
												JOptionPane.showMessageDialog(c,"Insert Success");
											}
											else{
												JOptionPane.showMessageDialog(c, "Insert Failed ");
											}
									}
								}
							else {
							JOptionPane.showMessageDialog(c, " MAJOR MUST BE THE SAME!!!");
								}
						}
						catch(NoSuchElementException e1) {
							JOptionPane.showMessageDialog(c," Roll Number Format is Wrong.\n Check Again"
									+ "\nEg.IV.BE.CEIT-11");
						}
						catch (SQLException e1) {
							
							e1.printStackTrace();
						}	
						}
						
						
					}
					
				
			});
			Department_And_Subject.addComboBox();
			delete.addActionListener(new ActionListener(){

				
				public void actionPerformed(ActionEvent arg0) {
					StudentModel student=new StudentModel();
					student.setStuid(stuIdField.getText());
					if(stuIdField.getText().equals("")){
						JOptionPane.showMessageDialog(c,"INSERT STUDENT_ID TO DELETE!!!!");
					}
					else{
						try {
							boolean check=StudentDA.delete(student);
							
							if(check){
								JOptionPane.showMessageDialog(c,"Student Delete");
							}
							else{
								JOptionPane.showMessageDialog(c, "CHECK ID AGAIN ");
							}
						} catch (SQLException e1) {
							
							e1.printStackTrace();
						}
						
					}
					
					
				}
				
			});
		
		
			}
		
	});
		
}

}
