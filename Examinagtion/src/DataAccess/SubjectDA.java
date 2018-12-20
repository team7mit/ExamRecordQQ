package DataAccess;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import Model.AcademicModel;
import Model.CourseModel;
import Model.MajorModel;
import Model.StudentModel;
import Model.SubjectModel;

public class SubjectDA {
	

	static Connection conn;
	static PreparedStatement stmt;
	static ResultSet res;
	
	public static void finalResult(StudentModel student) throws SQLException {
		String major=student.getMajorID();
		String course=student.getCourse();
		conn=Connect.connectDB();
		String sql="select subject_code"
				+ " from subject"
				+ " where Major_ID=?"
				+ " and Course=?";
		stmt=conn.prepareStatement(sql);
		stmt.setString(1, major);
		stmt.setString(2, course);
		List<StudentModel> list=new ArrayList<StudentModel>();
		res=stmt.executeQuery();

		while(res.next())
		{
			student.setSubcode(res.getString("subject_code"));
			list.add(student);
		}
		
	}
	
	public static void showSubject(DefaultTableModel model) throws SQLException{
		
			conn=Connect.connectDB();
				
				String sql="select * from subject";
				stmt=conn.prepareStatement(sql);
				res=stmt.executeQuery();	
				
				while(res.next()){
					model.addRow(new Object[]{res.getString("Subject_Code"),res.getString("Subject_Name"),res.getString("Course"),res.getString("Semester"),res.getString("Major_ID")});

				}	
				
			}
	public static List<StudentModel> semestercombo() throws SQLException {
		conn=Connect.connectDB();
		String sql="select distinct Semester from subject";
		
		PreparedStatement stm=conn.prepareStatement(sql);
		ResultSet r=stm.executeQuery();
		List<StudentModel> list=new ArrayList<StudentModel>();
		while(r.next()){
			
			//String code=r.getString("Subject_Code");
			//String name=r.getString("Subject_Name");
			//String course=r.getString("Course");
			String semester=r.getString("Semester");
			StudentModel m=new StudentModel();
			m.setSemester(semester);
			list.add(m);
			
		}
		System.out.println(list);
		Connect.connectionclose(conn);
		stm.close();
		return list;
}
	
	public static boolean insertSubject(SubjectModel subject) throws SQLException{
	
		String code=subject.getSubcode();
		String name=subject.getSubname();
		String course=subject.getCourse();
		String semester=subject.getSemester();
		String majorID=subject.getMajorID();
	
		conn=Connect.connectDB();
	
		String sql="insert into subject(Subject_Code,Subject_Name,Course,Semester,Major_ID) values(?,?,?,?,?)";
		stmt=conn.prepareStatement(sql);
	
		stmt.setString(1,code);
		stmt.setString(2,name);
		stmt.setString(3,course);
		stmt.setString(4,semester);
		stmt.setString(5,majorID);
	
	
		int r=stmt.executeUpdate();
	
			if(r>=1){
				Connect.connectionclose(conn);
				stmt.close();
				return true;
			
			}
			else {
				Connect.connectionclose(conn);
				stmt.close();
				return false;
			}
		}
	
	public static boolean deleteSubject(SubjectModel subject) throws SQLException{
		
		String code=subject.getSubcode();
		String name=subject.getSubname();
		String course=subject.getCourse();
		String semester=subject.getSemester();
		String majorID=subject.getMajorID();
		
		conn=Connect.connectDB();
		
		String query="delete from subject where Subject_Code=? and Major_ID=?";
		stmt=conn.prepareStatement(query);
		
		stmt.setString(1,code);
		stmt.setString(2,majorID);
		
		int r=stmt.executeUpdate();
		if(r>=1)
		{
			Connect.connectionclose(conn);
			stmt.close();
			return true;
			
		}
		else
		{
			Connect.connectionclose(conn);
			stmt.close();
			return false;
		}
		
	}
	
	public static List<StudentModel> coursecombo() throws SQLException {
		conn=Connect.connectDB();
		String sql="select distinct Course from subject ";
		PreparedStatement stm=conn.prepareStatement(sql);
		 res=stm.executeQuery();
		List<StudentModel> list=new ArrayList<StudentModel>();
		while(res.next()){
			
			String course=res.getString("Course");
			StudentModel m=new StudentModel();
			m.setCourse(course);
			
			list.add(m);
			
		}

		Connect.connectionclose(conn);
		return list;
	}
	
	public static List<StudentModel> subjectcombo(SubjectModel model) throws SQLException {
		String major=model.getMajorID();
		String course=model.getCourse();
		String semester=model.getSemester();
		conn=Connect.connectDB();
		String sql="select distinct Subject_code,Subject_Name " +
				"from subject " +
				"where Semester=?" +
				"and Major_ID=?" +
				"and Course=?";
		
		
		PreparedStatement stm=conn.prepareStatement(sql);
		stm.setString(1, semester);
		stm.setString(2, major);
		stm.setString(3,course);
		ResultSet r=stm.executeQuery();
		List<StudentModel> list=new ArrayList<StudentModel>();
		while(r.next()){
			
			String code=r.getString("Subject_Code");
			String name=r.getString("Subject_Name");
			//String course=r.getString("Course");
			//String semester=r.getString("Semester");
			StudentModel student=new StudentModel();
			student.setSubcode(code);
			student.setSubname(name);
			list.add(student);
			System.out.println(code);
			//System.out.println("object\t"+m.subCode);
		}
		
		System.out.println(list);
		Connect.connectionclose(conn);
		return list;
}
	 
	

}
