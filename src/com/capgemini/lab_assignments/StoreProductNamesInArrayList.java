package com.capgemini.lab_assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import org.apache.log4j.Logger;

// lab 7.2

public class StoreProductNamesInArrayList {

	static Logger log = Logger.getLogger(StoreProductNamesInArrayList.class
			.getName());

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		log.info("Please enter products to be stored in the array, to quit enter \"!\".");
		ArrayList array = new ArrayList();
		while(true) {
			String object = s.next();
			if (object.equals("!")){
				break;
		}
			array.add(object);
		}
		Collections.sort(array);
		for (Object o : array)
			log.info(o);
	}

}
