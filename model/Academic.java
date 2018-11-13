package model;


public class Academic {
		public  String academic_id;
		public String academic_year; 
		
		
		public Academic(){
			
		}
		
		public Academic(String academic_id, String academic_year) {
			super();
			this.academic_id = academic_id;
			this.academic_year = academic_year;
		}
		public String getAcaid() {
			return academic_id;
		}
		public void setAcaid(String acaid) {
			this.academic_id = acaid;
		}
		public String getAcayear() {
			return academic_year;
		}
		public void setAcayear(String acayear) {
			this.academic_year = acayear;
		}
		public String toString(){
			return academic_year;
		}
		
}
