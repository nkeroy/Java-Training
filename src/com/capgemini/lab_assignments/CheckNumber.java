package com.capgemini.lab_assignments;
import org.apache.log4j.Logger;
import java.util.Scanner;

public class CheckNumber {

	static Logger log = Logger.getLogger(CheckNumber.class.getName());
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		log.info("Please enter an number : ");
		int input = s.nextInt();
		if (input < 0) {
			log.info("The number " + input + " you have provided is negative");
		} else {
			log.info("The number " + input + " you have provided is positive"
					+ "");
		}
	}

}
