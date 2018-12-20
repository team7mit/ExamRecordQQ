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
	
	
	//Retrieve student name and roll no from database to insert mark table
	
	//
public static void insertMark(DefaultTableModel model,StudentModel data) throws SQLException{
	
	String academic=data.getAcademicID();
	String major=data.getMajorID();
	String course=data.getCourse();
	// replacing String to corresponding codes
	course=course.replaceAll("First Year","I%")
			.replaceAll("Second Year", "II%")
			.replaceAll("Third Year", "III%")
			.replaceAll("Fourth Year","IV%")
			.replaceAll("Fifth Year", "V%")
			.replaceAll("Sixth Year", "VI%");
	
	conn=Connect.connectDB();
		
	String sql1="select distinct Student.Student_Name,Student_RollNo.Roll_No "
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
		student.setStuname(res.getString("Student_Name"));
		student.setRollno(res.getString("Roll_No"));
		studentlist.add(student);
	
	}
	List<StudentModel> list=SortingRollNo.SortStudent(studentlist);
	int i=1;
	for(StudentModel student: list){
		model.addRow(new Object[]{i,student.getStuname(),student.getRollno()});
		i++;
	}
	//return false;
	Connect.connectionclose(conn);

}
}
