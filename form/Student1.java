package form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Academic;
import model.Student;

import dataAccess.AcademicDA;
import dataAccess.Stu;



public class Student1 implements ActionListener
{
	JLabel studentIDLabel,nameLabel,rollnolabel,academiclabel,majorlabel;
	JTextField stuIdField,tf2,rollnofield,majorbox;
	JButton add,delete,find;
	JComboBox<Academic> academicbox;
	
	
	String academicid = null;
	
	JFrame f=new JFrame();
	Student1()
	{
		
		studentIDLabel=new JLabel("Student ID");
		nameLabel=new JLabel("student Name");
		rollnolabel=new JLabel("Roll No");
		academiclabel=new JLabel("Academic ID");
		majorlabel=new JLabel("Major");
		
		stuIdField=new JTextField();
		tf2=new JTextField();
		rollnofield=new JTextField();
		academicbox=new JComboBox<>();
		majorbox=new JTextField();
		
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
		academicbox.setBounds(150,170,150,20);
		majorbox.setBounds(150,210,150,20);
		
		add.setBounds(30,270,80,20); add.setFocusable(false);
		delete.setBounds(150,270,80,20);delete.setFocusable(false);
		find.setBounds(270,270,80,20); find.setFocusable(false);
		
		
		
		add.addActionListener(this);
		delete.addActionListener(this);
		find.addActionListener(this);
		academicbox.addActionListener(this);
		
		try {
			List<Academic> list=AcademicDA.combo();
			for(Academic g:list){
				academicbox.addItem(g);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
			
		
		f.setTitle("TEAM-7(MIT)");
		f.add(studentIDLabel);f.add(nameLabel);f.add(rollnolabel);f.add(academiclabel);f.add(majorlabel);
		f.add(stuIdField);f.add(tf2);f.add(rollnofield);f.add(academicbox);f.add(majorbox);
		f.add(add);f.add(delete);f.add(find);
		f.setSize(400,400);
		f.setLayout(null);
		f.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource()==academicbox){
			JComboBox<Academic> c = (JComboBox<Academic>) e.getSource();
		      Academic item = (Academic) c.getSelectedItem();
		      System.out.println(item.getAcaid());
		      academicid=item.getAcaid();
		      
		}
		
		
		if(e.getSource()==add){
			
		System.out.println(academicid);
		
			if(stuIdField.getText().equals("") || tf2.getText().equals("") || rollnofield.getText().equals("") || majorbox.getText().equals("")){
				JOptionPane.showMessageDialog(f,"Fill Requirements");
			}
			else{
				
				Student student=new Student();
				student.setAcaid(academicid);
				student.setMajorId(majorbox.getText());
				student.setRollno(rollnofield.getText());
				student.setStuid(stuIdField.getText());
				student.setStuname(tf2.getText());
				
				
				try {
					boolean check=Stu.show(student);
					
					if(check){
						
						JOptionPane.showMessageDialog(f," Student ID OR ROLL NO Already EXISTS");
					}
					else{
						boolean mission=Stu.insertStudent(student);
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
			
			Student student=new Student();
			student.setStuid(stuIdField.getText());
			if(stuIdField.getText().equals("")){
				JOptionPane.showMessageDialog(f,"INSERT STUDENT_ID TO DELETE!!!!");
			}
			else{
				try {
					boolean check=Stu.delete(student);
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
			Student student=new Student();
			student.setStuid(stuIdField.getText());
			student.setAcaid(academicid);
		}
	}
	public static void main(String[] args)
	{
		new Student1();
		
	}
}

