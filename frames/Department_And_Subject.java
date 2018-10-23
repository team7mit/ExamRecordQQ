package frames;

import java.awt.BorderLayout;

import javax.swing.*;

public class Department_And_Subject extends dataentry{
	
	public Department_And_Subject(){
		
		setLayout(new BorderLayout());
		
		
		add(academicfield,"North");
		add(rollnofield,"South");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		setSize(500,500);
		setVisible(true);
	}
	public static void main(String[] args) {
		academiccreation();
		new Department_And_Subject();
		
	}
}
