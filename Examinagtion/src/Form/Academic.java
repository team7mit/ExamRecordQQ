package Form;

import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import DataAccess.AcademicDA;
import DataAccess.MajorDA;
import Model.AcademicModel;
import Model.MajorModel;
import Model.StudentModel;

public class Academic extends JFrame implements ActionListener{
	
		JLabel l1,l2;
		JTextField tf1,tf2;
		JButton b2;
		public static JTable table;
		public static DefaultTableModel model;
		JScrollPane sp1;
		Object[] row;
		
		public Academic() throws Exception
		{
			JFrame f=new JFrame();
			f.setTitle("TEAM-7(MIT)");
			f.setLayout(null);
			
			l1=new JLabel("Academic ID");
			l2=new JLabel("Academic");
			
			tf1=new JTextField();
			tf2=new JTextField();
			
			//b1=new JButton("DELETE");
			b2=new JButton("INSERT");
			
			l1.setBounds(20,50,150,20);
			f.add(l1);
			l2.setBounds(20,90,150,20);
			f.add(l2);
			
			tf1.setBounds(150,50,150,20);
			f.add(tf1);
			tf2.setBounds(150,90,150,20);
			f.add(tf2);
			
			//b1.setBounds(70,150,80,20);
			//f.add(b1);
			b2.setBounds(220,150,80,20);
			f.add(b2);
			
			Object[] columns={"Academic_ID","Academic"};
			model=new DefaultTableModel();
			model.setColumnIdentifiers(columns);
			table=new JTable();
			table.setModel(model);
			table.setRowHeight(20);
		
			sp1=new JScrollPane(table);
			sp1.setBounds(380,50,300,100);
			f.add(sp1);
			
			//b1.addActionListener(this);
			b2.addActionListener(this);
			
			try {
				AcademicDA.showAcademic(model);
			} catch (SQLException e2) {

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

		public static void main(String[] args) throws Exception {
			new Academic();
		}
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==b2){
				String id=tf1.getText();
				String name=tf2.getText();
				
				StudentModel academic=new StudentModel();
				academic.setAcademicID(id);
				academic.setAcademic(name);
				
				row=new Object[2];
				row[0]=tf1.getText();
				row[1]=tf2.getText();
				
				model.addRow(row);
				
					if(id.equals("") || id.equals(null) || name.equals("") || name.equals(null)){
						
						JOptionPane.showMessageDialog(this,"Fill Requirements...","WARNING",JOptionPane.WARNING_MESSAGE);
					}
					else {
						
						try {
							
							boolean op=AcademicDA.AddAcademic(academic);
							
							if(op){
								
								tf1.setText(null);
								tf2.setText(null);
						
								JOptionPane.showMessageDialog(this,"Successfully Created");
								
							}
							else{
								JOptionPane.showMessageDialog(this," Insert Failed");
							}
							
							
							
						} catch (SQLException e1) {

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
				
				AcademicModel academic=new AcademicModel();
				academic.setAcademicID(id);
				academic.setAcademic(name);
				
				boolean op;
				try {
					op = AcademicDA.deleteAcademic(academic);
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
}

