package com.eg.eis.service;

import com.eg.eis.bean.Employee;

import org.apache.log4j.Logger;

public class EmployeeService implements EmployeeServiceInter {

	static Logger log = Logger.getLogger(EmployeeService.class.getName());

	@Override
	public String getInsuranceScheme(Employee e) {
		// TODO Auto-generated method stub
		return e.getInsuranceScheme();
	}

	@Override
	public void displayEmployeeDetails(Employee e) {
		// TODO Auto-generated method stub
		log.info("\nName of employee: " + e.getName() + "\nID: " + e.getId()
				+ "\nSalary: " + e.getSalary() + "\nDesignation: "
				+ e.getDesignation() + "\nInsurance Scheme: "
				+ e.getInsuranceScheme());
	}

	@Override
	public Employee setEmployeeDetails(String id, String name, Double salary,
			String designation) {
		// TODO Auto-generated method stub
		Employee e = new Employee();
		e.setId(id);
		e.setName(name);
		e.setSalary(salary);
		e.setDesignation(designation);
		if (designation.equals("System Associate") && salary > 5000
				&& salary < 20000) {
			e.setInsuranceScheme("Scheme C");
		} else if (designation.equals("Programmer") && salary >= 20000
				&& salary < 40000) {
			e.setInsuranceScheme("Scheme B");
		} else if (designation.equals("Manager") && salary >= 40000) {
			e.setInsuranceScheme("Scheme A");
		} else {
			e.setInsuranceScheme("No scheme");
		}
		return e;
	}

}
