
package gui;

import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class InsertResult extends dataentry{
	
	protected String data[][]={ {"101","Amit","670000","4","5","6","7","8"},    
            {"102","","780000","4","5","6","7","8"},    
            {"101","Sachin","700000","4","5","6","7","8"}};    
		protected String column[]={"No","Code","Name","Roll No","Tutorial","Practical","Exam","Remarks"};  
	public InsertResult()
	{
	     
		JTable jt=new JTable(data,column);    
			          
		JScrollPane sp=new JScrollPane(jt); 
			
		p1.setLayout(null);
		
		schoolname.setBounds(570,25,250,25);
		schoolname.setFont(new Font("Tahoma",Font.BOLD,14));
		p1.add(schoolname);
		
	//	ceit.setBounds(520,50,350,25);
		//ceit.setFont(new Font("Tahoma",Font.BOLD,14));
		//p1.add(ceit);
		
		acayearlabel.setBounds(600,75,200,25);
		acayearlabel.setFont(new Font("Tahoma",Font.BOLD,14));
		p1.add(acayearlabel);
		add(p1,"Center");          
	
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
		new InsertResult();
	}

}
