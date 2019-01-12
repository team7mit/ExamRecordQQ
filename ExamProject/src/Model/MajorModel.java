 package Model;

public class MajorModel extends AcademicModel{

	public String majorID;
	public String majorname;
	
	
	public String getMajorID() {
		return majorID;
	}


	public void setMajorID(String majorID) {
		this.majorID = majorID;
	}

	public String getMajorname() {
		return majorname;
	}

	public void setMajorname(String majorname) {
		this.majorname = majorname;
	}
	public String toString(){
		return majorname;
	}
	
}
