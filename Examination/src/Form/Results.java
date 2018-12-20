package Form;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DataAccess.ResultDA;

public class Results extends JFrame{
	private JTable table;
	DefaultTableModel model=new DefaultTableModel();
	public Results() throws SQLException {
		
	Vector<String> column=new Vector<String>();
		column.add("No");
		column.add("Name");
		column.add("Roll No");
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
	column.addAll(ResultDA.result());
	column.add("Total");
	model.setColumnIdentifiers(column);
			for(String s: column)
			System.out.println(s);
		
		
		setVisible(true);
	}
public static void main(String[] args) throws SQLException {
	new Results();
}
}
