package form;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;
import javax.swing.*;
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
		String name=tf1.getText();
		String password=p1.getText();
		String dbname="user";
		String pp="12345";
		
		if(e.getSource()==loginbutton){
			if(name.equals("") || password.equals("")){
				JOptionPane.showMessageDialog(null, "Enter Username and Password","Check",JOptionPane.WARNING_MESSAGE);
			}
		else if(name.equalsIgnoreCase(dbname) && password.equals(pp)){
			dispose();
			new home();	
		}
		else{
			JOptionPane.showMessageDialog(null,"Login Failed!! \n Please Try Again!!!!!!","Error",JOptionPane.ERROR_MESSAGE);
			tf1.setText(null);
			p1.setText(null);
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
