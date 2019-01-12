package Model;

public class StudentModel extends MarkModel{
	
	 public  String student_id;
	 public String student_name;
	 public String rollno;
	 public String newroll;

	public String getNewroll() {
		return newroll;
	}

	public void setNewroll(String newroll) {
		this.newroll = newroll;
	}

	public String getStuid() {
	 	return student_id;
	 }

	 public void setStuid(String stuid) {
	 	this.student_id = stuid;
	 }

	 public String getStuname() {
	 	return student_name;
	 }

	 public void setStuname(String stuname) {
	 	this.student_name = stuname;
	 }

	 public String getRollno() {
	 	return rollno;
	 }

	 public void setRollno(String rollno) {
	 	this.rollno = rollno;
	 }

	
	
	
}
