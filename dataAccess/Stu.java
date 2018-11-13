package dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import model.Academic;
import model.Student;

public class Stu {
	static Connection conn;
	
	//Creating queries
	
	public static boolean insertStudent(Student student) throws SQLException{
		boolean race;
		String id=student.getStuid();
		String name=student.getStuname();
		String roll=student.getRollno();
		String academic=student.getAcaid();
		String major=student.getMajorId();
		
		String sql="insert into student(Student_ID,Student_Name,Major_ID) values(?,?,?)";
		PreparedStatement stmt=conn.prepareStatement(sql);
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
			race=true;
		}
		else{
			Connect.connectionclose(conn);
			race=false;
		}
		return race;
		
	}
	
	
	//Insert Into Tables
	public static boolean insert(PreparedStatement stmt) throws SQLException{
	
			int r=stmt.executeUpdate();
	
					if(r>=1){
							return true;
							}
					else {
							return false;
						}	
	}
//Following statements
//CHECK whether student already exists or not
	public static boolean show(Student student) throws SQLException{
	
		String id=student.getStuid();
		String roll=student.getRollno();
		String academic=student.getAcaid();
	
	
		conn=Connect.ConnectDB();
	
		boolean check=false;
		String select="select * from Student_RollNo where student_ID IN (select student_ID from student where major_ID='CEIT') order by Roll_No";

		Statement st;
		st = conn.createStatement();
		ResultSet res=st.executeQuery(select);
		while(res.next()){
			
			if(id.equals(res.getString("Student_ID")) || academic.equals(res.getString("Academic_ID")) && roll.equals(res.getString("Roll_No"))){		
				System.out.println(res.getString("Student_ID"));
				check=true;
			}
	

		}
		return check;
	}
	public static boolean delete(Student student) throws SQLException{
		
		String id=student.getStuid();
		conn=Connect.ConnectDB();
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
		
	
	
		public static boolean find(Student student){
			
			String academic=student.getAcaid();
			String studentid=student.getStuid();
			
			String sql="select * from student,student_rollno where Student_ID=? and Academic_ID=?";
			
			
			
			return false;
			
		}
		
	
	}