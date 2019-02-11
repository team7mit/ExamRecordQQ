package Form;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import DataAccess.AcademicDA;
import DataAccess.MajorDA;
import Model.AcademicModel;
import Model.MajorModel;

public class Academic extends Home{
	
		static JLabel acaID=new JLabel("Academic ID");
		static JLabel aca=new JLabel("Academic");
		static JButton insertbutton=new JButton("Insert");
		static JButton deletebutton=new JButton("DELETE");
		static JTextField idField = new JTextField();
		static JTextField nameField =new JTextField();
		
		static Object[] row;
		
		public static void insertNewAcademic(){
			
			
			academic.addActionListener(new ActionListener(){

				
				public void actionPerformed(ActionEvent arg0) {
					
					insertdata.removeAll();
					insertdata.validate();
					insertdata.repaint();
					

					c.add(insertdata,BorderLayout.CENTER);
					insertdata.setLayout(null);
					
					Object[] columns={"Academic_ID","Academic"};
					model=new DefaultTableModel();
					model.setColumnIdentifiers(columns);
					table=new JTable();
					table.setModel(model);
					table.setRowHeight(20);
				
					jsp=new JScrollPane(table);
					jsp.setBounds(50,100,400,150);
					insertdata.add(jsp);
			
					acaID.setBounds(75,300,90,25);
					insertdata.add(acaID);
					aca.setBounds(75,350,90,25);
					insertdata.add(aca);
			
					idField.setBounds(175,300,200,25);
					insertdata.add(idField);
					nameField.setBounds(175,350,200,25);
					insertdata.add(nameField);
			
					insertbutton.setBounds(200,400,80,20);
					insertdata.add(insertbutton);
					
					deletebutton.setBounds(290, 400, 80, 20);
					insertdata.add(deletebutton);
					
					cancel.setBounds(110, 400, 80, 20);
					insertdata.add(cancel);
					
					try {
						AcademicDA.showAcademic(model);
					} catch (SQLException e2) {

						e2.printStackTrace();
					}
					
					table.addMouseListener(new MouseAdapter(){
						
						public void mouseClicked(MouseEvent e)
						{
							int i=table.getSelectedRow();
							idField.setText(model.getValueAt(i, 0).toString());
							nameField.setText(model.getValueAt(i, 1).toString());
							
						}
					});
					
			}
				
				});
			
			insertbutton.addActionListener(new ActionListener(){

				
				public void actionPerformed(ActionEvent arg0) {

					
					String id=idField.getText();
					String name=nameField.getText();
					
					AcademicModel academic=new AcademicModel();
					
					academic.setAcademicID(id);
					academic.setAcademic(name);
					
					row=new Object[2];
					row[0]=idField.getText();
					row[1]=nameField.getText();
					
						if(id.equals("") || id.equals(null) || name.equals("") || name.equals(null)){
							
							JOptionPane.showMessageDialog(new Home(),"Fill Requirements...","WARNING",JOptionPane.WARNING_MESSAGE);
						}
						else {
								model.addRow(row);
							
							try {
								
								boolean op=AcademicDA.AddAcademic(academic);
								
								if(op){
									
									idField.setText(null);
									nameField.setText(null);
							
									JOptionPane.showMessageDialog(new Home(),"Successfully Created");
									
								}
								else{
									JOptionPane.showMessageDialog(new Home()," Insert Failed");
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
					
					String id=idField.getText();
					String name=nameField.getText();
					
					AcademicModel academic=new AcademicModel();
					academic.setAcademicID(id);
					academic.setAcademic(name);
					
					boolean op;
					try {
					op = AcademicDA.deleteAcademic(academic);
						if(op){
							idField.setText(null);
							nameField.setText(null);
							
							JOptionPane.showMessageDialog(null,"Delete Success!!!");
							
						}
						else{
							
							JOptionPane.showMessageDialog(null,"Delete Fail!!");
						}
					} catch (SQLException e1) {

						e1.printStackTrace();
					}
					
					
		
					
				}
				
			});
			cancel.addActionListener(new ActionListener(){

				
				public void actionPerformed(ActionEvent arg0) {
					
					idField.setText(null);
					nameField.setText(null);
				}
				
			});
			
		}
		
}

