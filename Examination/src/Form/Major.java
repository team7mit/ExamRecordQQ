package Form;

import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DataAccess.MajorDA;
import Model.MajorModel;

public class Major extends JFrame implements ActionListener{
	
	JLabel l1,l2;
	public static JTextField tf1;
	public static JTextField tf2;
	JButton b2;
	public static JTable table;
	public static DefaultTableModel model;
	JScrollPane sp1;
	Object row[];
	
	public Major()
	{
		JFrame f=new JFrame();
		
		f.setTitle("TEAM-7(MIT)");
		f.setLayout(null);
		
		l1=new JLabel("Major ID");
		l2=new JLabel("Major");
		
		tf1=new JTextField();
		tf2=new JTextField();
		
		//b1=new JButton("DELETE");
		b2=new JButton("INSERT");
		//b3=new JButton("Update");
		
		l1.setBounds(20,50,150,20);
		f.add(l1);
		l2.setBounds(20,90,150,20);
		f.add(l2);
		
		tf1.setBounds(150,50,150,20);
		f.add(tf1);
		tf2.setBounds(150,90,150,20);
		f.add(tf2);
		b2.setBounds(160,150,80,20);
		f.add(b2);
		
		//b1.setBounds(30,150,80,20);
				//f.add(b1);
		//b3.setBounds(280,150,80,20);
		//f.add(b3);
		
		table=new JTable();
		
		Object[] columns={"Major_ID","Major"};
		model=new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		table.setRowHeight(20);
		
		sp1=new JScrollPane(table);
		sp1.setBounds(400,50,350,150);
		f.add(sp1);
		
		//b1.addActionListener(this);
		b2.addActionListener(this);
		//b3.addActionListener(this);
	
		try {
			MajorDA.showMajor(model);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		table.addMouseListener(new MouseAdapter(){
			
			public void mouseClicked(MouseEvent e)
			{
				int i=table.getSelectedRow();
				tf1.setText(model.getValueAt(i, 0).toString());
				tf2.setText(model.getValueAt(i, 1).toString());
				
			}
		});
		f.setSize(800,300);
		f.setVisible(true);
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		
		
		if(e.getSource()==b2){
			String id=tf1.getText();
			String name=tf2.getText();
			
			MajorModel major=new MajorModel(id, name);
			major.setMajorID(id);
			major.setMajorname(name);
			
			row=new Object[2];
			row[0]=tf1.getText();
			row[1]=tf2.getText();
			
			model.addRow(row);
			
				if(id.equals("") || id.equals(null) || name.equals("") || name.equals(null)){
					
					JOptionPane.showMessageDialog(null,"Fill Requirements...","WARNING",JOptionPane.WARNING_MESSAGE);
				}
				else {
					
					try {
						
						boolean op=MajorDA.insertMajor(major);
						
						if(op){
							
							tf1.setText(null);
							tf2.setText(null);
					
							JOptionPane.showMessageDialog(null,"Successfully Created");
							
						}
						else{
							JOptionPane.showMessageDialog(null," Insert Failed");
						}
						
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
		}
		/*if(e.getSource()==b1){
			
			int i=table.getSelectedRow();
			if(i>=0)
			{
				model.removeRow(i);
			}
			
			String id=tf1.getText();
			String name=tf2.getText();
			
			MajorModel major=new MajorModel();
			major.setMajorID(id);
			major.setMajorname(name);
			
			boolean op;
			try {
				op = MajorDA.deleteMajor(major);
				if(op){
					tf1.setText(null);
					tf2.setText(null);
					
					JOptionPane.showMessageDialog(null,"Delete Success!!!");
					
				}
				else{
					
					JOptionPane.showMessageDialog(null,"Delete Fail!!");
				}
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
			
			
			
		}*/
	}
	public static void main(String[] args) {
		new Major();
	}
}


