package gui;

import java.awt.Font;

import javax.swing.*;

public class Marks extends dataentry{
	
	protected String column[]={"No","Subject Code","Subject Name","Marks","Remarks"};
	protected String data[][]={};
	
	public Marks()
	{
		JTable ta=new JTable(data,column);
		jsp=new JScrollPane(ta);
		setLayout(null);
		
		jsp.setBounds(50,220,1270,430);
		add(jsp);
		
		schoolname.setBounds(570,25,250,25);
		schoolname.setFont(new Font("Tahoma",Font.BOLD,14));
		add(schoolname);
		
		//ceit.setBounds(520,50,350,25);
		//ceit.setFont(new Font("Tahoma",Font.BOLD,14));
		//add(ceit);
		
		sturesult.setBounds(640,75,200,25);
		sturesult.setFont(new Font("Tahoma",Font.BOLD,14));
		add(sturesult);
		        
		acayearlabel.setBounds(600,100,200,25);
		acayearlabel.setFont(new Font("Tahoma",Font.BOLD,14));
		add(acayearlabel);
		
		stunamelabel.setBounds(50,150,100,25);
		stunamelabel.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(stunamelabel);
		
		stuidlabel.setBounds(50,175,100,25);
		stuidlabel.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(stuidlabel);
		
		rollnolabel.setBounds(1100,175,250,25);
		rollnolabel.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(rollnolabel);
		
		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
	}
	
	public static void main(String args[])
	{
		new Marks();
	}

}
