package Form;

import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DataAccess.MajorDA;
import Model.MajorModel;
import Model.StudentModel;

public class Major extends Home{

	static JLabel majorID=new JLabel("Major ID");
	static JLabel majorname=new JLabel("Major");
	
	 static JTextField maidfield = new JTextField();
	 static JTextField manafield =new JTextField();
		static JButton insertbutton=new JButton("Insert");
		static JButton deletebutton=new JButton("DELETE");
	static Object[] row;
	
	public static void insertNewMajor(){
		
		 major.addActionListener(new ActionListener(){

				
				public void actionPerformed(ActionEvent arg0) {

					insertdata.removeAll();
					insertdata.validate();
					insertdata.repaint();
					
					c.add(insertdata,BorderLayout.CENTER);
					insertdata.setLayout(null);
					
					Object[] columns={"Major_ID","Major"};
					table=new JTable();
					model=new DefaultTableModel();
					model.setColumnIdentifiers(columns);
					table.setModel(model);
					table.setRowHeight(20);
					
					jsp=new JScrollPane(table);
					jsp.setBounds(50,100,400,150);
					insertdata.add(jsp);
					
					majorID.setBounds(75,300,90,25);
					insertdata.add(majorID);
					majorname.setBounds(75,350,90,25);
					insertdata.add(majorname);
					
					maidfield.setBounds(175,300,200,25);
					insertdata.add(maidfield);
					manafield.setBounds(175,350,200,25);
					insertdata.add(manafield);
					
					insertbutton.setBounds(200,400,80,20);
					insertdata.add(insertbutton);
					
					deletebutton.setBounds(290, 400, 80, 20);
					insertdata.add(deletebutton);
					
					cancel.setBounds(110, 400, 80, 20);
					insertdata.add(cancel);
					
					try {
						MajorDA.showMajor(model);
					} catch (SQLException e2) {
						
						e2.printStackTrace();
					}
					table.addMouseListener(new MouseAdapter(){
						
						public void mouseClicked(MouseEvent e)
						{
							int i=table.getSelectedRow();
							maidfield.setText(model.getValueAt(i, 0).toString());
							manafield.setText(model.getValueAt(i, 1).toString());
							
						}
					});
				}
		 });
		 
		 insertbutton.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent arg0) {
				
				String id=maidfield.getText();
				String major=manafield.getText();
				
				
				MajorModel m=new MajorModel();
				
				m.setMajorID(id);
				m.setMajorname(major);
				
				row=new Object[2];
				row[0]=maidfield.getText();
				row[1]=manafield.getText();
				
				
				if(id.equals("") || id.equals(null) || major.equals("") || major.equals(null)){
					
					JOptionPane.showMessageDialog(c,"Fill Requirements...","WARNING",JOptionPane.WARNING_MESSAGE);
				}
				else {
					
					try {
						
						model.addRow(row);
						
						boolean op=MajorDA.insertMajor(m);
						
						if(op){
							
							
					
							JOptionPane.showMessageDialog(c,"Successfully Created","Success",JOptionPane.INFORMATION_MESSAGE);
							maidfield.setText(null);
							manafield.setText(null);
							
						}
						else{
							JOptionPane.showMessageDialog(c," Insert Failed","Fail",JOptionPane.WARNING_MESSAGE);
						}
						
						
						
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
			 
		 }
			}
		 });
		 
		 deletebutton.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent arg0) {
				

				
				int i=table.getSelectedRow();
				if(i>=0)
				{
					model.removeRow(i);
				}
				
				String id=maidfield.getText();
				String name=manafield.getText();
				
				MajorModel major=new MajorModel();
				major.setMajorID(id);
				major.setMajorname(name);
				
				boolean op;
				try {
					op = MajorDA.deleteMajor(major);
					if(op){
						maidfield.setText(null);
						manafield.setText(null);
						
						JOptionPane.showMessageDialog(c,"Delete Success!!!");
						
					}
					else{
						
						JOptionPane.showMessageDialog(c,"Delete Fail!!");
					}
				} catch (SQLException e1) {

					e1.printStackTrace();
				}

			}
			 
		 });
		 cancel.addActionListener(new ActionListener(){

				
				public void actionPerformed(ActionEvent arg0) {
					
					maidfield.setText(null);
					manafield.setText(null);
				}
				
			});
	}
}
	
	


