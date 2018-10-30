package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class firstpage extends dataentry implements ActionListener{
	private JFrame f=new JFrame();
	
	public firstpage(){
		
		f.setTitle("TEAM-7(MIT)");
		f.setLayout(null);
		deptsub.setBounds(50,50,200,25);
		f.add(deptsub);
		
		student.setBounds(50,75,200,25);
		f.add(student);
		
		//search.setBounds(50,100,200,25);
		//f.add(search);
		
		cancel.setBounds(50,200,80,25);
		f.add(cancel);
		
		next.setBounds(150,200,80,25);
		f.add(next);
		
		next.addActionListener(this);
		cancel.addActionListener(this);
		
		deptsub.addActionListener(this);
		student.addActionListener(this);
		//search.addActionListener(this);
		
		
		f.setResizable(true);
		f.setLocation(500,200);
		f.setSize(300,350);
		f.setVisible(true);
		
	}
	public static void main(String args[])
	{
		new firstpage();
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==next){
			if(deptsub.isSelected()){
				
			new Department_And_Subject();
			
			}
			if(student.isSelected()){
				
			}
			if(search.isSelected()){}
		}
		if(e.getSource()==cancel){
			f.dispose();
		}
	}

}
