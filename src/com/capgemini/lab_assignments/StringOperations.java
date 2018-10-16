package com.capgemini.lab_assignments;
import org.apache.log4j.Logger;
import java.util.Scanner;

// lab book 3.1
// use StringBuilder since there is only one operation the user can input (no need to worry about synchronization)
// and since certain operations like replaceOffPositions require certain positions of the string to be changed, a mutable StringBuilder is preferred

public class StringOperations {

	static Logger log = Logger.getLogger(StringOperations.class.getName());

	public StringBuilder addItself(StringBuilder input) {
		return input.append(input);
	}

	public StringBuilder replaceOddPositions(StringBuilder input) {
		for (int i = 0; i < input.length(); i++) {
			if (i % 2 == 0) { // note that because index starts from 1, odd positions are actually even indexes
				input = input.replace(i, i + 1, "#");
			}
		}
		return input;
	}

	public StringBuilder removeDuplicates(StringBuilder input) {
		for (int i = 0; i < input.length() - 1; i++) { // original character reference
			for (int j = i + 1; j < input.length(); j++) { // check for duplicates, thats why j starts with i + 1
				if (input.charAt(i) == input.charAt(j)) {
					input = input.deleteCharAt(j);
				}
			}
		}
		return input;
	}

	public StringBuilder oddToUpperCase(StringBuilder input) {
		for (int i = 0; i < input.length(); i++) {
			if (i % 2 == 0) { // see line 20 above
				input = input.replace(i, i + 1, input.substring(i, i + 1)
						.toUpperCase());
			}
		}
		return input;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		log.info("Please provide choice of String : ");
		StringBuilder input = new StringBuilder(s.nextLine());
		log.info("Please provide choice of operation --> ");
		log.info("Add the String to itself -- Press 1");
		log.info("Replace odd positions with # -- Press 2");
		log.info("Remove duplicate characters in the String -- Press 3");
		log.info("Change odd characters to upper case -- Press 4");
		int operation = s.nextInt();

		StringOperations obj = new StringOperations();

		switch (operation) {
		case 1:
			log.info(obj.addItself(input));
			break;
		case 2:
			log.info(obj.replaceOddPositions(input));
			break;
		case 3:
			log.info(obj.removeDuplicates(input));
			break;
		case 4:
			log.info(obj.oddToUpperCase(input));
			break;
		default:
			log.info("Invalid operation..program terminating...");
		}

	}
}
