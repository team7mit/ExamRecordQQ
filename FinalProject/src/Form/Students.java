package Form;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import DataAccess.AcademicDA;
import DataAccess.MajorDA;
import DataAccess.StudentDA;
import Model.AcademicModel;
import Model.MajorModel;
import Model.StudentModel;

public class Students extends Home implements ActionListener {

	
	
	public static void insertStudents(){
		//System.out.println("Student Frame");
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
			
			find.setBounds(295,400,80,20);
			insertdata.add(find);
			find.setFocusable(false);
			
			add.addActionListener(new ActionListener(){

					
				
				public void actionPerformed(ActionEvent e) {
					StudentModel student=new StudentModel();
					student.setAcademicID(academicfield.getSelectedItem().toString());
					//System.out.println(student.getAcademicID());
					student.setMajorID(majorfield.getSelectedItem().toString());
					//System.out.println(student.getMajorID()+"BLA");
					student.setRollno(rollnofield.getText());
					student.setStuid(stuIdField.getText().toUpperCase());
					student.setStuname(stunamefield.getText().toUpperCase());
					if(stuIdField.getText().equals("") || stunamefield.getText().equals("") || rollnofield.getText().equals("")){
						JOptionPane.showMessageDialog(c,"Fill Requirements");
					}
					else{
						
						
						try {
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
							
						} catch (SQLException e1) {
							
							e1.printStackTrace();
						}
					}
					
					
				}
				
			});
			try {
				List<AcademicModel> list=AcademicDA.combo();
				for(AcademicModel g:list){
					academicfield.addItem(g.academicID);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			try {
					List<MajorModel> list=MajorDA.majorcombo();
					for(MajorModel g: list){
						majorfield.addItem(g.getMajorID());
						System.out.println(g.getMajorID());
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		}
		
	});
}
	public void actionPerformed(ActionEvent e)
	{
		
		/*if(e.getSource()==academicbox){
			
			JComboBox<AcademicModel> c = (JComboBox<AcademicModel>) e.getSource();
		      AcademicModel item = (AcademicModel) c.getSelectedItem();
		      System.out.println(item.getAcademicID());
		      academicid=item.getAcademicID();
		      
		}
		if(e.getSource()==majorbox){
			@SuppressWarnings("unchecked")
			JComboBox<MajorModel> c = (JComboBox<MajorModel>) e.getSource();
		      MajorModel item = (MajorModel) c.getSelectedItem();
		      System.out.println(item.getMajorID());
		      majorid=item.getMajorID();
		      System.out.println(majorid+"NULLLLL");
		}*/
		
		/*if(e.getSource()==add){
			
		System.out.println(academicid);
		
			if(stuIdField.getText().equals("") || stunamefield.getText().equals("") || rollnofield.getText().equals("")){
				JOptionPane.showMessageDialog(this,"Fill Requirements");
			}
			else{
				
				StudentModel student=new StudentModel();
				student.setAcademicID(academicid);
				student.setMajorID(majorbox.getSelectedItem().toString());
				System.out.println(student.getMajorID()+"BLA");
				student.setRollno(rollnofield.getText());
				student.setStuid(stuIdField.getText().toUpperCase());
				student.setStuname(stunamefield.getText().toUpperCase());
				
				
				try {
					boolean check=StudentDA.show(student);
					
					if(check){
						
						JOptionPane.showMessageDialog(this," Student ID OR ROLL NO Already EXISTS");
					}
					else{
						boolean mission=StudentDA.insertStudent(student);
						if(mission){
							JOptionPane.showMessageDialog(this,"Insert Success");
							}
						else{
							JOptionPane.showMessageDialog(this, "Insert Failed ");
					}
					}
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		}*/
		if(e.getSource()==delete){
			
			StudentModel student=new StudentModel();
			student.setStuid(stuIdField.getText());
			if(stuIdField.getText().equals("")){
				JOptionPane.showMessageDialog(this,"INSERT STUDENT_ID TO DELETE!!!!");
			}
			else{
				try {
					boolean check=StudentDA.delete(student);
					//JOptionPane.showConfirmDialog(f, "Are You sure want to delete");
					if(check){
						JOptionPane.showMessageDialog(this,"Student Delete");
					}
					else{
						JOptionPane.showMessageDialog(this, "CHECK ID AGAIN ");
					}
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
			}
		}
	}

}