package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Department_And_Subject extends dataentry implements ActionListener{
	private JFrame f=new JFrame();
	
	public Department_And_Subject(){
		//academiccreation();
		f.setLayout(null);
	
		//JPanel p1=new JPanel();		
		p1.setLayout(null);
		//JPanel p2=new JPanel(); 
	//	p2.setLayout(null);
		
		
		p1.setBounds(50,50,390,350);
		f.add(p1);
		//p2.setBounds(50,304,390,170);
		//f.add(p2);
		subcodelabel.setBounds(50,50,90,25);
		p1.add(subcodelabel);
		subcodefield.setBounds(150,50,200,25);
		p1.add(subcodefield);
		
		
		deptidlabel.setBounds(50,100,90,25);
		p1.add(deptidlabel);
		deptidfield.setBounds(150,100,200,25);
		p1.add(deptidfield);
		
		courselabel.setBounds(50,150,90,25);
		p1.add(courselabel);
		coursefield.setBounds(150,150,200,25);
		p1.add(coursefield);
		
		acayearlabel.setBounds(50,200,90,25);
		p1.add(acayearlabel);	
		academicfield.setBounds(150,200,200,25);
		p1.add(academicfield);
		
		p1.setBorder(BorderFactory.createTitledBorder("Subject Data Info"));
		//p2.setBorder(BorderFactory.createTitledBorder("Choose Option"));
		
	
		radiofirst.setBounds(50,280,150,25);
		p1.add(radiofirst);
		radiosecond.setBounds(230,280,150,25);
		p1.add(radiosecond);
		//tutobox.setBounds(50,80,150,25);
		//p2.add(tutobox);
		//exambox.setBounds(50,105,155,25);
		//p2.add(exambox);
		
		cancel.setBounds(120,450,80,25);
		f.add(cancel);
		next.setBounds(250,450,80,25);
		f.add(next);
		
		next.addActionListener(this);
		cancel.addActionListener(this);
		
		f.setTitle("TEAM-7(MIT)");
		f.setResizable(false);
		//f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setLocation(500,50);
		f.setSize(500,600);
		f.setVisible(true);
	}
	/*public static void main(String[] args) {
		academiccreation();
		new Department_And_Subject();
		
	}*/
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==next){
			if(radiofirst.isSelected()){
				new ResultOfAllmarks(radiofirst.getText(),(String)coursefield.getSelectedItem(),deptidfield.getText(),subcodefield.getText(),(String)academicfield.getSelectedItem());
			}
			if(radiosecond.isSelected()){
				new ResultOfAllmarks(radiosecond.getText(),(String)coursefield.getSelectedItem(),deptidfield.getText(),subcodefield.getText(),(String)academicfield.getSelectedItem());
			}
		}
	if(e.getSource()==cancel){
		f.dispose();
	}
		
	}
	
}
