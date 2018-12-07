package gui;

import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TutorialAndPratical extends dataentry{
	
	String column[]={"No","Student Name","Roll No","Tutorial","Practical","Remarks"};
	String data[][]={};
	
	public TutorialAndPratical()
	{
	    
			JTable jt=new JTable(data,column);    
			          
			JScrollPane sp=new JScrollPane(jt);
			
			p1.setLayout(null);
			
			schoolname.setBounds(570,25,250,25);
			schoolname.setFont(new Font("Tahoma",Font.BOLD,14));
			p1.add(schoolname);
			
			//ceit.setBounds(520,50,350,25);
			//ceit.setFont(new Font("Tahoma",Font.BOLD,14));
			//p1.add(ceit);
			
			tutoandpra.setBounds(600,75,200,25);
			tutoandpra.setFont(new Font("Tahoma",Font.BOLD,14));
			add(tutoandpra);
			        
			acayearlabel.setBounds(600,100,200,25);
			acayearlabel.setFont(new Font("Tahoma",Font.BOLD,14));
			add(acayearlabel);         
		
			courselabel.setBounds(50,125,100,25);
			p1.add(courselabel);
			
			subjectnamelabel.setBounds(50,150,100,25);
			p1.add(subjectnamelabel);
			setExtendedState(MAXIMIZED_BOTH);
			sp.setBounds(50,180,1270,500);
			p1.add(sp);
		
			add(p1);
			    
			jt.setRowHeight(20);
			setUndecorated(false);
			
			setVisible(true);
	}
	public static void main(String[] args) {
		new TutorialAndPratical();
	}

}