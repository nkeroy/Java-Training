package com.eg.eis.service;

import com.eg.eis.bean.Employee;

interface EmployeeServiceInter {
	
	public Employee setEmployeeDetails(String id, String name, Double salary, String designation);
	public String getInsuranceScheme(Employee e);
	public void displayEmployeeDetails(Employee e);
}
