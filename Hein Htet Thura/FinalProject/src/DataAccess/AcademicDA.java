package DataAccess;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import Form.Academic;
import Model.AcademicModel;
import Model.MajorModel;
import DataAccess.Connect;
public class AcademicDA {
	
	static Connection conn;
	static PreparedStatement stmt;
	static ResultSet res;
	
	public static void showAcademic(DefaultTableModel model) throws SQLException{
		
			conn=Connect.connectDB();
				
				String sql="select * from academic";
				stmt=conn.prepareStatement(sql);
				res=stmt.executeQuery();	
				
				while(res.next()){
					model.addRow(new Object[]{res.getString("Academic_ID"),res.getString("Academic")});

				}	
				
			}
	
	public static boolean AddAcademic(AcademicModel academic) throws SQLException{
	
		String id=academic.getAcademicID();
		String year=academic.getAcademic();
	
		conn=Connect.connectDB();
	
		String sql="insert into Academic(Academic_ID,Academic) values(?,?)";
		stmt=conn.prepareStatement(sql);
	
		stmt.setString(1,id);
		stmt.setString(2,year);
	
	
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
	public static boolean deleteAcademic(AcademicModel academic) throws SQLException {
		String id=academic.getAcademicID();
		String year=academic.getAcademic();
		
		conn=Connect.connectDB();
		
		String sql="delete from  Academic where Academic_ID=?";
		stmt=conn.prepareStatement(sql);
		
		stmt.setString(1, id);
		
		int r=stmt.executeUpdate();
		
		if(r>=1)
		{
			Connect.connectionclose(conn);
			stmt.close();
			return true;
		}
		else{
			Connect.connectionclose(conn);
			stmt.close();
			return false;
		}
	}
	

	public static List<AcademicModel> combo() throws SQLException {

		conn=Connect.connectDB();
		String sql="select * from academic";
		PreparedStatement stm=conn.prepareStatement(sql);
		ResultSet r=stm.executeQuery();
		List<AcademicModel> list=new ArrayList<AcademicModel>();
		
			while(r.next()){
			
			String id=r.getString("Academic_ID");
			String year=r.getString("Academic");
			AcademicModel m=new AcademicModel();
			m.setAcademicID(id);
			m.setAcademic(year);
			list.add(m);
		}
		Connect.connectionclose(conn);
		return list;
		
	}

	
	

}
