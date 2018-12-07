package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import Model.StudentModel;

public class MarkDA {
	
	static Connection conn;
	
	// insert  students' marks to database 

	public static void insertexamMark(DefaultTableModel model,StudentModel student) throws SQLException{
		
		String academic="201314";
		String major="CEIT";
		String subject="IT-31014";
		
		
		int rows=model.getRowCount();
		
		conn=Connect.connectDB();
		String sql="insert into marks (Tutorial,Exam,Practical,Total,Subject_Code,Academic_ID,Roll_No,Major_ID)"
				+ "values (?,?,?,?,?,?,?,?)";
		PreparedStatement pst=conn.prepareStatement(sql);
		for(int r=0;r<rows;r++){
			
			String roll=(String) model.getValueAt(r,2);
			int tuto=Integer.parseInt((String)model.getValueAt(r,3));
			int exam=Integer.parseInt((String)model.getValueAt(r,4));
			int practical=Integer.parseInt((String)model.getValueAt(r,5));
			int total=tuto+exam+practical;
			
			
			pst.setInt(1, tuto);
			pst.setInt(2, exam);
			pst.setInt(3, practical);
			pst.setInt(4, total);
			pst.setString(5, subject);
			pst.setString(6,academic);
			pst.setString(7, roll);
			pst.setString(8, major);
			
			pst.addBatch();
		}
		pst.executeBatch();
		conn.commit();
	Connect.connectionclose(conn);
	}
	
	
	//Retrieve student name and roll no from database to insert mark table
	
	//
public static void insertMark(DefaultTableModel model) throws SQLException{
	
	conn=Connect.connectDB();
	String sql="select distinct Student.Student_Name,Student_RollNo.Roll_No " +
			"from student,Student_RollNo "+
			"where academic_ID='201314'" +
			"and major_ID='CEIT'" +
			"and Student_RollNo.Roll_No like 'III%'"+
			"and student.student_ID=student_rollno.student_ID "
			+ "order by Student_RollNo.Roll_No";
		
	Statement st=conn.createStatement();
	ResultSet res=st.executeQuery(sql);
	
	int i=1;
	
	while(res.next()){
		model.addRow(new Object[]{i,res.getString("Student_Name"),res.getString("Roll_No")});
		System.out.println(i);
	i++;
	
	}
	//return false;
	
}
}
