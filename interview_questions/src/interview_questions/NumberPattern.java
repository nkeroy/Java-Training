package interview_questions;

public class NumberPattern {

	// Objective: print 1 3 5 2 4 6 7 9 11 8 10 12
	// Notice that 3 odd is followed by 3 even
	// to get even after odd, just multiply by 2 and append to some string variable first
	// when the odd numbers are done, print out the string variables which should consist of 3 even numbers

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int counter = 1;
		String even = "";
		for (int i = 1; i <= 6; i++) {
			System.out.print(i * 2 - 1 + " ");
			even += i * 2 + " ";
			if (counter == 3) {
				System.out.print(even);
				// reset counter and even string to accept new string of even numbers
				counter = 1;
				even = "";
				continue;
			}
				
				counter += 1;
			
		}
	}

}
