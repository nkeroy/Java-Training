package com.eg.eis.service;

import com.eg.eis.bean.Employee;
import com.eg.eis.exception.EmployeeException;

interface EmployeeServiceInter {
	
	public Employee setEmployeeDetails(String id, String name, Double salary, String designation) throws EmployeeException;
	public String getInsuranceScheme(Employee e);
	public void displayEmployeeDetails(Employee e);
}
