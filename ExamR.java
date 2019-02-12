package GUI;
import java.util.*;
import javax.swing.*;
public class ExamR extends JFrame
{
	public ExamR()
	{
		JFrame f=new JFrame("Exam Record");
		JButton b=new JButton("Next");
		JTextField t1,t2,t3;
		t1=new JTextField();
		t2=new JTextField();
		t3=new JTextField();
		JLabel l1,l2,l3,l4,l5,l6,l7;
		l1=new JLabel("Student ID");
		l2=new JLabel("Student Name");
		l3=new JLabel("Roll Number");
		l4=new JLabel("Department ID");
		l5=new JLabel("Course");
		l6=new JLabel("Academic Year");
		JRadioButton r1= new JRadioButton("First Semester");
		JRadioButton r2= new JRadioButton("Second Semester");
		ButtonGroup r=new ButtonGroup();
		String ID[]={"CE","Arch","Mech","CEIT","EC","EP","MC","Ch.E","Mining","Nuclear","Biotech"};
		JComboBox IDlist=new JComboBox(ID);
		String Course[]={"First Year","Second Year","Third Year","Fourth Year","Fifth Year","Sixth Year","Master","PHD"};
		JComboBox Courselist=new JComboBox(Course);
		ArrayList <String> y=new ArrayList <String>();
		for(int i=0;i<=86;i++)
		{
			y.add("20"+(12+i)+"-20"+(13+i));
		}
		Object[] objNames = y.toArray();
		String[] Year = Arrays.copyOf(objNames, objNames.length, String[].class);
		JComboBox Yearlist=new JComboBox(Year);
		f.setLayout(null);
		f.add(b);
		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(l4);
		f.add(l5);
		f.add(l6);
		f.add(t1);
		f.add(t2);
		f.add(t3);
		f.add(IDlist);
		f.add(Courselist);
		f.add(Yearlist);
		f.add(r1);
		f.add(r2);
		r.add(r1);
		r.add(r2);
		b.setBounds(280, 400, 70, 30);
		l1.setBounds( 50, 50, 100, 20);
		l2.setBounds( 50, 100, 100, 20);
		l3.setBounds( 50, 150, 100, 20);
		l4.setBounds( 50, 200, 100, 20);
		l5.setBounds( 50, 250, 100, 20);
		l6.setBounds( 50, 300, 100, 20);
		r1.setBounds(40, 350, 150, 20);
		t1.setBounds( 200, 50, 100, 20);
		t2.setBounds( 200, 100, 100, 20);
		t3.setBounds( 200, 150, 100, 20);
		IDlist.setBounds(200, 200, 100, 20);
		Courselist.setBounds(200, 250, 100, 20);
		Yearlist.setBounds(200, 300, 100, 20);
		r2.setBounds(190, 350, 170, 20);
		f.setVisible(true);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setSize(400,500);
	}
	public static void main(String args[])
	{
		new ExamR();
	}
	
}
