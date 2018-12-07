package form;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import dataAccess.MajorDA;

public class Insert {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insert window = new Insert();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Insert() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 685, 435);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel Major = new JPanel();
		tabbedPane.addTab("Major", null, Major, null);
		Major.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(21, 85, 46, 14);
		Major.add(label);
		
		JLabel lblMajorId = new JLabel("Major ID");
		lblMajorId.setBounds(21, 60, 46, 14);
		Major.add(lblMajorId);
		
		JLabel lblMajorLabel = new JLabel("Major Label");
		lblMajorLabel.setBounds(21, 129, 70, 14);
		Major.add(lblMajorLabel);
		
		textField = new JTextField();
		textField.setBounds(103, 57, 200, 20);
		Major.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(101, 126, 200, 20);
		Major.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnCreate = new JButton("CREATE");
		btnCreate.setBounds(109, 230, 89, 23);
		Major.add(btnCreate);
		
		JPanel Academic = new JPanel();
		tabbedPane.addTab("Academic", null, Academic, null);
		Academic.setLayout(null);
		
		JPanel Student = new JPanel();
		tabbedPane.addTab("Student", null, Student, null);
		Student.setLayout(null);
		

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
		scrollPane.setBounds(336, 57, 273, 165);
		Major.add(scrollPane);
		
	}
}
