package Model;

public class SubjectModel extends CourseModel {
	
	public String subcode;
	public String subname;


	public SubjectModel(){
		
	}

	public SubjectModel(String subcode, String subname) {
		super();
		this.subcode = subcode;
		this.subname = subname;
	}
	public String getSubcode() {
		return subcode;
	}
	public void setSubcode(String subcode) {
		this.subcode = subcode;
	}

	public String getSubname() {
		return subname;
	}
	public void setSubname(String subname) {
		this.subname = subname;
	}
	public String toString(){
		return subcode;
	}

}
