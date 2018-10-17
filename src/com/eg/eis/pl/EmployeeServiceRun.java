package com.eg.eis.pl;

import com.eg.eis.bean.*;
import com.eg.eis.service.*;
import java.util.Scanner;
import org.apache.log4j.Logger;

public class EmployeeServiceRun {

	static Logger log = Logger.getLogger(EmployeeServiceRun.class.getName());

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String id;
		String name = "";
		Double salary;
		String designation;
		log.info("Please key in id : ");
		id = s.next();
		log.info("\nPlease key in name.\nFor every space between names, just press Enter.\n"
				+ "When you are done, type \"QUIT\" to continue.\n");
		while (true) {
			String input = s.next();
			if (input.equals("QUIT"))
				break;
			name += input + " ";
		}
		log.info("Please key in salary : ");

		salary = s.nextDouble();
		log.info("Please choose designation \n1.System Associate\n2.Programmer\n3.Manager\n4.Clerk ");
		int choice = s.nextInt();
		designation = (choice == 1) ? "System Associate"
				: (choice == 2) ? "Programmer" : (choice == 3) ? "Manager"
						: "Clerk";

		s.close();
		EmployeeService es = new EmployeeService();
		Employee e = es.setEmployeeDetails(id, name, salary, designation);
		es.displayEmployeeDetails(e);
	}

}
