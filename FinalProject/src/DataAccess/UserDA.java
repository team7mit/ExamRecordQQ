package DataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.PreparedStatement;

import Model.User;
import Security.security;

public class UserDA {static Connection cnn;
static Statement sta;
static ResultSet res;
static PreparedStatement pre;
public static boolean login(User user) throws SQLException{
boolean check=false;
String name=user.getUsername();
String password=user.getPassword();

cnn=Connect.connectDB();

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

public static boolean userCreateByUser(User user) throws SQLException {
	boolean check=false;
	String id=user.getUserid();
	String name=user.getUsername();	
	String password=user.getPassword();

	cnn=Connect.connectDB();
	String sql="insert into unconfirmed values(?,?,?)";

	pre=cnn.prepareStatement(sql);

	pre.setString(1,id);
	pre.setString(2, name);
	pre.setString(3, password);


	int r=pre.executeUpdate();

if(r>=1){
	Connect.connectionclose(cnn);
	pre.close();
	return true;

}
else {
	Connect.connectionclose(cnn);
	pre.close();
	return false;
}
}

//User Creation By Admin
public static boolean userCreateByAdmin(User user) throws SQLException {
boolean check=false;
String id=user.getUserid();
String name=user.getUsername();
String password=user.getPassword();
String level=user.getLevel();

cnn=Connect.connectDB();
String sql="insert into user values(?,?,?,?)";

pre.setString(1, id);
pre.setString(2, name);
pre.setString(3, password);
pre.setString(4, level);

int r=pre.executeUpdate();

if(r>=1){
	Connect.connectionclose(cnn);
	pre.close();
	return true;

}
else {
	Connect.connectionclose(cnn);
	pre.close();
	return false;
}
}
}
