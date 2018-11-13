package form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import dataAccess.MarkDA;

public class Marks extends JFrame implements ActionListener{
	JTable table;
	JScrollPane jsp;
	JButton b=new JButton("ADD");
	
	public Marks(){
		
		String columns[]={"No","Name","Roll","Tutorial","Exam","Practical","Total"};
		//String data[][]={};
		DefaultTableModel model=new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		table=new JTable(model);
		jsp=new JScrollPane(table);
		
		
		try {
			MarkDA.insertMark(model);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		b.addActionListener(this);
		
		add(jsp,"Center");
		setSize(500,500);
		setVisible(true);
		
	}
	
public static void main(String args[]){
	new Marks();
}

public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==b){
		
		
		
		
		
		
		
	}
}

}
