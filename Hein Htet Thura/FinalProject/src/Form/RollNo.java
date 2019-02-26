package Form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DataAccess.MarkDA;
import DataAccess.ResultDA;
import DataAccess.SortingExamMark;
import DataAccess.SortingRollNo;
import DataAccess.StudentDA;
import Model.AcademicModel;
import Model.StudentModel;

public class RollNo extends Home implements ActionListener{

	private static JFrame frames;
	private static JScrollPane scrollBar;
	private static JTable table;
	public static DefaultTableModel models=new DefaultTableModel();
	public static StudentModel student = new StudentModel();
	public static JButton convert=new JButton("Convert");
	public static JRadioButton oldroll=new JRadioButton(" Sort Previous Roll No");
	public static JRadioButton newrolls=new JRadioButton(" Sort New Roll No");
	public ButtonGroup bg=new ButtonGroup();
	private JPanel panel;
	JPanel panel1=new JPanel();
	static JButton ok=new JButton(" FIND ");
	static JButton rollnoOK=new JButton("OK");
	static JButton create=new JButton(" Update New Academic");
	JMenu file=new JMenu("File");
	JMenuItem goback=new JMenuItem("Home");
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
	frames = new JFrame();
	frames.setBounds(100, 100, 450, 300);
	frames.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	bg.add(oldroll);
	bg.add(newrolls);
	
	
	table = new JTable(models);
	Object[] columns={"No","Student ID"," Previous Roll"," Current Roll"," Marks"};
	models.setColumnIdentifiers(columns);
	scrollBar = new JScrollPane(table);
	

	
	panel = new JPanel();
	panel.add(academicfield);
	
	panel.add(create);
	
	panel.add(new JLabel(" Make Sure New Academic is Created "));
	frames.add(panel);
	
	
	file.add(goback);
	mb.add(file);
	//frame.add(mb,BorderLayout.NORTH);
	
	panel1.add(oldroll);
	panel1.add(newrolls);
	panel1.add(convert);
	create.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==create) {
			try {	
				StudentModel stu=new StudentModel();
				AcademicModel academicmodel=(AcademicModel) academicfield.getSelectedItem();
				stu.setAcademicID(academicmodel.academicID);
				for(int studentCount=0;studentCount< models.getRowCount();studentCount++) {
					stu.setStuid(models.getValueAt(studentCount,1).toString());
					stu.setAcademicID(student.getAcademicID());
					
					
						stu.setRollno(models.getValueAt(studentCount,3).toString());
						boolean check=StudentDA.updateNewStudentForNewAcademic(stu);
						
						if(check) {
							JOptionPane.showMessageDialog(frames, " Students are created", "Success",JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(frames, " Failed", "Failed",JOptionPane.INFORMATION_MESSAGE);
						}
						
					}
					
				
				}
				
				catch(NullPointerException e1) {
						JOptionPane.showMessageDialog(frames, " Convert Roll_No First", "Success",JOptionPane.INFORMATION_MESSAGE);
					}
					catch (SQLException e1) {
						
						e1.printStackTrace();
					}
				
			}
			
		}
		
	});
	convert.addActionListener(new ActionListener() {

		
		
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==convert) {
				//AcademicModel academicmodel=(AcademicModel) academicfield.getSelectedItem();
				//student.setAcademicID(academicmodel.academicID);
				//student.setMajorID(majorfield.getSelectedItem().toString());
				//student.setCourse(coursefield.getSelectedItem().toString());
				
				List<StudentModel> rolllist=new ArrayList<StudentModel>();
				if(models.getRowCount() <= 0) {
				JOptionPane.showMessageDialog(frames, "NO STUDENT IN TABLE!!!!!!");
				}
				else {
					try {
						Vector<String> list=ResultDA.rollUpdate(student);
						System.out.println("COURSE"+student.academicID);
						System.out.println(list+" Subject");
						boolean fail=false;
						StudentModel examstudent;
						for(int studentCount=0;studentCount < models.getRowCount();studentCount++) {
							
							examstudent=new StudentModel();
							examstudent.setStuid(models.getValueAt(studentCount,1).toString());
							examstudent.setAcademicID(student.getAcademicID());
							examstudent.setRollno(models.getValueAt(studentCount,2).toString());
							int total=0;
							
							for(int subject=0;subject<list.size();subject++) {
								examstudent.setSubcode(list.get(subject));
								int mark=Integer.parseInt(ResultDA.getAllMarks(examstudent, models));
							//	System.out.println(mark+"  EXAM");
									if( mark  < 40 ) { 
										fail=true;
										break;
									}
									total=total + mark;
							
							}
									if(fail) {
										models.removeRow(studentCount);
									System.out.println(examstudent.getRollno()+"\t FAILED");
										break;
									}
									examstudent.setTotal(total);
									rolllist.add(examstudent);
									
						
						}
						
						rolllist=SortingExamMark.SortStudent(rolllist);
					
					
					int i=1;
					models.setRowCount(0);
						for(StudentModel student1: rolllist) {
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
								String newroll=year+"."+convo+"."+major+"-"+String.valueOf(i++);
								student1.setNewroll(newroll);
							
							//	
						
								
							}
						}
						if(oldroll.isSelected()) {
						rolllist=SortingRollNo.SortStudent(rolllist);
						}
						int j=1;
						if(newrolls.isSelected()) {
							rolllist=SortingExamMark.SortStudent(rolllist);
						}
						for(StudentModel stu:rolllist) {
							models.addRow(new Object[] { j++,stu.getStuid(),stu.getRollno(),stu.getNewroll(),stu.getTotal()});
						}

					
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
				}
			}
			
		}
		
	});
	
	collectRoll();
	newrolls.addActionListener(this);
	frames.getContentPane().add(panel, BorderLayout.NORTH);
	frames.getContentPane().add(panel1, BorderLayout.SOUTH);
	frames.getContentPane().add(scrollBar, BorderLayout.CENTER);
	Department_And_Subject.addComboBox();
	frames.setVisible(true);
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
				Department_And_Subject.addComboBox();
				ok.addActionListener(new ActionListener(){

					
					public void actionPerformed(ActionEvent n) {	
							AcademicModel academicmodel=(AcademicModel) academicfield.getSelectedItem();
							student.setAcademicID(academicmodel.academicID);
							student.setMajorID(majorfield.getSelectedItem().toString());
							student.setCourse(coursefield.getSelectedItem().toString());
						new RollNo();
						
					}
					
				});
				
			}
			
		});
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==goback){
			new Home();
		}	
	}
	public static void collectRoll() {
		
		try {
			models.setRowCount(0);
			List<StudentModel> list=MarkDA.insertMark(student);
			
			int i=1;
		for(StudentModel student: list){
			models.addRow(new Object[]{i++,student.getStuid(),student.getRollno()});
			
		}
		
		//System.out.println(models.getValueAt(0, 1));
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
	
	}
	
}
