package Form;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;
import javax.swing.*;

import DataAccess.UserDA;

//import Data_Access.UserDaA;

import Model.user;
public class LoginPage extends JFrame implements ActionListener{
	
	Connection cnn;
	ResultSet rst;
	Statement st;
	
	JLabel login=new JLabel("User Login");
	JLabel profile=new JLabel(new ImageIcon("pp.png"));
	JLabel username=new JLabel("Username");
	JLabel password=new JLabel("Password");
	
	
	JButton loginbutton=new JButton("Login");
	JButton exit=new JButton("EXIT");
	
	JTextField tf1=new JTextField();
	JPasswordField p1=new JPasswordField();
	
	public LoginPage()
	{
		setTitle("Team-7(MIT)");
		setSize(350,500);
		setLocation(400,100);
		setLayout(null);
		login.setBounds(110,25,100,30);
		login.setFont(new Font("Tahoma",Font.BOLD,18));
		add(login);
		//Icon icon=new ImageIcon(getClass().getResource("pp.png"));
		//l2.setIcon(new ImageIcon("pp.png"));
		profile.setBounds(60,60,200,100);
		add(profile);
		username.setBounds(70,180,100,25);
		add(username);
		tf1.setBounds(70,210,200,30);
		add(tf1);
		
		password.setBounds(70,270,100,25);
		add(password);
		p1.setBounds(70,300,200,30);
		add(p1);
		
		loginbutton.setBounds(70,385,80,30);
		add(loginbutton);
		
		exit.setBounds(190,385,80,30);
		add(exit);
		
		loginbutton.setFocusable(false);
		loginbutton.addActionListener(this);
		exit.addActionListener(this);
		
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {	
		user user=new user();
		user.setUsername(tf1.getText());
		user.setPassword(p1.getText());
		if(e.getSource()==loginbutton){
			try {
				boolean login=UserDA.login(user);
				if(login){
					JOptionPane.showMessageDialog(null,"Login Success");
				//new home();
				}
				else 
					JOptionPane.showMessageDialog(null, "Login Failed","Failed",JOptionPane.ERROR_MESSAGE);
			} 
			catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(e.getSource()==exit){
			dispose();
		}
	}
	public static void main(String[] args)
	{
		new LoginPage();
	}
	
}