package kk;

public class user {
	
	private int id;
	private String firstName;
	private String lastName;
	private int age;
	
	public user(int id,String fn,String ln,int a){
		this.id=id;
		this.firstName=fn;
		this.lastName=ln;
		this.age=a;
	}

	public int getId()
	{
		return id;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public int getAge()
	{
		return age;
	}
}
