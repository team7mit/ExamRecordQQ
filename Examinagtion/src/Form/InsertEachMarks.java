package Form;

import java.awt.BorderLayout;

import javax.swing.*;

public class InsertEachMarks extends JFrame{
	
	
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JPanel p3=new JPanel();
	
	JLabel stuID=new JLabel("Student ID");
	JLabel name=new JLabel("Name");
	JLabel rno=new JLabel("Roll No");
	JLabel subcode=new JLabel("Subject Code");
	JLabel total=new JLabel("Total");
	JLabel rank=new JLabel("Ranking");
	JLabel sub1=new JLabel("Sub1");
	JLabel sub2=new JLabel("Sub2");
	JLabel sub3=new JLabel("Sub3");
	JLabel sub4=new JLabel("Sub4");
	JLabel sub5=new JLabel("Sub5");
	JLabel sub6=new JLabel("Sub6");
	JLabel sub7=new JLabel("Sub7");
	JLabel sub8=new JLabel("Sub8");
	
	JTextField idfield=new JTextField();
	JTextField namefield=new JTextField();
	JTextField rnofield=new JTextField();
	JTextField subcodefield=new JTextField();
	JTextField totalfield=new JTextField();
	JTextField rankfield=new JTextField();
	JTextField subfield1=new JTextField();
	JTextField subfield2=new JTextField();
	JTextField subfield3=new JTextField();
	JTextField subfield4=new JTextField();
	JTextField subfield5=new JTextField();
	JTextField subfield6=new JTextField();
	JTextField subfield7=new JTextField();
	JTextField subfield8=new JTextField();
	
	JTextArea area=new JTextArea();
	//JScrollPane jsp1=new JScrollPane(area);
	
	public InsertEachMarks(){
		super("Team-7(MIT)");
		
		p2.setLayout(new BorderLayout());
		p2.add(area);
		
		add(p1,BorderLayout.CENTER);
		//add(p2,BorderLayout.EAST);
		//add(p3,BorderLayout.SOUTH);
		
		p1.setLayout(null);
		
		stuID.setBounds(50,50,100,25);
		p1.add(stuID);
		idfield.setBounds(150,50,150,25);
		p1.add(idfield);
		
		name.setBounds(50,100,100,25);
		p1.add(name);
		namefield.setBounds(150,100,150,25);
		p1.add(namefield);
		
		rno.setBounds(50,150,100,25);
		p1.add(rno);
		rnofield.setBounds(150,150,150,25);
		p1.add(rnofield);
		
		subcode.setBounds(50,200,100,25);
		p1.add(subcode);
		subcodefield.setBounds(150,200,150,25);
		p1.add(subcodefield);
		
		JSeparator separator=new JSeparator();
		separator.setBounds(40,250,260,2);
		p1.add(separator);
		
		total.setBounds(50,275,100,25);
		p1.add(total);
		totalfield.setBounds(150,275,150,25);
		p1.add(totalfield);
		
		rank.setBounds(50,330,100,25);
		p1.add(rank);
		rankfield.setBounds(150,330,150,25);
		p1.add(rankfield);
		
		
		sub1.setBounds(350,50,100,25);
		p1.add(sub1);
		subfield1.setBounds(450,50,100,25);
		p1.add(subfield1);
		
		sub2.setBounds(350,90,100,25);
		p1.add(sub2);
		subfield2.setBounds(450,90,100,25);
		p1.add(subfield2);
		
		sub3.setBounds(350,130,100,25);
		p1.add(sub3);
		subfield3.setBounds(450,130,100,25);
		p1.add(subfield3);
		
		sub4.setBounds(350,170,100,25);
		p1.add(sub4);
		subfield4.setBounds(450,170,100,25);
		p1.add(subfield4);
		
		sub5.setBounds(350,210,100,25);
		p1.add(sub5);
		subfield5.setBounds(450,210,100,25);
		p1.add(subfield5);
		
		sub6.setBounds(350,250,100,25);
		p1.add(sub6);
		subfield6.setBounds(450,250,100,25);
		p1.add(subfield6);
		
		sub7.setBounds(350,290,100,25);
		p1.add(sub7);
		subfield7.setBounds(450,290,100,25);
		p1.add(subfield7);
		
		sub8.setBounds(350,330,100,25);
		p1.add(sub8);
		subfield8.setBounds(450,330,100,25);
		p1.add(subfield8);
		
		area.setBounds(700,50,600,300);
		p1.add(area);
		
		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
		
	}
	public static void main(String args[])
	{
		new InsertEachMarks();
	}

}
