package Form;

import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

import DataAccess.UserDA;
import Model.User;
import Security.security;
import java.awt.Color;

public class SignUpForm extends dataentry implements ActionListener{
	


	private JFrame frame;
	private JTextField userID;
	private JTextField username;
	private JPasswordField password;
	private JPasswordField confirm;

	JButton btnNewButton = new JButton("Submit");
	public SignUpForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Team-7(MIT)");
		frame.getContentPane().setFont(new Font("Tahoma", Font.ITALIC, 13));
		frame.getContentPane().setBackground(new Color(0, 128, 128));
		frame.setBounds(500, 100, 341, 439);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel.setBounds(85, 67, 73, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel_1.setBounds(85, 134, 73, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel_2.setBounds(85, 201, 73, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		userID = new JTextField();
		userID.setForeground(new Color(0, 0, 0));
		userID.setBackground(new Color(255, 235, 205));
		userID.setBounds(85, 92, 123, 20);
		frame.getContentPane().add(userID);
		userID.setColumns(10);
		
		username = new JTextField();
		username.setBounds(85, 159, 123, 20);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(85, 226, 122, 20);
		frame.getContentPane().add(password);
		password.setColumns(10);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblConfirmPassword.setBounds(85, 263, 123, 14);
		frame.getContentPane().add(lblConfirmPassword);
		
		confirm = new JPasswordField();
		confirm.setBounds(85, 288, 122, 20);
		frame.getContentPane().add(confirm);
		confirm.setColumns(10);
		
		
		btnNewButton.setBounds(122, 346, 86, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblSignUp = new JLabel("Create New Account");
		lblSignUp.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblSignUp.setBounds(60, 11, 214, 35);
		frame.getContentPane().add(lblSignUp);
		
		btnNewButton.addActionListener(this);
		
		
		frame.setVisible(true);}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnNewButton) {
			String userid= userID.getText();
			String usernames=username.getText();
			String passwords=password.getText();
			String confirmed=confirm.getText();
			
			if(passwords.equals(confirmed) && !passwords.equals("")) {
				try {
				User user=new User();
				user.setUserid(userid);
				user.setUsername(usernames);
				user.setPassword(security.encrypt(passwords, "MTU"));
				System.out.println(userid+ "  "+usernames+"  "+user.getPassword());
				boolean check=UserDA.userCreateByUser(user);
				if(check) {
					JOptionPane.showMessageDialog(frame," Account Created, \n Wait For Admi's Approved", "  ", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(frame," Account Creation Failed, \n Wait For Admi's Approved", "  ", JOptionPane.INFORMATION_MESSAGE);
				}
				
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if(userid.equals("") || usernames.equals("") || passwords.equals("")) {
				JOptionPane.showMessageDialog(frame, " Fill Requirements "," ", JOptionPane.WARNING_MESSAGE);
			}
			else {
				//System.out.println(passwords+"    "+confirmed);
				JOptionPane.showMessageDialog(frame, " Password Must be Same", "Account cannot Create", JOptionPane.WARNING_MESSAGE);
				
				
				
			}
		}
		
	}

}
