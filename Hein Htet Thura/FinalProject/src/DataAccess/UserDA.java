package DataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import Model.User;
import Security.security;

public class UserDA {static Connection cnn;
static Statement sta;
static ResultSet res;
static PreparedStatement pre;

		

			public static String VerifyUserLevel(User user) throws SQLException {
				cnn=Connect.connectDB();
				String level=null;
				String id=user.getUserid();
			
				String sql="select * from user where UserID=?";
				
				pre=cnn.prepareStatement(sql);
				 
				pre.setString(1, id);
				res=pre.executeQuery();
				
				while(res.next()) {
					
					level=res.getString("UserLevel");
					
				}
				return level;
			}

		
			public static List<User> UnapprovedUser()throws SQLException{
				
				cnn=Connect.connectDB();
				
				String sql="select * from unconfirmed";
				
				pre=cnn.prepareStatement(sql);
				 
				
				res=pre.executeQuery();
				
				List<User> list=new ArrayList<User>();
				
				while(res.next()) {
					User user=new User();
					user.setUserid(res.getString("userid"));
					user.setUsername(res.getString("username"));
					user.setPassword(res.getString("password"));
					list.add(user);
				}
				
				return list;
				
			}
			
			public static boolean ApprovedUser(User user) throws SQLException{
				
				String id=user.getUserid();
				String name=user.getUsername();
				String password=user.getPassword();
				String level=user.getLevel();
				
				cnn=Connect.connectDB();
				
				String sql="insert into user values(?,?,?,?)";
				pre=cnn.prepareStatement(sql);
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

			public static boolean login(User user) throws SQLException{
				boolean check=false;
				String name=user.getUserid();
				String password=user.getPassword();

				cnn=Connect.connectDB();

				String sql="select * from user";
				pre=cnn.prepareStatement(sql);
				res=pre.executeQuery();   
				while(res.next()){
				String decryptpassword=res.getString("password");
				try {
					String pass=security.decrypt(decryptpassword,"MTU");
							if(name.equalsIgnoreCase(res.getString("UserID")) && password.equals(pass)){
								check=true;
						}
				} catch (Exception e) {

						e.printStackTrace();
					}
				}

				Connect.connectionclose(cnn);
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
