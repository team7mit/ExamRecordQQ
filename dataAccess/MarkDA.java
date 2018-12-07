package dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

public class MarkDA {
	
	static Connection conn;
public static boolean insertMark(DefaultTableModel model) throws SQLException{
	
	conn=Connect.ConnectDB();
	String sql="select distinct Student.Student_Name,Student_RollNo.Roll_No " +
			"from student,Student_RollNo " +
			"where academic_ID='201213'" +
			"and major_ID='CEIT'" +
			"and Student_RollNo.Roll_No like 'III%'";
	Statement st=conn.createStatement();
	ResultSet res=st.executeQuery(sql);
	
	int i=1;
	while(res.next()){
		model.addRow(new Object[]{i,res.getString("Student_Name"),res.getString("Roll_No")});
	i++;
	}
	return false;
	
}
}
