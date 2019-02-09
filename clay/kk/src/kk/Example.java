package kk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Example {
	//private static final Object[] Object = null;

	public static void main(String args[])
	{
		JFrame frame=new JFrame();
		JTable table=new JTable();
		
		Object[] columns={"Id","First Name","Last Name","Age"};
		DefaultTableModel model=new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		table.getRowHeight(30);
		
		JTextField textID=new JTextField();
		JTextField textFname=new JTextField();
		JTextField textLname=new JTextField();
		JTextField textAge=new JTextField();
		
		JButton btnAdd=new JButton("Add");
		JButton btnDelete=new JButton("Delete");
		JButton btnUpdate=new JButton("Update");
		
		textID.setBounds(20,220,100,25);
		textFname.setBounds(20,250,100,25);
		textLname.setBounds(20,280,100,25);
		textAge.setBounds(20,310,100,25);
		
		btnAdd.setBounds(150,220,100,25);
		btnDelete.setBounds(150,265,100,25);
		btnUpdate.setBounds(150,310,100,25);
		
		JScrollPane pane=new JScrollPane(table);
		pane.setBounds(0,0,880,200);
		
		frame.setLayout(null);
		
		frame.add(pane);
		
		frame.add(textID);
		frame.add(textFname);
		frame.add(textLname);
		frame.add(textAge);
		
		frame.add(btnAdd);
		frame.add(btnDelete);
		frame.add(btnUpdate);
		
		Object[] row=new Object[4];
		
		btnAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				row[0]=textID.getText();
				row[1]=textFname.getText();
				row[2]=textLname.getText();
				row[3]=textAge.getText();
				
				model.addRow(row);
				
			}
			
		});
		
		btnDelete.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int i=table.getSelectedRow();
				if(i>=0)
				{
					model.removeRow(i);
				}
				else
				{
					System.out.println("Delete Error");
				}
			}
			
		});
		
		table.addMouseListener(new MouseAdapter(){
			
			public void mouseClicked(MouseEvent e)
			{
				int i=table.getSelectedRow();
				textID.setText(model.getValueAt(i, 0).toString());
				textFname.setText(model.getValueAt(i, 1).toString());
				textLname.setText(model.getValueAt(i, 2).toString());
				textAge.setText(model.getValueAt(i, 3).toString());
			}
		});
		btnUpdate.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				int  i=table.getSelectedRow();
				if(i>=1)
				{
					model.setValueAt(textID.getText(), i, 0);
					model.setValueAt(textFname.getText(), i, 1);
					model.setValueAt(textLname.getText(), i, 2);
					model.setValueAt(textAge.getText(), i, 3);
				}
				else
					System.out.println("Update error");
			}
		});
		
		frame.setSize(900, 400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		
		
	}

}
