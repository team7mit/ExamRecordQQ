package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.*;


public class Department_And_Subject extends dataentry{
	
	public Department_And_Subject(){
		
		setLayout(null);
	
		JPanel p1=new JPanel();		
		p1.setLayout(null);
		JPanel p2=new JPanel(); 
		p2.setLayout(null);
		
		
		p1.setBounds(50,50,390,230);
		add(p1);
		p2.setBounds(50,304,390,170);
		add(p2);
		subcodelabel.setBounds(50,50,90,25);
		p1.add(subcodelabel);
		subcodefield.setBounds(150,50,200,25);
		p1.add(subcodefield);
		
		
		deptidlabel.setBounds(50,85,90,25);
		p1.add(deptidlabel);
		deptidfield.setBounds(150,85,200,25);
		p1.add(deptidfield);
		
		courselabel.setBounds(50,120,90,25);
		p1.add(courselabel);
		coursefield.setBounds(150,120,100,25);
		p1.add(coursefield);
		
		acayearlabel.setBounds(50,155,90,25);
		p1.add(acayearlabel);	
		academicfield.setBounds(150,155,100,25);
		p1.add(academicfield);
		
		p1.setBorder(BorderFactory.createTitledBorder("Subject Data Info"));
		p2.setBorder(BorderFactory.createTitledBorder("Choose Option"));
		
	
		radiofirst.setBounds(50,50,150,25);
		p2.add(radiofirst);
		radiosecond.setBounds(200,50,150,25);
		p2.add(radiosecond);
		tutobox.setBounds(50,80,150,25);
		p2.add(tutobox);
		exambox.setBounds(50,105,155,25);
		p2.add(exambox);
		
		cancel.setBounds(120,500,100,35);
		add(cancel);
		next.setBounds(250,500,100,35);
		add(next);
		

		
		
		//setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,600);
		setVisible(true);
	}
	public static void main(String[] args) {
		academiccreation();
		new Department_And_Subject();
		
	}
}
