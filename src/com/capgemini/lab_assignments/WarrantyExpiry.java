package com.capgemini.lab_assignments;
//lab 3.5

import java.util.Scanner;
import org.apache.log4j.Logger;
import java.time.LocalDate;

public class WarrantyExpiry {

	static Logger log = Logger.getLogger(WarrantyExpiry.class.getName());
	
	public LocalDate warrantyExpiry(LocalDate purchaseDate, int years, int months) {
		LocalDate expiryDate = purchaseDate;
		expiryDate = expiryDate.plusYears(years);
		expiryDate = expiryDate.plusMonths(months);
		return expiryDate;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		log.info("Please key in date of purchase in this format: YYYY-MM-DD");
		LocalDate purchaseDate = LocalDate.parse(s.next());
		log.info("Next, please key in warranty expiry, first the number of years, then the number of months");
		log.info("Years? : ");
		int years = s.nextInt();
		log.info("Months? : ");
		int months = s.nextInt();
		log.info(new WarrantyExpiry().warrantyExpiry(purchaseDate, years, months));
		
	}

}
