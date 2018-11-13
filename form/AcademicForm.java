package form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import dataAccess.AcademicDA;

import model.Academic;
public class AcademicForm  {
JLabel l1,l2;
JTextField tf1,tf2;
JButton b1,b2;
JTable t1;
JScrollPane sp1;
AcademicForm()
{
	final JFrame f=new JFrame();
	l1=new 
	JLabel("Academic ID");
	l2=new JLabel("Academic");
	tf1=new JTextField();
	tf2=new JTextField();
	b1=new JButton("DELETE");
	b2=new JButton("INSERT");
	
	l1.setBounds(20,50,150,20);
	l2.setBounds(20,90,150,20);
	tf1.setBounds(150,50,150,20);
	tf2.setBounds(150,90,150,20);
	b1.setBounds(70,150,80,20);
	b2.setBounds(220,150,80,20);
	
	
	
	
	b2.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Academic academic=new Academic();
			academic.setAcaid(tf1.getText());
			academic.setAcayear(tf2.getText());
			
			
			
			if(tf1.getText().equals(null) || tf1.getText().equals("") || tf2.getText().equals(null) || tf2.getText().equals("")){
			JOptionPane.showMessageDialog(f,"Fill Requirements");
			}
			else{
				boolean check;
				try {
					check = AcademicDA.AddAcademic(academic);
					if(check){
				JOptionPane.showMessageDialog(f,"Insert Successfully");
				}
				else{
					JOptionPane.showMessageDialog(f,"Insert Failed");
				}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
		
	});

	String columns[]={"Academic ID","Academic"};
	String values[][]={};
	t1=new JTable(values,columns);
	sp1=new JScrollPane(t1);
	sp1.setBounds(380,50,300,100);
	f.setTitle("TEAM-7(MIT)");
	f.add(l1);f.add(l2);f.add(tf1);f.add(tf2);
	f.add(b1);f.add(b2);f.add(sp1);
	f.setSize(800,300);
	f.setLayout(null);
	f.setVisible(true);
}

public static void main(String[]args)
{
	new AcademicForm();
}

}
