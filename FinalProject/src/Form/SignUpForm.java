package Form;

import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

import DataAccess.UserDA;
import Model.User;
import Security.security;

public class SignUpForm extends dataentry implements ActionListener{
	


	private JFrame frame;
	private JTextField userID;
	private JTextField username;
	private JPasswordField password;
	private JPasswordField confirm;

	JButton btnNewButton = new JButton("Sign Up");
	public SignUpForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User ID");
		lblNewLabel.setBounds(19, 68, 73, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(19, 111, 73, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(19, 151, 73, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		userID = new JTextField();
		userID.setBounds(129, 65, 86, 20);
		frame.getContentPane().add(userID);
		userID.setColumns(10);
		
		username = new JTextField();
		username.setBounds(129, 108, 86, 20);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(129, 148, 86, 20);
		frame.getContentPane().add(password);
		password.setColumns(10);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setBounds(19, 192, 100, 14);
		frame.getContentPane().add(lblConfirmPassword);
		
		confirm = new JPasswordField();
		confirm.setBounds(129, 189, 86, 20);
		frame.getContentPane().add(confirm);
		confirm.setColumns(10);
		
		
		btnNewButton.setBounds(66, 229, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblSignUp = new JLabel("Sign Up");
		lblSignUp.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSignUp.setBounds(46, 22, 118, 35);
		frame.getContentPane().add(lblSignUp);
		
		btnNewButton.addActionListener(this);
		
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnNewButton) {
			String userid= userID.getText();
			String usernames=username.getText();
			String passwords=password.getText();
			String confirmed=confirm.getText();
			
			if(passwords.equals(confirmed)) {
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
				System.out.println(passwords+"    "+confirmed);
				JOptionPane.showMessageDialog(frame, " Password Must be Same", "Account cannot Create", JOptionPane.WARNING_MESSAGE);
				
				
				
			}
		}
		
	}

}
