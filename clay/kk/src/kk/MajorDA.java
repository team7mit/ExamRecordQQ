package kk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class MajorDA {
	
	static Connection conn;
	static PreparedStatement stmt;
	static ResultSet res;
	
	
	public static void showMajor(DefaultTableModel model) throws SQLException{
		
		conn=Connect.connectDB();
		
		String sql="select * from major";
		stmt=conn.prepareStatement(sql);
		res=stmt.executeQuery();	
	
		List<Object> list=new ArrayList<>();
		
		while(res.next()){
			model.addRow(new Object[]{res.getString("Major_ID"),res.getString("Major")});

		}
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	//	System.out.println(list.toString());
		Connect.connectionclose(conn);
		stmt.close();
		
		
	}
	
	
	
	
	
public static boolean insertMajor(majorModel major) throws SQLException{
	
	String majorid=major.getMajorId();
	String majorname=major.getMajorName();
	
	conn=Connect.connectDB();;
	
	String sql="insert into major(Major_ID,Major) values (?,?)";
	stmt=conn.prepareStatement(sql);
	
	stmt.setString(1, majorid);
	stmt.setString(2,majorname);

	int r=stmt.executeUpdate();
	if(r>=1){
		Connect.connectionclose(conn);
		stmt.close();
		return true;
	}
	else{
		Connect.connectionclose(conn);
		stmt.close();
		return false;
	}
	
}

}
