package Form;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class InsertMarksByEach {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertMarksByEach window = new InsertMarksByEach();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InsertMarksByEach() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 727, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblStudentid = new JLabel("StudentID");
		lblStudentid.setBounds(21, 32, 65, 14);
		panel.add(lblStudentid);
		
		textField = new JTextField();
		textField.setBounds(94, 29, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(21, 72, 46, 14);
		panel.add(lblName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(94, 69, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblRollNo = new JLabel("Roll No");
		lblRollNo.setBounds(21, 113, 46, 14);
		panel.add(lblRollNo);
		
		textField_2 = new JTextField();
		textField_2.setBounds(94, 110, 86, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblSubjectCode = new JLabel("Subject Code");
		lblSubjectCode.setBounds(21, 149, 65, 14);
		panel.add(lblSubjectCode);
		
		textField_3 = new JTextField();
		textField_3.setBounds(94, 146, 86, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(21, 200, 165, 2);
		panel.add(separator);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(21, 235, 46, 14);
		panel.add(lblTotal);
		
		textField_4 = new JTextField();
		textField_4.setBounds(94, 232, 86, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblRanking = new JLabel("Ranking");
		lblRanking.setBounds(21, 278, 46, 14);
		panel.add(lblRanking);
		
		textField_5 = new JTextField();
		textField_5.setBounds(94, 275, 86, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblSubj = new JLabel("Subj1");
		lblSubj.setBounds(281, 32, 46, 14);
		panel.add(lblSubj);
		
		JLabel lblSubj_1 = new JLabel("Subj2");
		lblSubj_1.setBounds(281, 60, 46, 14);
		panel.add(lblSubj_1);
		
		JLabel lblSunj = new JLabel("Subj3");
		lblSunj.setBounds(281, 101, 46, 14);
		panel.add(lblSunj);
		
		JLabel lblSubj_2 = new JLabel("Subj4");
		lblSubj_2.setBounds(281, 142, 46, 14);
		panel.add(lblSubj_2);
		
		JLabel lblSubj_3 = new JLabel("Subj5");
		lblSubj_3.setBounds(281, 184, 46, 14);
		panel.add(lblSubj_3);
		
		JLabel lblSubj_4 = new JLabel("Subj6");
		lblSubj_4.setBounds(281, 228, 46, 14);
		panel.add(lblSubj_4);
		
		JLabel lblSubj_5 = new JLabel("Subj7");
		lblSubj_5.setBounds(281, 278, 46, 14);
		panel.add(lblSubj_5);
		
		JLabel lblSubj_6 = new JLabel("Subj8");
		lblSubj_6.setBounds(281, 308, 46, 14);
		panel.add(lblSubj_6);
		
		textField_6 = new JTextField();
		textField_6.setBounds(322, 29, 97, 20);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(322, 57, 97, 20);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(322, 98, 97, 20);
		panel.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(322, 146, 97, 20);
		panel.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(322, 181, 97, 20);
		panel.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(322, 232, 97, 20);
		panel.add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setBounds(322, 275, 97, 20);
		panel.add(textField_12);
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setBounds(322, 305, 97, 20);
		panel.add(textField_13);
		textField_13.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.EAST);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JTextArea textArea = new JTextArea();
		textArea.setRows(10);
		textArea.setColumns(10);
		panel_1.add(textArea, BorderLayout.NORTH);
	}
}
