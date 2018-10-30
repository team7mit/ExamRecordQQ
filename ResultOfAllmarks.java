package gui;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.*;
public class ResultOfAllmarks extends dataentry{

	
	String data[][]={};
		protected String column[]={"No","Code","Name","Roll No","Tutorial","Practical","Exam","Remarks"};  
		
		JLabel l1=new JLabel();
		JLabel l2=new JLabel();
		JLabel l3=new JLabel();
		JLabel l4=new JLabel();
		JLabel l5=new JLabel();
	
		private void datas(){
			for(int i=0;i<50;i++){
				for(int j=0;j<1;j++){
					data[i][j]=String.valueOf(i+1);
				}
			}
		}
	public ResultOfAllmarks(String semester,String course,String department,String subcode, String Academic){
		
		
	       
		JTable jt=new JTable(data,column);    
		          
		JScrollPane sp=new JScrollPane(jt);  
	
		
		p1.setLayout(null);
		
		
		schoolname.setBounds(570,25,250,25);
		schoolname.setFont(new Font("Tahoma",Font.BOLD,14));
		p1.add(schoolname);
		
		l1.setBounds(520,50,350,25);
		l1.setFont(new Font("Tahoma",Font.BOLD,14));
		p1.add(l1);
		
		l2.setText(Academic);
		l2.setBounds(600,75,100,25);
		l2.setFont(new Font("Tahoma",Font.BOLD,14));
		p1.add(l2);
		acayearlabel.setBounds(700,75,100,25);
		acayearlabel.setFont(new Font("Tahoma",Font.BOLD,14));
		p1.add(acayearlabel);
		add(p1,"Center");          
		
		
		l3.setText(course);
		
		l3.setBounds(175,125,100,25);
		p1.add(l3);
		courselabel.setBounds(50,125,100,25);
		p1.add(courselabel);
		
		l4.setText(subcode);
		l4.setBounds(175,150,100,25);
		p1.add(l4);
		subjectnamelabel.setBounds(50,150,100,25);
		p1.add(subjectnamelabel);
		setExtendedState(MAXIMIZED_BOTH);
		sp.setBounds(50,180,1270,500);
		
		l5.setText(semester);
		l5.setBounds(1200,150,150,25);
		p1.add(l5);
		
		p1.add(sp);
	
		
		//next.addActionListener(this);
		
		add(p1);
		    
		jt.setRowHeight(20);
		setUndecorated(false);
		
		setVisible(true);
	}
	/*public static void main(String[] args) {
		new ResultOfAllmarks();
	}*/
}

