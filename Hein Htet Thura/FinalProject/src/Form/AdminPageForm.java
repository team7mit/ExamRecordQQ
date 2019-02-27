package Form;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DataAccess.UserDA;
import Model.User;

public class AdminPageForm extends dataentry implements ActionListener{

	DefaultTableModel model=new DefaultTableModel();
	JTable table=new JTable(model);
	private JFrame frame;
	private JTextField userID;
	private JTextField username;
	private JPasswordField password;

	private	JButton approve = new JButton("Approve");
	private	JButton deletebutton = new JButton("Delete");
	
	
	private JRadioButton admin=new JRadioButton("Admin");
	private JRadioButton staff=new JRadioButton("staff");
	private ButtonGroup group=new ButtonGroup();
	 public AdminPageForm() {
		
		 frame=new JFrame();
		 frame.setLayout(null);
		 
		group.add(admin);
		group.add(staff);
		 
		 
		 Object column[]= {"ID","USERNAME","PASSWORD"};
		 model.setColumnIdentifiers(column);
		 
		 try {
			List<User> list=UserDA.UnapprovedUser();
			model.setRowCount(0);
			for(User user:list) {
				model.addRow(new Object[] {user.getUserid(),user.getUsername(),user.getPassword()});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 	approve.setBounds(150,450,100,30);
			frame.add(approve);
			
			deletebutton.setBounds(290, 450, 100, 30);
			frame.add(deletebutton);
			
			userID=new JTextField();
			userID.setEditable(false);
			userID.setBounds(100,270,100,30);
			frame.add(userID);
			
			username=new JTextField();
			username.setEditable(false);
			username.setBounds(100,320,100,30);
			frame.add(username);
			
			password=new JPasswordField();
			password.setEditable(false);
			password.setBounds(100,370,100,30);
			frame.add(password);
			
			admin.setBounds(100,420,100,30);
			frame.add(admin);
			staff.setBounds(200,420,100,30);
			frame.add(staff);
			
			table.addMouseListener(new MouseAdapter(){
				
				public void mouseClicked(MouseEvent e)
				{
					int i=table.getSelectedRow();
					userID.setText(model.getValueAt(i, 0).toString());
					username.setText(model.getValueAt(i, 1).toString());
					password.setText(model.getValueAt(i, 2).toString());
					
				}
			});
			
			approve.addActionListener(this);
			deletebutton.addActionListener(this);
			jsp=new JScrollPane(table);
			jsp.setBounds(50,100,400,150);
		 frame.add(jsp);
		 frame.setSize(500, 600);
		 frame.setVisible(true);
		 
	}
	

	public void actionPerformed(ActionEvent e) {
		
		User account=new User();
		account.setUserid(userID.getText());
		account.setUsername(username.getText());
		account.setPassword(password.getText());
		
		if(admin.isSelected()) {
			account.setLevel("ADMIN");
		}
		if(staff.isSelected()) {
			account.setLevel("STAFF");
		}
		
		if(e.getSource()==approve) {
			try {
				boolean check=UserDA.ApprovedUser(account);
				if(check) {
					JOptionPane.showMessageDialog(frame, "SUCCESS","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(frame, "FAILED", "FAILED", JOptionPane.INFORMATION_MESSAGE);				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
	}

}
