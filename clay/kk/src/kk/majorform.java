package kk;

import java.awt.EventQueue;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class majorform implements ActionListener {

		private JFrame frmMajorCreation;
		private JTextField textField;
		private JTextField textField_1;
		JButton btnNewButton = new JButton("CREATE");
		private JScrollPane scrollPane;
		private JTable table;
		private JTable table_1;
		private DefaultTableModel model;
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						majorform window = new majorform();
						window.frmMajorCreation.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the application.
		 */
		public majorform() {
			initialize();
		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			
			frmMajorCreation = new JFrame();
			frmMajorCreation.setTitle("Major Creation");
			frmMajorCreation.setBounds(100, 100, 717, 303);
			frmMajorCreation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frmMajorCreation.getContentPane().setLayout(null);
			
			
			btnNewButton.addActionListener(this);
			btnNewButton.setBounds(166, 197, 89, 23);
			frmMajorCreation.getContentPane().add(btnNewButton);
			
			textField = new JTextField();
			textField.setBounds(148, 79, 200, 20);
			frmMajorCreation.getContentPane().add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setBounds(148, 128, 200, 20);
			frmMajorCreation.getContentPane().add(textField_1);
			textField_1.setColumns(10);
			
			JLabel lblMajorId = new JLabel("Major ID");
			lblMajorId.setBounds(44, 82, 46, 14);
			frmMajorCreation.getContentPane().add(lblMajorId);
			
			JLabel lblMajorName = new JLabel("Major Name");
			lblMajorName.setBounds(44, 131, 75, 14);
			frmMajorCreation.getContentPane().add(lblMajorName);
			
			
			
			String []columns={"ID","Name"};
			
			DefaultTableModel model=new DefaultTableModel();
			model.setColumnIdentifiers(columns);
			
			table = new JTable(model);
			
			try {
			MajorDA.showMajor(model);
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			scrollPane = new JScrollPane(table);
			scrollPane.setBounds(397, 47, 273, 165);
			frmMajorCreation.getContentPane().add(scrollPane);
			//table_1 = new JTable();
		
		}
		


		public void actionPerformed(ActionEvent e) {
		
			if(e.getSource()==btnNewButton){
				String id=textField.getText();
				String name=textField_1.getText();
				
				majorModel major=new majorModel();
				major.setMajorId(id);
				major.setMajorName(name);
					if(id.equals("") || id.equals(null) || name.equals("") || name.equals(null)){
						JOptionPane.showMessageDialog(frmMajorCreation,"Fill Requirements!!!!!!!!!!!!!!!!!!","WARNING",JOptionPane.WARNING_MESSAGE);
					}
					else {
						
						try {
							
							boolean op=MajorDA.insertMajor(major);
							
							if(op){
								
								textField.setText(null);
								textField_1.setText(null);
						
								JOptionPane.showMessageDialog(frmMajorCreation,"Successfully Created");
								
							}
							else{
								JOptionPane.showMessageDialog(frmMajorCreation," Creat");
							}
							
							
							
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						
						
					}
				
			}
		}

}
