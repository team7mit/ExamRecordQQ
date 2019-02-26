package Form;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.*;
import javax.swing.*;

import DataAccess.UserDA;

//import Data_Access.UserDaA;

import Model.User;
public class LoginPage extends JFrame implements ActionListener{
	
	Connection cnn;
	ResultSet rst;
	Statement st;
	
	JLabel login=new JLabel("User Login");
	JLabel profile=new JLabel(new ImageIcon("pp.png"));
	JLabel username=new JLabel("User ID");
	JLabel password=new JLabel("Password");
	JLabel signup=new JLabel("<html><u>click here to create new account</u></html>");
	
	
	JButton loginbutton=new JButton("Login");
	JButton exit=new JButton("EXIT");
	JTextField tf1=new JTextField();
	JPasswordField p1=new JPasswordField();
	
	public LoginPage()
	{
		getContentPane().setFont(new Font("Tahoma", Font.ITALIC, 13));
		getContentPane().setBackground(new Color(0, 128, 128));
		setTitle("Team-7(MIT)");
		setSize(350,500);
		setLocation(400,100);
		getContentPane().setLayout(null);
		login.setBackground(new Color(0, 0, 0));
		login.setForeground(new Color(0, 0, 0));
		login.setBounds(110,25,100,30);
		login.setFont(new Font("Tahoma",Font.BOLD,18));
		getContentPane().add(login);
		profile.setForeground(new Color(240, 255, 255));
		profile.setBackground(new Color(192, 192, 192));
		//Icon icon=new ImageIcon(getClass().getResource("pp.png"));
		//l2.setIcon(new ImageIcon("pp.png"));
		profile.setBounds(60,60,200,114);
		getContentPane().add(profile);
		username.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		username.setBounds(70,185,100,25);
		getContentPane().add(username);
		tf1.setBackground(new Color(238, 232, 170));
		tf1.setBounds(70,210,200,30);
		getContentPane().add(tf1);
		password.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		
		password.setBounds(70,251,100,25);
		getContentPane().add(password);
		p1.setBackground(new Color(238, 232, 170));
		p1.setBounds(70,272,200,30);
		getContentPane().add(p1);
		loginbutton.setForeground(new Color(127, 255, 212));
		loginbutton.setBackground(new Color(0, 0, 255));
		loginbutton.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		loginbutton.setBounds(190,336,80,30);
		getContentPane().add(loginbutton);
		exit.setForeground(new Color(127, 255, 212));
		exit.setBackground(new Color(255, 0, 0));
		exit.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		exit.setBounds(70,336,80,30);
		getContentPane().add(exit);
		signup.setFont(new Font("Tahoma", Font.ITALIC, 12));
		
		signup.setBounds(70,389,190,30);
		signup.setForeground(new Color(255, 255, 224));
		getContentPane().add(signup);
		
		loginbutton.setFocusable(false);
		loginbutton.addActionListener(this);
		exit.addActionListener(this);
		
		signup.addMouseListener(new MouseAdapter( ){

			
			public void mouseClicked(MouseEvent arg0) {
				
				dispose();
				new SignUpForm();
				
			}
			
		});
		                                     
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {	
		User user=new User();
		user.setUserid(tf1.getText());
		user.setPassword(p1.getText());
		if(e.getSource()==loginbutton){
			try {
				boolean login=UserDA.login(user);
				if(login){
					this.dispose();
					String level=UserDA.VerifyUserLevel(user);
					if(level.equals("STAFF")) {
						new Home();
					}
					else{
						new AdminPageForm();
					}
				
				}
				else 
					JOptionPane.showMessageDialog(this, "Login Failed","Failed",JOptionPane.ERROR_MESSAGE);
			} 
			catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()==signup) {
			dispose();
			new SignUpForm();
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

