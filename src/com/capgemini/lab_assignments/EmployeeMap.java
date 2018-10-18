package com.capgemini.collections;

import java.util.HashMap;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class EmployeeMap {

	static Logger log = Logger.getLogger(EmployeeMap.class.getName());
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		HashMap<String, String> map = new HashMap<String,String>();
		int number_of_employees = 1;
		while(number_of_employees <= 3) {
			log.info("Please enter employee id and name, i.e CAPGEMINI10 RAYMOND ");
			map.put(s.next(), s.next());
			number_of_employees++;
		}
		for (String key : map.keySet())
			log.info("Employee id : " + key + ", Name: " + map.get(key));
	}

}
