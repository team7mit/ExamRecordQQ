package dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Student;

public class StudentDA {
	static Connection conn;
public static boolean insertStudent(Student student) throws SQLException{
	
	//Getting values from object
	String id=student.getStuid();
	String name=student.getStuname();
	String roll=student.getRollno();
	String academic=student.getAcaid();
	String major=student.getMajorId();
	
	
	
	
	
	
	conn=Connect.ConnectDB();
	
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
		return true;
	}
	else{
		Connect.connectionclose(conn);
		return false;
	}
	}

public static void show(String stuid,String academicid,String rollno) throws SQLException{
String select="select * from Student_RollNo where student_ID IN (select student_ID from student where major_ID='CEIT') order by Roll_No";
conn=Connect.ConnectDB();
	Statement st = conn.createStatement();
	ResultSet res=st.executeQuery(select);
	while(res.next()){
		System.out.println(res.getString("Student_ID")+"\t"+res.getString("Roll_No")+"\t"+res.getString("Academic_ID"));
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

}

