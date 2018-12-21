package Form;

import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Home extends dataentry implements ActionListener{
private JFrame f=new JFrame();
	
	public Home(){
		
		f.setTitle("TEAM-7(MIT)");
		f.getContentPane().setLayout(null);
		deptsub.setBounds(50,50,200,25);
		f.getContentPane().add(deptsub);
		
		view.setBounds(50,75,200,25);
		f.getContentPane().add(view);
		
		//search.setBounds(50,100,200,25);
		//f.add(search);
		
		cancel.setBounds(50,200,80,25);
		f.getContentPane().add(cancel);
		
		next.setBounds(150,200,80,25);
		f.getContentPane().add(next);
		
		next.addActionListener(this);
		cancel.addActionListener(this);
		
		deptsub.addActionListener(this);
		view.addActionListener(this);
		
		JMenuBar menuBar = new JMenuBar();
		f.setJMenuBar(menuBar);
		
		JMenu mnew = new JMenu("New");
		menuBar.add(mnew);

		//search.addActionListener(this);
		
		
		f.setResizable(true);
		f.setLocation(500,200);
		f.setSize(300,350);
		f.setVisible(true);
		
	}
	public static void main(String args[])
	{
		new Home();
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==next){
			if(deptsub.isSelected()){		
			new Department_And_Subject();	
			}
			if(view.isSelected()){		
				new ShowStuMarks();			
			}
		}
		if(e.getSource()==cancel){
			System.exit(0);
		}
	}

}
