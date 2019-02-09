package kk;

import java.awt.BorderLayout;
import java.awt.ItemSelectable;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.*;

public class ComboEg extends JFrame implements ActionListener{
	
	JComboBox cb=new JComboBox();
	JLabel l1=new JLabel();
	JPanel p1=new JPanel();
	
	public ComboEg() throws SQLException{
		
		super("Combo Example");
		setSize(400,300);
		
		p1.add(cb);
		p1.add(l1);
		this.add(p1,BorderLayout.CENTER);
		
		BindCombo();
		
		cb.addActionListener(this);
		setVisible(true);
	}
	
	public void BindCombo() throws SQLException{
		
		MyQuery mq=new MyQuery();
		HashMap<String,String>map=mq.populateCombo();
		for(String s:map.keySet()){
			cb.addItem(s);
		}
	}
	
	public void actionPerformed(ActionEvent e ){
		MyQuery mq=new MyQuery();
		HashMap<String,String> map;
		try {
			map = mq.populateCombo();
			//Integer s=map.get(cb.getSelectedItem().toString());
			l1.setText(map.get(cb.getSelectedItem()).toString());
			//System.out.println(s);
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
	}
	
	
	public static void main(String []args) throws SQLException{
		new ComboEg();
	}
	

}
