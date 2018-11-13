package dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Academic;

public class AcademicDA {
	static Connection conn;
	static PreparedStatement stmt;
	static ResultSet res;
	
	
	public static List<Academic> combo() throws SQLException{
		conn=Connect.ConnectDB();
		String sql="select * from academic ";
		PreparedStatement stm=conn.prepareStatement(sql);
		ResultSet r=stm.executeQuery();
		List<Academic> list=new ArrayList<Academic>();
		while(r.next()){
			
			String id=r.getString("Academic_ID");
			String year=r.getString("Academic");
			Academic m=new Academic(id,year);
			list.add(m);
			
		}
		System.out.println(list);
		return list;
		
	}
	
	
	
	
public static boolean AddAcademic(Academic academic) throws SQLException{
	String id=academic.getAcaid();
	String year=academic.getAcayear();
	
	conn=Connect.ConnectDB();
	
	String sql="insert into Academic(Academic_ID,Academic) values(?,?)";
	stmt=conn.prepareStatement(sql);
	
	stmt.setString(1,id);
	stmt.setString(2,year);
	
	
	int r=stmt.executeUpdate();
	
	if(r>=1){
		
		Connect.connectionclose(conn);
		return true;
		
	}
	else {
		Connect.connectionclose(conn);
		return false;
	}
	
	
	
	
	
	
	
}
}
