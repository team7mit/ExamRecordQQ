package DataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.user;
import Security.security;

public class UserDA {
	static Connection cnn;
	static Statement sta;
	static ResultSet res;
public static boolean login(user user) throws SQLException{
	boolean check=false;
	String name=user.getUsername();
	String password=user.getPassword();
	
	Connect.connectDB();
	
	String sql="select * from user";
	sta=cnn.createStatement();
	ResultSet r=sta.executeQuery(sql);   
	while(r.next()){
		

					String decryptpassword=r.getString("password");
				try {
						String pass=security.decrypt(decryptpassword,"MTU");
								if(name.equalsIgnoreCase(r.getString("username")) && password.equals(pass)){
									check=true;
							}
					} catch (Exception e) {
	
							e.printStackTrace();
						}
					finally{
							Connect.connectionclose(cnn);
}
	}
	
	
	return check;
}
}
