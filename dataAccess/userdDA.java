package dataAccess;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import model.user;


public class userdDA {
	
	
	static Connection cnn;
	static ResultSet res;
	static Statement sta;
	//static String url="jdbc:mysql://localhost/Examination_Records?user=root&password=root";
	
	//check password return true if both equals
			public static boolean login(user op) throws Exception
			{
					boolean check=false;
	
					Connect.ConnectDB();
	
					String username=op.getUsername();
					String password=op.getPassword();
	
					sta=cnn.createStatement();
					sta.executeQuery("select * from User");
					res=sta.getResultSet();
	
	
					while(res.next()){
		
							String passcode=decrypt(res.getString("Password"),"tt");
							if(username.equals(res.getString("UserName")) && passcode.equals(password) )
							{
								Connect.connectionclose(cnn);
								check=true;
							}		
							else
							{
								Connect.connectionclose(cnn);
								check=false;
							}
					}
					return check;
			}
				//decrypt password
			public static String decrypt(String strEncrypted,String strKey) throws Exception
			{
					String strData="";
	
						try {
							SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes(),"Blowfish");
							Cipher cipher=Cipher.getInstance("Blowfish");
							cipher.init(Cipher.DECRYPT_MODE, skeyspec);
							byte[] decrypted=cipher.doFinal(strEncrypted.getBytes());
		strData=new String(decrypted);
		
	} catch (Exception e) {
		e.printStackTrace();
		throw new Exception(e);
	}
	return strData;
}
}
