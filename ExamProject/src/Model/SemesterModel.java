package Model;

public class SemesterModel extends MajorModel{
	public String semester;
	public SemesterModel(String semester){
		this.semester=semester;
	}

	public SemesterModel() {
		// TODO Auto-generated constructor stub
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String toString(){
		return semester;
	}

}
