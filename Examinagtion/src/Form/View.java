package Form;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class View extends JFrame implements ActionListener
{
	JTextField tf1,tf2,tf3,tf4;
	JLabel l1,l2,l3,l4;
	JButton b1,b2;
	
	View()
	{
		//JFrame f=new JFrame();
		JPanel p=new JPanel();
		l1=new JLabel("Academic");
		l2=new JLabel("Major");
		l3=new JLabel("Course");
		l4=new JLabel("Subject");
		
		tf1=new JTextField();
		tf2=new JTextField();
		tf3=new JTextField();
		tf4=new JTextField();
		
		b1=new JButton("View");
		b2=new JButton("Cancel");
		
		l1.setBounds(20,20,150,20);
		l2.setBounds(20,60,150,20);
		l3.setBounds(20,100,150,20);
		l4.setBounds(20,140,150,20);

		tf1.setBounds(170,20,150,20);
		tf2.setBounds(170,60,150,20);
		tf3.setBounds(170,100,150,20);
		tf4.setBounds(170,140,150,20);
		
		b1.setBounds(30,220,100,20);
		b2.setBounds(250,220,100,20);
		setLayout(new BorderLayout());
		
		add(BorderLayout.CENTER,p);
		p.add(l1);p.add(l2);p.add(l3);p.add(l4);
		p.add(tf1);p.add(tf2);p.add(tf3);p.add(tf4);
		p.add(b1);p.add(b2);
		p.setLayout(null);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		
	}
	public static void main(String[] args)
	{
		new View();
		
	}
	
}