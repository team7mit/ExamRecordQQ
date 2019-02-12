package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import Model.StudentModel;

public class ResultDA {
	static Connection conn;
	static PreparedStatement stmt;
	static ResultSet res;
	


	
	public static String getReExamMarks(StudentModel student) throws SQLException{
		

		String roll=student.getRollno();
		String academic=student.getAcademicID();
		String subject=student.getSubcode();
		

		conn=Connect.connectDB();
	
		String sql="select ReExam from marks"
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
		
		result=res.getString("ReExam");
		//System.out.println(result+" TOTAL ");
	}
	Connect.connectionclose(conn);
	return result;
		
	}
	
	
	public static Vector<String> result(StudentModel student) throws SQLException{
		conn=Connect.connectDB();
		Vector<String> list=new Vector<String>();
		list.removeAllElements();
		String sql="select Subject_Code from subject "
				+ " where Course=?"
				+ " and Major_ID=?"
				+ " and Semester=?";
		stmt=conn.prepareStatement(sql);
		stmt.setString(1,student.getCourse());
		stmt.setString(2, student.getMajorID());
		stmt.setString(3, student.getSemester());
		res=stmt.executeQuery();
		while(res.next()){
			list.add(res.getString("Subject_Code"));
		}
		Connect.connectionclose(conn);
		return list;
	}

	public static Vector<String> rollUpdate(StudentModel student) throws SQLException {
		
		conn=Connect.connectDB();
		Vector<String> list=new Vector<String>();
		list.removeAllElements();
		String sql="select Subject_Code from subject "
				+ " where Course=?"
				+ " and Major_ID=?";
		stmt=conn.prepareStatement(sql);
		stmt.setString(1,student.getCourse());
		stmt.setString(2, student.getMajorID());
		
		res=stmt.executeQuery();
		while(res.next()){
			list.add(res.getString("Subject_Code"));
		}
		Connect.connectionclose(conn);
		return list;
	}

	
	public static List<StudentModel> studentExamMarks(StudentModel student) throws SQLException{

		String roll=student.getRollno();
		String academic=student.getAcademicID();
		

	conn=Connect.connectDB();
	
	String sql="select Total,Subject_Code from marks"
			+ " where Academic_ID=?"
			+ " and Roll_No=?";
	
	stmt=conn.prepareStatement(sql);
	
	//stmt.setString(1, subject);
	stmt.setString(1, academic);
	stmt.setString(2, roll);
	
	res=stmt.executeQuery();
	
	List<StudentModel> result=new ArrayList<StudentModel>();
	StudentModel studentmodel=new StudentModel();
			while(res.next()){
		
		studentmodel.setSubcode(res.getString("Subject_Code"));
		studentmodel.setTotal(Integer.parseInt(res.getString("Total")));
		result.add(studentmodel);
		//System.out.println(result+" TOTAL ");
	}
	Connect.connectionclose(conn);
	return result;
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
		
		result=res.getString("Total");
		//System.out.println(result+" TOTAL ");
	}
	Connect.connectionclose(conn);
	return result;
	}

}

