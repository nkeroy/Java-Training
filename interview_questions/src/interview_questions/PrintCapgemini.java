package interview_questions;

public class PrintCapgemini {

	// objective
	// print out "Capgemini" in increasing bursts of length 
	// i.e
	// "C"
	// "Ca"
	// "Cap"
	// ..
	// ..
	// "Capgemini"

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Capgemini";
		for (int i = 1; i <= s.length(); i++)
			System.out.println(s.substring(0,i));
			
	}

}
