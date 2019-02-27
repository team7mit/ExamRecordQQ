package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import Model.StudentModel;

public class MarkDA {
	
	static Connection conn;
	
	// insert  students' marks to database 

	public static boolean insertexamMark(DefaultTableModel model,StudentModel student) throws SQLException{
		
		String academic=student.academicID;
		String major=student.majorID;
		String subject=student.subcode;
		
		
		int rows=model.getRowCount();
		
		conn=Connect.connectDB();
		String sql="insert into marks (Tutorial,Exam,Practical,Total,Subject_Code,Academic_ID,Roll_No,Major_ID)"
				+ "values (?,?,?,?,?,?,?,?)";
		PreparedStatement pst=conn.prepareStatement(sql);
		for(int r=0;r<rows;r++){
			
			String roll=(String) model.getValueAt(r,2);
			int tuto=Integer.parseInt((String)model.getValueAt(r,3));
			int practical=Integer.parseInt((String)model.getValueAt(r,4));
			int exam=Integer.parseInt((String)model.getValueAt(r,5));
			int total=(int)(tuto+practical+exam*0.8);
			
			
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
		boolean check=false;
	try {
		int[] r=pst.executeBatch();
		
		for(int i=0;i<r.length;i++){
			if(r[i]>-1)
				check=true;
		}
	
	} catch (SQLException e) {
		check=false;
	}	System.out.println(check);
			Connect.connectionclose(conn);
			return check;
	}
	
	
	public static List<StudentModel> retrieveReExamMarks(StudentModel data,DefaultTableModel model) throws SQLException{
		
		int row=model.getRowCount();
		
		for(int i=0;i<row;i++){
			
		}
		
		return null;
	}
	
	//Retrieve student name and roll no from database to insert mark table
	
	//
public static List<StudentModel> insertMark(StudentModel data) throws SQLException{
	
	String academic=data.getAcademicID();
	String major=data.getMajorID();
	String course=data.getCourse();
	System.out.println(course);
	// replacing String to corresponding codes
	course=course.replaceAll("First Year","I%")
			.replaceAll("Second Year", "II%")
			.replaceAll("Third Year", "III%")
			.replaceAll("Fourth Year","IV%")
			.replaceAll("Fifth Year", "V%")
			.replaceAll("Sixth Year", "VI%");
	
	conn=Connect.connectDB();
		
	String sql1="select distinct Student.Student_Name,Student_RollNo.Student_ID,Student_RollNo.Roll_No "
					+ "from student,Student_RollNo "
					+ "where academic_ID=? "
					+ "and major_ID=?"
					+ "and Student_RollNo.Roll_No like ? "
					+ "and student.student_ID=student_rollno.student_ID "
					+ "order by Student_RollNo.Roll_No";
	
	PreparedStatement stmt=conn.prepareStatement(sql1);
	
	
	stmt.setString(1,academic);
	stmt.setString(2, major);
	stmt.setString(3,course);
	
	
	
	//Statement st=conn.createStatement();
	ResultSet res=stmt.executeQuery();
	
	List<StudentModel> studentlist=new ArrayList<StudentModel>();
	while(res.next()){
		StudentModel student=new StudentModel();
		student.setStuid(res.getString("Student_ID"));
		student.setStuname(res.getString("Student_Name"));
		student.setRollno(res.getString("Roll_No"));
		studentlist.add(student);
	
	}
	List<StudentModel> list=SortingRollNo.SortStudent(studentlist);
	Connect.connectionclose(conn);
	return list;
}
public static List<StudentModel> getReStudent(StudentModel data) throws SQLException{
	
	String academic=data.getAcademicID();
	String major=data.getMajorID();
	
	String subject=data.getSubcode();
	
	
	conn=Connect.connectDB();
		
	String sql1="select distinct student.student_name,student_rollno.roll_no "
			+ " from student,student_rollno"
			+ " where roll_no in "
			+ " (select marks.roll_no from marks "
			+ "where subject_code=? "
			+ "and marks.total < 50 "
			+ "and major_id=?"
			+ " and Academic_ID=?)"
			+ " and student.student_id=student_rollno.student_id";
	
	PreparedStatement stmt=conn.prepareStatement(sql1);
	
	
	stmt.setString(1,subject);
	stmt.setString(2, major);
	stmt.setString(3,academic);
	
	
	
	//Statement st=conn.createStatement();
	ResultSet res=stmt.executeQuery();
	
	List<StudentModel> studentlist=new ArrayList<StudentModel>();
	while(res.next()){
		StudentModel student=new StudentModel();
		student.setStuname(res.getString("Student_Name"));
		student.setRollno(res.getString("Roll_No"));
		studentlist.add(student);
	
	}
	List<StudentModel> list=SortingRollNo.SortStudent(studentlist);
	System.out.println(list+ " "+academic+" "+" "+major+" "+subject);
	Connect.connectionclose(conn);
	return list;
	
	
}
public static boolean reInsert(DefaultTableModel model,StudentModel student) throws SQLException {

	String academic=student.academicID;
	String major=student.majorID;
	String subject=student.subcode;
	
	
	int rows=model.getRowCount();
	
	conn=Connect.connectDB();
	String sql="update marks set ReExam=?"
			+ " where academic_ID=?"
			+ " and major_ID=?"
			+ " and subject_code=?"
			+ " and roll_no=?";
	PreparedStatement pst=conn.prepareStatement(sql);
	for(int r=0;r<rows;r++){
		
		String roll=(String) model.getValueAt(r,2);
		int reExam=Integer.parseInt((String)model.getValueAt(r,3));
		
		if(reExam >= 50) reExam=50;
		
		pst.setInt(1, reExam);
		pst.setString(2, academic);
		pst.setString(3,major);
		pst.setString(4, subject);
		pst.setString(5, roll);
	
		
		pst.addBatch();
	}
	boolean check=false;
try {
	int[] r=pst.executeBatch();
	
	for(int i=0;i<r.length;i++){
		if(r[i]>-1)
			check=true;
	}

} catch (SQLException e) {
	e.printStackTrace();
}	
		Connect.connectionclose(conn);
		return check;
}
}