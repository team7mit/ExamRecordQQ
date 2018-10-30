package gui;

import java.awt.BorderLayout;

import javax.swing.*;

public class View extends dataentry{
	
	JRadioButton r1=new JRadioButton("Find Student Marks");
	JRadioButton r2=new JRadioButton("Semester Report");
	
	
	public View()
	{
		setTitle("Team-7(MIT)");
		button.add(r1);
		button.add(r2);
		
		p1.add(r1);
		p1.add(r2);
		
		add(p1,BorderLayout.CENTER);
		
		p2.add(next);
		add(p2,BorderLayout.SOUTH);
		
		setLocation(400,200);
		setSize(300,200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new View();
	}
	

}
