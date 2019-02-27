package Form;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DataAccess.AcademicDA;
import DataAccess.MajorDA;
import DataAccess.MarkDA;
import DataAccess.SubjectDA;
import Model.AcademicModel;
import Model.CourseModel;
import Model.MajorModel;
import Model.StudentModel;
import Model.SubjectModel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public class ReMarksForm extends dataentry {
	static JFrame frame=new JFrame();
	JPanel panel = new JPanel();
	JPanel panel1=new JPanel();
	JButton b=new JButton("OK");
	JButton insertReMarks=new JButton("Insert");
	DefaultTableModel model=new DefaultTableModel();
	JTable table=new JTable(model);
	JScrollPane jsp=new JScrollPane(table);
	Vector<String> column=new Vector<String>();
	static 	StudentModel student1=new StudentModel();
	
	public ReMarksForm() {
		
		student1.setAcademicID(student1.getAcademicID());
		student1.setMajorID(student1.getMajorID());
		student1.setCourse(student1.getCourse());
		
		insertReMarks.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent arg0) {
				if(checkmark(model))
				{
					student1.setSubcode(subcodefield.getSelectedItem().toString());
					try {
						boolean check=MarkDA.reInsert(model, student1);
							if(check)
								JOptionPane.showMessageDialog(frame, "Insert Successfully","Success", JOptionPane.INFORMATION_MESSAGE);
							else 
								JOptionPane.showMessageDialog(frame, "Insert Failed Check Again", "Failed", JOptionPane.ERROR_MESSAGE);
					} catch (SQLException e1) {
						
						e1.printStackTrace(); 
					}		
				}
				else {
					JOptionPane.showMessageDialog(frame, "Insert Failed Check Again", "Failed", JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
		});
		
		
		
	}
	@SuppressWarnings("finally")
	public static boolean checkmark(DefaultTableModel model1) {
		int row=model1.getRowCount();
		//int column=model1.getColumnCount();

		double exam;
		boolean check=false;
	try {
		
		for(int i=0;i<row;i++){

				exam=Integer.parseInt(model1.getValueAt(i, 3).toString()) * 0.8;

					if(exam < 0 || exam> 80) {
						check = false;
					}
					else check= true;
			}
		
	} 
	catch (NumberFormatException e) {
		
		JOptionPane.showMessageDialog(frame,"Marks Type is Wrong CHECK AGAIN","FONT ERROR",JOptionPane.ERROR_MESSAGE);
	}
	catch(NullPointerException e) {
		JOptionPane.showMessageDialog(frame," FILL MARKS ","Mark Not Fill",JOptionPane.ERROR_MESSAGE);
	}
	finally {
		return check;
	}
	
}
	
}
