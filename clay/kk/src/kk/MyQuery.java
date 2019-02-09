package kk;

import java.sql.*;
import java.util.HashMap;

public class MyQuery {
	
	String url="jdbc:mysql://localhost/gg?user=root&password=root";
	
	public Connection getConnection(){
		Connection con=null;
		
		try {
			con=DriverManager.getConnection(url);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return con;
	}
	
	public HashMap<String,String>populateCombo() throws SQLException{
		
		HashMap<String,String> map=new HashMap<String,String>();
		Connection con=getConnection();
		Statement st;
		ResultSet rs;
		
		String q="select id,name from lol";
		
		st=con.createStatement();
		rs=st.executeQuery(q);
		
		comboItem cmi;
		while(rs.next()){
			
			
			cmi=new comboItem(rs.getString(1),rs.getString(2));
			map.put(cmi.getName(),cmi.getId());		
			}
		
		
		return map;
		
		
	}

}
