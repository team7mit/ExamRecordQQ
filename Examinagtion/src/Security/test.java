package Security;

import java.util.Scanner;

public class test {
public static void main(String[] args) {
	
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter Course");
	String s=sc.nextLine();
	
	s=s.replaceAll("Third Year", "III%").replaceAll("Second Year", "II%");
	System.out.println(s);
	
}
}
