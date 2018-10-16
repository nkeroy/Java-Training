package com.eg.eis.exception;

import java.util.Scanner;

import org.apache.log4j.Logger;

class SalaryException extends Exception {
	public SalaryException() {
		super("Salary cannot be below 3000!");
	}
}


public class EmployeeException {

	static Logger log = Logger.getLogger(EmployeeException.class.getName());
	
	public void EmployeeSalary(int salary) throws SalaryException {
		if (salary < 3000) {
			throw new SalaryException();
		} else {
			log.info("You are not a beggar");
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		log.info("Please enter a salary amount: ");
		try {
			int salary = s.nextInt();
			new EmployeeException().EmployeeSalary(salary);
		} catch (Exception e) {
			log.info(e);
			log.info(e.getMessage());
		}
		
	}

}

