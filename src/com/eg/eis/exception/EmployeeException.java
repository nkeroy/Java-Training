package com.eg.eis.exception;

public class EmployeeException extends Exception {
	public EmployeeException() {
		super("Salary cannot be below 3000".toUpperCase());
	}
}


