package dataAccess;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connect {
	
	
	static Connection cnn;
	static String url="jdbc:mysql://localhost/Examination_Project?user=root&password=root";
	
	
	public static Connection ConnectDB() throws SQLException{
		
		cnn=DriverManager.getConnection(url);
		System.out.println("Get Connected");
		return cnn;
		
	}
	
	
	
	public static void connectionclose(Connection conn) throws SQLException{
		
		conn.close();
		System.out.println("Connection Closed");
		
	}
	
}
