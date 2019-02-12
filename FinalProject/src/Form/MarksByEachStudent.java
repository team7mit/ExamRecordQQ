package Form;

import java.awt.BorderLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import DataAccess.ResultDA;
import DataAccess.StudentDA;
import Model.AcademicModel;
import Model.StudentModel;
public class MarksByEachStudent extends Home implements ActionListener{
	
	JLabel sub=new JLabel();
	static JFrame frame=new JFrame();
	static JButton nextButton=new JButton("Next");
	static StudentModel st=new StudentModel();
	
	
	DefaultTableModel mo=new DefaultTableModel();
	JTable t=new JTable(mo);
	
	Object[] obj={"Subject Name","Marks"};
	
	public MarksByEachStudent(){
		
		jsp=new JScrollPane(t);
		
		frame.add(jsp,BorderLayout.CENTER);
		frame.setSize(500,600);
		frame.setVisible(true);
		
		
		
	}
	
	public static void viewEachStudentMark(){
		
		viewEachStuMark.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent arg0) {
				insertdata.removeAll();
				insertdata.validate();
				insertdata.repaint();
						
					c.add(insertdata,BorderLayout.CENTER);
					insertdata.setLayout(null);
					
					stuidlabel.setBounds(75,100,90,25);
					insertdata.add(stuidlabel);
					stuidfield.setBounds(175,100,200,25);
					insertdata.add(stuidfield);
					
					acayearlabel.setBounds(75,150,90,25);
					insertdata.add(acayearlabel);
					academicfield.setBounds(175,150,200,25);
					insertdata.add(academicfield);
					
					majornamelabel.setBounds(75,200,90,25);
					insertdata.add(majornamelabel);
					majorfield.setBounds(175,200,200,25);
					insertdata.add(majorfield);
					
					courselabel.setBounds(75,250,90,25);
					insertdata.add(courselabel);
					coursefield.setBounds(175,250,200,25);
					insertdata.add(coursefield);
					
					semester.setBounds(75,300,150,25);
					insertdata.add(semester);	
					semesterfield.setBounds(175,300,200,25);
					insertdata.add(semesterfield);
							
					nextButton.setBounds(295,350,80,25);
					insertdata.add(nextButton);
					
					
					
					Department_And_Subject.addComboBox();
					
					
					AcademicModel academicmodel=(AcademicModel) academicfield.getSelectedItem();
					st.setAcademicID(academicmodel.academicID);
					
					st.setMajorID(majorfield.getSelectedItem().toString());
					st.setCourse(coursefield.getSelectedItem().toString());
					st.setSemester(semesterfield.getSelectedItem().toString());

					
					Department_And_Subject.subjectcode(st);
					
					nextButton.addActionListener(new ActionListener(){

						
						public void actionPerformed(ActionEvent arg0) {
							try {
								st.setStuid(stuidfield.getText());
								
								boolean check=StudentDA.checkStudentExist(st);
								System.out.println(check);
								if(check){
									st.setRollno(StudentDA.StudentRollNoCheck(st));
									
									List<StudentModel> list=ResultDA.studentExamMarks(st);
									for(StudentModel stu:list){
										System.out.println(stu.getSubcode());
										System.out.println(stu.total);
									}
									
								}
								else{
									JOptionPane.showMessageDialog(c, " Student ID Does Not Exist "," sdf",JOptionPane.INFORMATION_MESSAGE);
								}
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}
						
					});
				
			}
			
		});
	}

}
