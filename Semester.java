package gui;

import java.awt.Font;

import javax.swing.*;


public class Semester extends dataentry{
	
	protected String column[]={"No","Student Name","Roll No","Code","Marks","Remarks"};
	protected String data[][]={};
	
	public Semester(){
		JTable ta=new JTable(data,column);
		jsp=new JScrollPane(ta);
		setLayout(null);
		
		
		jsp.setBounds(50,180,1270,500);
		add(jsp);
		
		schoolname.setBounds(570,25,250,25);
		schoolname.setFont(new Font("Tahoma",Font.BOLD,14));
		add(schoolname);
		
		//ceit.setBounds(520,50,350,25);
		//ceit.setFont(new Font("Tahoma",Font.BOLD,14));
		//add(ceit);
		
		coding.setBounds(640,75,200,25);
		coding.setFont(new Font("Tahoma",Font.BOLD,14));
		add(coding);
		        
		acayearlabel.setBounds(600,100,200,25);
		acayearlabel.setFont(new Font("Tahoma",Font.BOLD,14));
		add(acayearlabel);
		
		courselabel.setBounds(50,125,100,25);
		add(courselabel);
		
		subjectnamelabel.setBounds(50,150,100,25);
		add(subjectnamelabel);
		
		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
	}
	public static void main(String args[])
	{
		new Semester();
	}
}
