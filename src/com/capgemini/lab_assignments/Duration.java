package com.capgemini.lab_assignments;
import org.apache.log4j.Logger;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

// lab 3.3

public class Duration {

	static Logger log = Logger.getLogger(Duration.class.getName());
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		log.info("Please input a date - ");
		log.info("Year? ");
		int year = s.nextInt();
		log.info("Month? ");
		int month = s.nextInt();
		log.info("Day? ");
		int day = s.nextInt();
		LocalDate inputDate = LocalDate.of(year, month, day);
		LocalDate currentDate = LocalDate.now();
		Period duration = inputDate.until(currentDate);
		log.info("Duration is " + duration.getYears() + " years, " + duration.getMonths() + " months, " + duration.getDays() + " days.");
		log.info(duration.toString());
	}

}
