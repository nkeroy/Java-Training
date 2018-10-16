package com.capgemini.lab_assignments;

import java.util.Scanner;
import java.util.Arrays;
import org.apache.log4j.Logger;

// lab 7.1

public class StoreProductNames {

	static Logger log = Logger.getLogger(StoreProductNames.class.getName());

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		log.info("Please enter the number of products to be stored in the array, then the products themselves.");
		int numberOfProducts = s.nextInt();
		String[] array = new String[numberOfProducts];
		for (int i = 0; i < numberOfProducts; i++) {
			array[i] = s.next();
		}
		Arrays.sort(array);
		log.info(Arrays.toString(array));

	}
}
