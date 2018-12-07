package model;

public class Marks extends Subject {

	public String Stuid;
	public String Subcode;
	public String academic;
	public String papercode;
	public int exam;
	public int tutorial;
	public int practical;
	public int Total;
	public int ReExam;
	public String Semester;
	
	public String getStuid() {
		return Stuid;
	}

	public void setStuid(String stuid) {
		Stuid = stuid;
	}

	public String getSubcode() {
		return Subcode;
	}

	public void setSubcode(String subcode) {
		Subcode = subcode;
	}

	public String getAcademic() {
		return academic;
	}

	public void setAcademic(String academic) {
		this.academic = academic;
	}

	public String getPapercode() {
		return papercode;
	}

	public void setPapercode(String papercode) {
		this.papercode = papercode;
	}

	public int getExam() {
		return exam;
	}

	public void setExam(int exam) {
		this.exam = exam;
	}

	public int getTutorial() {
		return tutorial;
	}

	public void setTutorial(int tutorial) {
		this.tutorial = tutorial;
	}

	public int getPractical() {
		return practical;
	}

	public void setPractical(int practical) {
		this.practical = practical;
	}

	public int getTotal() {
		return Total;
	}

	public void setTotal(int total) {
		this.Total = total;
	}

	public int getReExam() {
		return ReExam;
	}

	public void setReExam(int reExam) {
		this.ReExam = reExam;
	}

	public String getSemester() {
		return Semester;
	}

	public void setSemester(String semester) {
		this.Semester = semester;
	}
}
