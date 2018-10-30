package gui;

import java.awt.Font;

import javax.swing.*;

import com.sun.prism.paint.Color;

public class insertmarks extends dataentry {
public insertmarks(){
	
	String data[][]={};
	String columns[]={"No","Subject Code","Subject Name"," Tutorial Marks","Practical Marks","Examination Mark","Total","Remarks"};
	setLayout(null);
	JPanel p1=new JPanel();
	p1.setLayout(null);
JTable table=new JTable(data,columns);
table.setBounds(50,150,900,500);
add(table);
	rollnolabel.setBounds(50,50,200,25);
	add(rollnolabel);
	
	stunamelabel.setBounds(50,80,200,25);
	add(stunamelabel);
	
	firstsemester.setBounds(600,100,100,50);
	add(firstsemester);

	setSize(1000,600);
	setVisible(true);
}
public static void main(String[] args) {
	new insertmarks();
}

}
