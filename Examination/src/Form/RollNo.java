package Form;

import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DataAccess.MarkDA;
import Model.StudentModel;

public class RollNo {

	private JFrame frame;
	private JTable table;
	DefaultTableModel model=new DefaultTableModel();
	StudentModel student = new StudentModel();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RollNo window = new RollNo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public RollNo() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		table = new JTable(model);
		frame.getContentPane().add(table, BorderLayout.NORTH);
		Object[] columns={"No","Name"," Previous Roll"," Current Roll"};
		model.setColumnIdentifiers(columns);
		JScrollPane scrollBar = new JScrollPane(table);
		frame.getContentPane().add(scrollBar, BorderLayout.CENTER);
		try {
			student.academicID="201314";
			student.majorID="CEIT";
			student.Course="Third Year";
			MarkDA.insertMark(model,student);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
