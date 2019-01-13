package Form;

import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import DataAccess.SubjectDA;
import Model.SubjectModel;

public class Subject extends JFrame implements ActionListener{
	
	JLabel l1,l2,l3,l4,l5;
	JTextField tf1,tf2,tf3,tf4,tf5;
	JButton b1,b2;
	
	public static JTable table;
	public static DefaultTableModel model;
	
	JScrollPane sp1;
	Object []row;
	
	public Subject()
	{
		
		JFrame f=new JFrame();
		f.setTitle("TEAM-7(MIT)");
		f.setLayout(null);
		
		l1=new JLabel("Subject Code");
		l2=new JLabel("Subject Name");
		l3=new JLabel("Course");
		l4=new JLabel("Semester");
		l5=new JLabel("Major ID");
		
		tf1=new JTextField();
		tf2=new JTextField();
		tf3=new JTextField();
		tf4=new JTextField();
		tf5=new JTextField();
		
		b1=new JButton("DELETE");
		b2=new JButton("INSERT");
		//b3=new JButton("UPDATE");
		
		l1.setBounds(20,50,100,20);
		f.add(l1);
		l2.setBounds(20,90,100,20);
		f.add(l2);
		l3.setBounds(20,130,100,20);
		f.add(l3);
		l4.setBounds(20,170,100,20);
		f.add(l4);
		l5.setBounds(20,210,100,20);
		f.add(l5);
		
		tf1.setBounds(150,50,150,20);
		f.add(tf1);
		tf2.setBounds(150,90,150,20);
		f.add(tf2);
		tf3.setBounds(150,130,150,20);
		f.add(tf3);
		tf4.setBounds(150,170,150,20);
		f.add(tf4);
		tf5.setBounds(150,210,150,20);
		f.add(tf5);
		
		b1.setBounds(30,270,80,20);
		f.add(b1);
		b2.setBounds(160,270,80,20);
		f.add(b2);
		//b3.setBounds(280,270,80,20);
		//f.add(b3);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		//b3.addActionListener(this);
		
		
		Object[] columns={"Subject_Code","Subject_Name","Course","Semester","Major_ID"};
		model=new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		table=new JTable();
		table.setModel(model);
		table.setRowHeight(20);
		sp1=new JScrollPane(table);
		sp1.setBounds(370,50,570,250);
		f.add(sp1);
		
		try {
			SubjectDA.showSubject(model);
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		
		table.addMouseListener(new MouseAdapter(){
			
			public void mouseClicked(MouseEvent e)
			{
				int i=table.getSelectedRow();
				tf1.setText(model.getValueAt(i, 0).toString());
				tf2.setText(model.getValueAt(i, 1).toString());
				tf3.setText(model.getValueAt(i, 2).toString());
				tf4.setText(model.getValueAt(i, 3).toString());
				tf5.setText(model.getValueAt(i, 4).toString());
				
			}
		});

		
		f.setSize(1000,370);
		
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Subject();
	}
	public void actionPerformed(ActionEvent e)
	
	{
		
		if(e.getSource()==b2){
			String subcode=tf1.getText();
			String subname=tf2.getText();
			String course=tf3.getText();
			String semester=tf4.getText();
			String majorID=tf5.getText();
			
			SubjectModel subject=new SubjectModel();
			subject.setSubcode(subcode);
			subject.setSubname(subname);
			subject.setCourse(course);
			subject.setSemester(semester);
			subject.setMajorID(majorID);
			
			row=new Object[5];
			row[0]=tf1.getText();
			row[1]=tf2.getText();
			row[2]=tf3.getText();
			row[3]=tf4.getText();
			row[4]=tf5.getText();
			
			model.addRow(row);
			
				if(subcode.equals("") || subcode.equals(null) || subname.equals("") || subname.equals(null) || course.equals("") || course.equals(null) || semester.equals("") || semester.equals(null) || majorID.equals(null) || majorID.equals("")){
					
					JOptionPane.showMessageDialog(this,"Fill Requirements...","WARNING",JOptionPane.WARNING_MESSAGE);
				}
				else {
					
					try {
						
						boolean op=SubjectDA.insertSubject(subject);
						
						if(op){
							
							tf1.setText(null);
							tf2.setText(null);
							tf3.setText(null);
							tf4.setText(null);
							tf5.setText(null);
					
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
		if(e.getSource()==b1){
			
			int i=table.getSelectedRow();
			if(i>=0)
			{
				model.removeRow(i);
			}
			
			String subcode=tf1.getText();
			String subname=tf2.getText();
			String course=tf3.getText();
			String semester=tf4.getText();
			String majorID=tf5.getText();
			
			SubjectModel subject=new SubjectModel();
			subject.setSubcode(subcode);
			subject.setSubname(subname);
			subject.setCourse(course);
			subject.setSemester(semester);
			subject.setMajorID(majorID);
			
			boolean op;
			try {
				op =SubjectDA.deleteSubject(subject);
				if(op){
					tf1.setText(null);
					tf2.setText(null);
					tf3.setText(null);
					tf4.setText(null);
					tf5.setText(null);
					
					JOptionPane.showMessageDialog(null,"Delete Success!!!");
					
				}
				else{
					
					JOptionPane.showMessageDialog(null,"Delete Fail!!");
				}
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
			
			
			
		}
		
	}

}
