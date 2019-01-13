package Model;

public class CourseModel extends SemesterModel{
	public String Course;

	public CourseModel(String course) {
		super();
		this.Course = course;
	}

	public CourseModel() {
		// TODO Auto-generated constructor stub
	}

	public String getCourse() {
		return Course;
	}

	public void setCourse(String course) {
		Course = course;
	}

	public String toString(){
		return Course;
	}

}
