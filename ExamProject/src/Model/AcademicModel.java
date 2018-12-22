package Model;

public class AcademicModel {
	
	public String academicID;
	public String academic;
	
	
	public AcademicModel(){
		
	}
	public AcademicModel(String acaid, String academic) {
		
		this.academicID=acaid;
		this.academic=academic;
		
	}
	public String getAcademicID() {
		return academicID;
	}
	public void setAcademicID(String academicID) {
		this.academicID = academicID;
	}
	public String getAcademic() {
		return academic;
	}
	public void setAcademic(String academic) {
		this.academic = academic;
	}
	public String toString(){
		return academic;
	}
	

}
