package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

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

	public static Vector<String> rollUpdate(StudentModel student) throws SQLException {
		
		conn=Connect.connectDB();
		Vector<String> list=new Vector<String>();
		list.removeAllElements();
		String sql="select Subject_Code from subject "
				+ " where Course=?"
				+ " and Semester=?"
				+ " and Major_ID=?";
		stmt=conn.prepareStatement(sql);
		stmt.setString(1,student.getCourse());
		stmt.setString(2, student.getSemester());
		stmt.setString(3, student.getMajorID());
		
		res=stmt.executeQuery();
		while(res.next()){
			list.add(res.getString("Subject_Code"));
		}
		Connect.connectionclose(conn);
		return list;
	}

	public static String getAllMarks(StudentModel student, DefaultTableModel model) throws SQLException {
		
		String roll=student.getRollno();
		String academic=student.getAcademicID();
		String subject=student.getSubcode();
		

	conn=Connect.connectDB();
	
	String sql="select Total from marks"
			+ " where Subject_Code=?"
			+ " and Academic_ID=?"
			+ " and Roll_No=?";
	
	stmt=conn.prepareStatement(sql);
	
	stmt.setString(1, subject);
	stmt.setString(2, academic);
	stmt.setString(3, roll);
	
	res=stmt.executeQuery();
	
	String result=null;
	while(res.next()){
		//System.out.println(res.getString("Total"));
		System.out.println(student.rollno);
		System.out.println(student.subcode);
		result=res.getString("Total");
	}
	Connect.connectionclose(conn);
	return result;
	}
}