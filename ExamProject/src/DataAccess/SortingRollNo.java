package DataAccess;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

import Model.StudentModel;

public class SortingRollNo {
	//Sort Students By Roll_NOs
	public static List<StudentModel> SortStudent(List<StudentModel> StudentList){
		
		
		Comparator<StudentModel> com=new Comparator<StudentModel>(){

			@Override
			public int compare(StudentModel stu1, StudentModel stu2) {
				if(sortstudent(stu1) > sortstudent(stu2)){
					 return 1;
				}
				else if(sortstudent(stu1) < sortstudent(stu2)){
					return -1;
					}
				return 0;
			}
			
		};
		Collections.sort(StudentList, com);
		return StudentList;
	}
	
	// Getting RollNo
	public static int sortstudent(StudentModel student){
		int roll=0;
		StringTokenizer st=new StringTokenizer(student.getRollno(),"-");
		while(st.hasMoreTokens()){
		String s=st.nextToken();
		roll=Integer.parseInt(st.nextToken());
	}
		return roll;
}
}
