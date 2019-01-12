package DataAccess;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Model.AcademicModel;
import Model.StudentModel;
import DataAccess.Connect;

public class StudentDA {
	
	static Connection conn;
	static PreparedStatement stmt;
	
	public static boolean insertStudent(StudentModel student) throws SQLException{
		
		//Getting values from object
		String id=student.getStuid();
		String name=student.getStuname();
		String roll=student.getRollno();
		String academic=student.getAcademicID();
		String major=student.getMajorID();
		conn=Connect.connectDB();
		
		String sql="insert into student(Student_ID,Student_Name,Major_ID) values(?,?,?)";
		 stmt=conn.prepareStatement(sql);
		stmt.setString(1,id);
		stmt.setString(2,name);
		stmt.setString(3,major);

		String sqls="insert into student_rollno(Roll_No,Student_ID,Academic_ID) values(?,?,?)";	
		PreparedStatement stmtt=conn.prepareStatement(sqls);
		stmtt.setString(1,roll);
		stmtt.setString(2, id);
		stmtt.setString(3,academic);
		if(insert(stmt) && insert(stmtt)){
			Connect.connectionclose(conn);
			return true;
		}
		else{
			Connect.connectionclose(conn);
			return false;
		}
		}


	public static boolean insert(PreparedStatement stmt) throws SQLException{
		
		int r=stmt.executeUpdate();
		
		if(r>=1){
			return true;
		}
		else {
			return false;
		}	
	}

	public static boolean delete(StudentModel student) throws SQLException {

		String id=student.getStuid();
		conn=Connect.connectDB();
		String sql="delete from student where Student_ID=?";
		PreparedStatement stm=conn.prepareStatement(sql);
		stm.setString(1,id);
		int r=stm.executeUpdate();
		if(r>=1){
			Connect.connectionclose(conn);
			return true;
		}
		else{
			Connect.connectionclose(conn);
			return false;
		}
		
	}

	public static boolean show(StudentModel student) throws SQLException {

		String id=student.getStuid();
		String roll=student.getRollno();
		String academic=student.getAcademicID();
	
	
		conn=Connect.connectDB();
	
		boolean check=false;
		String select="select * from Student_RollNo where student_ID IN (select student_ID from student where major_ID=?) order by Roll_No";

		stmt=conn.prepareStatement(select);
		stmt.setString(1, student.getMajorID());
		ResultSet res=stmt.executeQuery();
		while(res.next()){
			
			if(id.equals(res.getString("Student_ID")) || academic.equals(res.getString("Academic_ID")) && roll.equals(res.getString("Roll_No"))){		
				System.out.println(res.getString("Student_ID"));
				check=true;
			}
	

		}
		return check;
	}
}
