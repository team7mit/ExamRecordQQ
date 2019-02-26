package DataAccess;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.table.DefaultTableModel;

import Model.StudentModel;

public class ShowStuMarksDA {
	
	static Connection conn;
	static PreparedStatement stmt;
	static Statement st;
	static ResultSet res;
	
	// retrieve exam marks for all students
	public static List<StudentModel> showMarks(DefaultTableModel table,StudentModel student) throws SQLException{
		
		conn=Connect.connectDB();
		String academic=student.getAcademicID();
		String major=student.getMajorID();
		String code=student.getSubcode();
		
		String sql="select distinct student.Student_Name,student_rollno.Roll_No,marks.Tutorial,marks.Practical,marks.Exam,marks.Total"
				+" from student,student_rollno,marks "
				+ "  where marks.Academic_ID=? "
				+ " and marks.Major_ID=? "
				+ " and marks.Subject_Code=? "
				+ " and student_rollno.Roll_No=marks.Roll_No "
				+ " and student.Student_ID=student_rollno.Student_ID";
				//+ " order by student_rollno.Roll_No ";
		
		stmt=conn.prepareStatement(sql);
		stmt.setString(1,academic );
		stmt.setString(2, major);
		stmt.setString(3, code);
		
		res=stmt.executeQuery();
		
		List<StudentModel> StudentList=new ArrayList<StudentModel>();
		while(res.next()){
			StudentModel stu=new StudentModel();
			
			
			
			stu.setStuname(res.getString("Student_Name"));
			stu.setRollno(res.getString("Roll_No"));
			stu.setTutorial(res.getInt("Tutorial"));
			stu.setExam(res.getInt("Exam"));
			stu.setPractical(res.getInt("Practical"));
			stu.setTotal(res.getInt("Total"));
			
			StudentList.add(stu);
			//table.addRow(new Object[]{res.getString("Student_Name"),res.getString("Roll_No"),res.getInt("Tutorial"),res.getInt("Practical"),res.getInt("Exam"),res.getInt("Total")});
		}
		
		List<StudentModel> list=SortingRollNo.SortStudent(StudentList);
	return list;
	}
}