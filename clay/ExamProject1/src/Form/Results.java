package Form;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DataAccess.AcademicDA;
import DataAccess.MajorDA;
import DataAccess.ResultDA;
import DataAccess.SubjectDA;
import Model.AcademicModel;
import Model.CourseModel;
import Model.MajorModel;
import Model.StudentModel;
import Model.SubjectModel;

public class Results extends Home implements ActionListener{
	private JTable table;
	JFrame frame=new JFrame();
	DefaultTableModel model=new DefaultTableModel();
	public Results() throws SQLException {
		
	Vector<String> column=new Vector<String>();
		column.add("No");
		column.add("Name");
		column.add("Roll No");
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		frame.add(scrollPane, BorderLayout.CENTER);
	column.addAll(ResultDA.result());
	column.add("Total");
	model.setColumnIdentifiers(column);
			for(String s: column)
			System.out.println(s+"NLK");
			nextbut.addActionListener(this);
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
