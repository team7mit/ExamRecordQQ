package Form;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DataAccess.MyCellRenderer;
import DataAccess.ShowStuMarksDA;
import Model.AcademicModel;
import Model.StudentModel;
import Model.SubjectModel;

@SuppressWarnings("serial")
public class ShowStuMarks extends Home {
	
	public static JTable table;
	public static DefaultTableModel model;
	
	static JButton show=new JButton("Show Marks");
	
	@SuppressWarnings("unchecked")
	
public static void ShowStudentMark(){
		
		showStuMarks.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg) {
				
				
				insertdata.removeAll();
				insertdata.validate();
				insertdata.repaint();
				
				c.add(insertdata,BorderLayout.CENTER);
				insertdata.setLayout(null);
				

				acayearlabel.setBounds(50,50,90,25);
				insertdata.add(acayearlabel);
				academicfield.setBounds(150,50,150,25);
				insertdata.add(academicfield);
				
				majornamelabel.setBounds(50,100,90,25);
				insertdata.add(majornamelabel);
				majorfield.setBounds(150,100,150,25);
				insertdata.add(majorfield);
				
				courselabel.setBounds(50,150,90,25);
				insertdata.add(courselabel);
				coursefield.setBounds(150,150,150,25);
				insertdata.add(coursefield);
				
				semester.setBounds(50,200,150,25);
				insertdata.add(semester);	
				semesterfield.setBounds(150,200,150,25);
				insertdata.add(semesterfield);
				
				subcodelabel.setBounds(50,250,90,25);
				insertdata.add(subcodelabel);
				subcodefield.setBounds(150,250,150,25);
				insertdata.add(subcodefield);
				
				show.setBounds(100,300,150,30);
				
				insertdata.add(show);
				
				
				//table
				Object[] columns={"No","Name","Roll","Tutorial","Exam","Practical","Total"};
				model=new DefaultTableModel();
				model.setColumnIdentifiers(columns);
				table=new JTable();
				table.setModel(model);
				table.setRowHeight(20);
				jsp=new JScrollPane(table);
				jsp.setBounds(350,50,1000,600);
				insertdata.add(jsp);
				table.setCellSelectionEnabled(false);
				
				subcodefield.setMaximumRowCount(3);
				Department_And_Subject.addComboBox();
				
				c.setExtendedState(MAXIMIZED_BOTH);
				show.addActionListener(new ActionListener() {

					
					public void actionPerformed(ActionEvent arg0) {
						if(subcodefield.getSelectedItem()==null){
							JOptionPane.showMessageDialog(c,"Enter Subcode");
						}
						
						else{
						model.setRowCount(0);// Reset Table
						table.setEnabled(false);
						StudentModel student=new StudentModel();
						AcademicModel academicmodel=(AcademicModel) academicfield.getSelectedItem();
						
						
					student.setAcademicID(academicmodel.academicID);//change
					student.setMajorID(majorfield.getSelectedItem().toString());
					student.setSubcode(subcodefield.getSelectedItem().toString());
					
						//System.out.println(student.academicID);
						//System.out.println(student.majorID);
						//System.out.println(student.subcode);
						
						try {
							// Get Students' Data from DataBase and add to table
							List<StudentModel> list=ShowStuMarksDA.showMarks(model,student);
							int i=1;
							for(StudentModel studentlist: list){
							model.addRow(new Object[]{i++,studentlist.getStuname(),studentlist.getRollno(),studentlist.getTutorial(),studentlist.getPractical(),studentlist.getExam(),studentlist.getTotal()});
							table.getColumnModel().getColumn(6).setCellRenderer(new MyCellRenderer());
							
							}
							table.setCellSelectionEnabled(false);
							table.setColumnSelectionAllowed(false);
		
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
						
					}
					
				});
			}
		});
	}
	@SuppressWarnings("unchecked")
	public static void addsubcode(List<SubjectModel> list){
		for(SubjectModel g1: list){
					subcodefield.addItem(g1);
			}
			
		}
}
