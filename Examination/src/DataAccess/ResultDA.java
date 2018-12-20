package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import Model.StudentModel;

public class ResultDA {
	static Connection conn;
	static PreparedStatement stmt;
	static ResultSet res;
	
	public static Vector<String> result() throws SQLException{
		conn=Connect.connectDB();
		Vector<String> list=new Vector<String>();
		StudentModel student=new StudentModel();
		student.setCourse("Third Year");
		student.setSemester("First Semester");
		student.setMajorID("CEIT");
		String sql="select Subject_Code from subject "
				+ " where Course=?"
				+ " and Semester=?"
				+ " and Major_ID=?";
		stmt=conn.prepareStatement(sql);
		stmt.setString(1, student.getCourse());
		stmt.setString(2, student.getSemester());
		stmt.setString(3, student.getMajorID());
		
		res=stmt.executeQuery();
		while(res.next()){
			list.add(res.getString("Subject_Code"));
		}
		return list;
	}
}
