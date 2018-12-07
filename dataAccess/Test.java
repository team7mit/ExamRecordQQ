package dataAccess;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import jxl.*;
import jxl.read.biff.BiffException;
public class Test implements ActionListener{
	
	JButton b=new JButton("Add");
	JTable table=new JTable();
	public Test(){
		Vector<Object> headers=new Vector<Object>();
		Vector<Object> data=new Vector<Object>();
		 File file=new File("d:/Book.xls");
		
		try {
			Workbook workbook=Workbook.getWorkbook(file);
			Sheet sheet=workbook.getSheet(0);
			headers.clear();
			for (int i = 0; i < sheet.getColumns(); i++) {
				Cell cell1 = sheet.getCell(i, 0);
				headers.add(cell1.getContents());
				}
				data.clear();
			for(int j=1;j<sheet.getRows();j++){
				Vector<Object> d=new Vector<Object>();
				for(int i=0;i<sheet.getColumns();i++){
					Cell cell=sheet.getCell(i,j);
					d.add(cell.getContents());
				}
				d.add("/n");
				data.add(d);
				
				
			}
			
		} catch (BiffException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		DefaultTableModel model=new DefaultTableModel(data,headers);
		table.setModel(model);
		table.setAutoCreateRowSorter(true);
		
		model=new DefaultTableModel(data,headers);
		table.setModel(model);
		JScrollPane jsp=new JScrollPane(table);
		JFrame f=new JFrame();
		f.add(jsp);
		f.setSize(400, 200);
		f.setResizable(true);
		f.setVisible(true);
		f.add(b,"South");
		b.addActionListener(this);
		
	}
	
	public static void main(String[] args) {
		new Test();
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==b){
			try {
				Connection conn=Connect.ConnectDB();
				
				String sql="insert into testing (id,name) values (?,?)";
				PreparedStatement stmt=conn.prepareStatement(sql);
				int i=table.getRowCount();
				for(int j=0;j<i;j++){
					String id=(String)table.getValueAt(j,0);
					String name=(String)table.getValueAt(j,1);
					
					stmt.setString(1, id);
					stmt.setString(2,name);
					
					stmt.addBatch();
				}
				int[] x=stmt.executeBatch();
				
				if(x.length>=1){
					JOptionPane.showMessageDialog(null,"success");
				}
				else{
					JOptionPane.showMessageDialog(null,"failed");
				}
				
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
}

