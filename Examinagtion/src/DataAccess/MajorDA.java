package DataAccess;

import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import Form.Major;
import Model.MajorModel;
import DataAccess.Connect;


public class MajorDA {
	
	static Connection conn;
	static PreparedStatement stmt;
	static ResultSet res;
	
	
	public static void showMajor(DefaultTableModel model) throws SQLException{
		
		conn=Connect.connectDB();
		
		String sql="select * from major";
		stmt=conn.prepareStatement(sql);
		res=stmt.executeQuery();	
		
		while(res.next()){
			model.addRow(new Object[]{res.getString("Major_ID"),res.getString("Major")});

		}
				
	}
	
	public static boolean insertMajor(MajorModel major) throws SQLException{
	
		String majorid=major.getMajorID();
		String majorname=major.getMajorname();
	
		conn=Connect.connectDB();
	
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
	/*public static boolean deleteMajor(MajorModel major) throws SQLException{
		String majorid=major.getMajorID();
		String majorname=major.getMajorname();
	
		conn=Connect.connectDB();
		
		String query="delete Major from major where Major_ID=?";
		stmt=conn.prepareStatement(query);
		
		stmt.setString(1, majorid);
		
		int r=stmt.executeUpdate();
		if(r>=1)
		{
			Connect.connectionclose(conn);
			stmt.close();
			return true;
			
		}
		else
		{
			Connect.connectionclose(conn);
			stmt.close();
			return false;
		}
		
		
	}*/

	public static List<MajorModel> majorcombo() throws SQLException {
		conn=Connect.connectDB();
		String sql="select * from major ";
		PreparedStatement stm=conn.prepareStatement(sql);
		ResultSet r=stm.executeQuery();
		List<MajorModel> list=new ArrayList<MajorModel>();
		while(r.next()){
			
			String id=r.getString("Major_ID");
			String year=r.getString("Major");
			MajorModel m=new MajorModel(id,year);
			list.add(m);
			
		}
		System.out.println(list);
		Connect.connectionclose(conn);
		return list;
	}
	
}