package Form;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DataAccess.AcademicDA;
import DataAccess.MajorDA;
import DataAccess.MarkDA;
import DataAccess.ResultDA;
import DataAccess.SortingExamMark;
import DataAccess.SubjectDA;
import Model.AcademicModel;
import Model.CourseModel;
import Model.MajorModel;
import Model.StudentModel;

public class RollNo extends Home implements ActionListener{

	private JFrame frame;
	JMenuBar mb=new JMenuBar();
	JMenu file=new JMenu("File");
	JMenuItem goback=new JMenuItem("Home");
	
	private static JTable table;
	public DefaultTableModel model=new DefaultTableModel();
	public StudentModel student = new StudentModel();
	public static JButton convert=new JButton("Convert");

	private JPanel panel;
	//static JButton ok=new JButton("OK");
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RollNo window = new RollNo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/	public RollNo() {
		initialize();
	}
	public static void UpdateRollNos(){
		sortRollno.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent e1) {
				
				insertdata.removeAll();
				insertdata.validate();
				insertdata.repaint();
				
				c.add(insertdata,BorderLayout.CENTER);
				insertdata.setLayout(null);
				
				acayearlabel.setBounds(50,50,90,25);
				insertdata.add(acayearlabel);
				academicfield.setBounds(150,50,150,25);
				insertdata.add(academicfield);
				
				majornamelabel.setBounds(50,100,90,25);
				insertdata.add(majornamelabel);
				majorfield.setBounds(150,100,150,25);
				insertdata.add(majorfield);
				
				courselabel.setBounds(50,150,90,25);
				insertdata.add(courselabel);
				coursefield.setBounds(150,150,150,25);
				insertdata.add(coursefield);
				
				ok.setBounds(100,300,150,30);
				insertdata.add(ok);
				convert.addActionListener(this);
				Department_And_Subject.addComboBox();
				ok.addActionListener(new ActionListener(){

					
					public void actionPerformed(ActionEvent n) {
						new RollNo();
						
					}
					
				});
				
			}
			
		});
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		table = new JTable(model);
		Object[] columns={"No","Name"," Previous Roll"," Current Roll"};
		model.setColumnIdentifiers(columns);
		JScrollPane scrollBar = new JScrollPane(table);
		frame.getContentPane().add(scrollBar, BorderLayout.CENTER);
		frame.getContentPane().add(convert, BorderLayout.SOUTH);
		panel = new JPanel();
		
		goback.addActionListener(this);
		file.add(goback);
		mb.add(file);
		frame.add(mb,BorderLayout.NORTH);
		frame.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==goback){
			new Home();
		}
		
			student.setAcademicID(academicfield.getSelectedItem().toString());
			student.setMajorID(majorfield.getSelectedItem().toString());
			student.setCourse(coursefield.getSelectedItem().toString());
			
		if(e.getSource()==ok) {
			try {
			model.setRowCount(0);
			List<StudentModel> list=MarkDA.insertMark(student);
			
			int i=1;
		for(StudentModel student: list){
			model.addRow(new Object[]{i++,student.getStuname(),student.getRollno()});
			
		}
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		}
		
		
		if(e.getSource()==convert) {
			List<StudentModel> rolllist=new ArrayList<StudentModel>();
			if(model.getRowCount() <= 0) {
			JOptionPane.showMessageDialog(this, "NO STUDENT IN TABLE!!!!!!");
			}
			else {
				try {
					Vector<String> list=ResultDA.rollUpdate(student);
					boolean fail=false;
					StudentModel examstudent;
					for(int studentCount=0;studentCount < model.getRowCount();studentCount++) {
						
						examstudent=new StudentModel();
						examstudent.setStuname(model.getValueAt(studentCount,1).toString());
						examstudent.setAcademicID(student.getAcademicID());
						examstudent.setRollno(model.getValueAt(studentCount,2).toString());
						int total=0;
						
						for(int subject=0;subject<list.size();subject++) {
							examstudent.setSubcode(list.get(subject));
							int mark=Integer.parseInt(ResultDA.getAllMarks(examstudent, model));
								if( mark  < 40 ) { 
									fail=true;
									break;
								}
								total=total + mark;
						
						}
								if(fail) {
									model.removeRow(studentCount);
								System.out.println(examstudent.getRollno()+"\t FAILED");
									break;
								}
								examstudent.setTotal(total);
								rolllist.add(examstudent);
								
					
					}
					
				List<StudentModel>	newrolllist=SortingExamMark.SortStudent(rolllist);
				
				int i=1;
				model.setRowCount(0);
					for(StudentModel student1: newrolllist) {
						String rollno=student1.getRollno();
						
								
						StringTokenizer st=new StringTokenizer(rollno,".-");
						while(st.hasMoreTokens()) {
							String year=st.nextToken();
							String convo=st.nextToken();
							String major=st.nextToken();
							String roll=st.nextToken();
							System.out.println("Before replace "+year);
							switch(year) {
							case "I": year="II";break;
							case "II":year="III";break;
							case "III":year="IV";break;
							case "IV":year="V";break;
							case "V":year="VI";break;
							default : 
							}
		
							System.out.println("After replace "+year);
							String newroll=year+"."+convo+"."+major+"-"+String.valueOf(i);
							student1.setNewroll(newroll);
				
							
							model.addRow(new Object[] {i,student1.getStuname(),student1.getRollno(),student1.getNewroll()});
						i++;	
						}
					}
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		}
	}
/*
	public static void totalMarkUpdate(StudentModel student1,DefaultTableModel model1) throws SQLException {
		for(int row=0;row<model1.getRowCount();row++) {
				
				String a=ResultDA.getAllMarks(student1,model1);
				System.out.println();
				//model1.setValueAt(a, row, mark);
				//table.getColumnModel().getColumn(mark).setCellRenderer(new MyCellRenderer());
		}	
	}*/
	
}
