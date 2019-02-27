package DataAccess;

import java.sql.*;
import java.util.ArrayList;
import Form.dataentry;
import Model.MajorModel;
@SuppressWarnings("serial")
public class Department_And_SubjectDA extends dataentry{
	public Department_And_SubjectDA() {
	}
	
	static Connection conn;
	static PreparedStatement stmt;
	static ResultSet res;
	
public static ArrayList<String> getMajor() throws SQLException{
		
	ArrayList <String> list=new ArrayList<String>();
	
		conn=Connect.connectDB();
		
		String sql="select Major_ID from major";
		stmt=conn.prepareStatement(sql);
		res=stmt.executeQuery();	
		
		MajorModel mm;
		
		while(res.next()){
			mm=new MajorModel(res.getString("Major_ID"));
			list.add(mm.getMajorID());
		}
		return list;
				
	}

}
