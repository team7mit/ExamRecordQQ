package kk;

public class comboItem {
	
	private  String Id;
	private String Name;
	
	public comboItem(String catId, String catName) {
		super();
		Id = catId;
		Name = catName;
	}
	
	

	public String getId() {
		return Id;
	}
	public void setCatId(String catId) {
		Id = catId;
	}
	
	public String getName() {
		return Name;
	}
	public void setCatName(String catName) {
		Name = catName;
	}
	
	

}
