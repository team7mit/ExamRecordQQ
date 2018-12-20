package DataAccess;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

import Model.StudentModel;

public class SortingExamMark {
public static List<StudentModel> SortStudent(List<StudentModel> StudentList){
		
		
		Comparator<StudentModel> com=new Comparator<StudentModel>(){

			@Override
			public int compare(StudentModel stu1, StudentModel stu2) {
				if(stu1.getTotal() > stu2.getTotal()){
					 return -1;
				}
				else if(stu1.getTotal() < stu2.getTotal()){
					return 1;
					}
				return 0;
			}
			
		};
		Collections.sort(StudentList, com);
		return StudentList;
	}
}
