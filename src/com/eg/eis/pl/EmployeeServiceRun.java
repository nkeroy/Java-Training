package com.eg.eis.pl;

import com.eg.eis.bean.*;
import com.eg.eis.service.*;
import java.util.Scanner;

public class EmployeeServiceRun {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		Employee e;
		EmployeeService es = new EmployeeService();
		e = es.setEmployeeDetails("101", "Roy", 20000.00, "Programmer");
		es.displayEmployeeDetails(e);
	}

}
