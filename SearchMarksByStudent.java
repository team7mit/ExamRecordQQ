package gui;

import javax.swing.BorderFactory;

public class SearchMarksByStudent extends dataentry {
	
	public SearchMarksByStudent()
	{
		setLayout(null);
		p1.setLayout(null);
		p1.setBounds(25,25,380,400);
		
		next.setBounds(290, 430, 90, 30);
		add(next);
		
		stuidlabel.setBounds( 25, 50, 100, 20);
		p1.add(stuidlabel);
		
		stunamelabel.setBounds( 25, 100, 100, 20);
		p1.add(stunamelabel);
		
		rollnolabel.setBounds( 25, 150, 100, 20);
		p1.add(rollnolabel);
		
		deptidlabel.setBounds( 25, 200, 100, 20);
		p1.add(deptidlabel);
		
		courselabel.setBounds( 25, 250, 100, 20);
		p1.add(courselabel);
		
		acayearlabel.setBounds( 25, 300, 100, 20);
		p1.add(acayearlabel);
		
		stuidfield.setBounds( 150, 50, 200, 20);
		p1.add(stuidfield);
		
		stunamefield.setBounds( 150, 100, 200, 20);
		p1.add(stunamefield);
		
		rollnofield.setBounds( 150, 150, 200, 20);
		p1.add(rollnofield);
		
		deptidfield.setBounds(150, 200, 200, 20);
		p1.add(deptidfield);
		
		coursefield.setBounds(150, 250, 200, 20);
		p1.add(coursefield);
		
		academicfield.setBounds(150, 300, 200, 20);
		p1.add(academicfield);
		
		radiofirst.setBounds(40, 350, 150, 20);
		p1.add(radiofirst);
		
		radiosecond.setBounds(190, 350, 170, 20);
		p1.add(radiosecond);
		add(p1);
		p1.setBorder(BorderFactory.createTitledBorder("Student Data Entry"));
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(450,550);
		setVisible(true);
	}
	public static void main(String args[])
	{
		new SearchMarksByStudent();
	}

}
