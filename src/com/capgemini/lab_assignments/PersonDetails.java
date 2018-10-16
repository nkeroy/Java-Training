package com.capgemini.lab_assignments;

import org.apache.log4j.Logger;

// Lab book 2.1



public class PersonDetails {
	
	static Logger log = Logger.getLogger(PersonDetails.class.getName());

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "\n\nPerson Details:\n-----------------\n\nFirst Name: Divya\nLast Name: Bharathi\nGender: F\nAge: 20\nWeight: 85.55";
		log.info(s);
	}

}
