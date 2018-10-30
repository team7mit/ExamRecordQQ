package gui;

import javax.swing.*;

public class student extends dataentry {
public student(){
	//Jp1anel p1=new Jp1anel();
	
	setLayout(null);
	p1.setLayout(null);
	
	p1.setBounds(25,25,350,300);
	add(p1);
	p1.setBorder(BorderFactory.createTitledBorder("Student Data Entry"));
	
	
	rollnolabel.setBounds(35,50,90,25);
	p1.add(rollnolabel);
	rollnofield.setBounds(130,50,200,25);
	p1.add(rollnofield);
	
	deptidlabel.setBounds(35,100,90,25);
	p1.add(deptidlabel);
	deptidfield.setBounds(130,100,200,25);
	p1.add(deptidfield);
	
	courselabel.setBounds(35,150,90,25);
	p1.add(courselabel);
	coursefield.setBounds(130,150,200,25);
	p1.add(coursefield);
	
	acayearlabel.setBounds(35,200,90,25);
	p1.add(acayearlabel);
	academicfield.setBounds(130,200,200,25);
	p1.add(academicfield);
	
	radiofirst.setBounds(35,250,130,25);
	p1.add(radiofirst);
	radiosecond.setBounds(170,250,150,25);
	p1.add(radiosecond);
	
	
	
	next.setBounds(230,350,80,25);
	add(next);
	cancel.setBounds(100,350,80,25);
	add(cancel);
	
	setSize(420,450);
	setVisible(true);
	
}
public static void main(String[] args) {
	new student();
}
}
