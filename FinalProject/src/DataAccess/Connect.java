package DataAccess;
import java.sql.*;
public class Connect {

	static Connection cnn;
	static String url="jdbc:mysql://localhost/Examination_Project?user=root&password=root";

public static Connection connectDB() throws SQLException{
	 cnn=DriverManager.getConnection(url);
	return cnn;
}
public static void connectionclose(Connection cnn) throws SQLException{
	cnn.close();
}
}
