package dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Student;

public class RollNoDA {
	static Connection conn;
public static boolean insertStudent(Student student) throws SQLException{
	
	//Getting values from object
	String id=student.getStuid();
	String name=student.getStuname();
	String roll=student.getRollno();
	String academic=student.getAcaid();
	String major=student.getMajorId();
	
	
	conn=Connect.ConnectDB();
	String sqls="insert into student_rollno(Roll_No,Student_ID,Academic_ID) values(?,?,?)";	
	PreparedStatement stmt=conn.prepareStatement(sqls);
	stmt.setString(1,roll);
	stmt.setString(2, id);
	stmt.setString(3,academic);
	int r=stmt.executeUpdate();
	
	
	if(r>=1){
		
		Connect.connectionclose(conn);
		return true;
	}
	else{
		
		Connect.connectionclose(conn);
		return false;
	}
}
}
