/*
 * UC2:-Write a program to demonstrate File Operations like
 * check file Exists, Delete File And Check File Not Exit
 * Create Empty File, List File , Directories as well as Files with Extension .
 * 
 * @author : Navaya Shree
*/
package com.bridgelabz.employeepayroll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
	public static final Scanner SC = new Scanner(System.in);
	private List<EmployeePayroll> employeeList;

	public EmployeePayrollService() {
		this.employeeList = new ArrayList<EmployeePayroll>(); // created arraylist
	}

	public EmployeePayrollService(List<EmployeePayroll> employeeList) {
		this.employeeList = employeeList;
	}

	public void readEmployeeData() {
		System.out.println("Enter employee id:");
		int employeeId = SC.nextInt();
		System.out.println("Enter employee name:");
		SC.nextLine();
		String employeeName = SC.nextLine();
		System.out.println("Enter employee salary:");
		double employeeSalary = SC.nextDouble();
		EmployeePayroll newEmployee = new EmployeePayroll(employeeId, employeeName, employeeSalary);
		employeeList.add(newEmployee);
	}

	public void writeEmployeeDate() {
		for (EmployeePayroll o : employeeList)
			System.out.println(o.toString());
	}

	public static void main(String[] args) {
		EmployeePayrollService serviceObject = new EmployeePayrollService();
		serviceObject.readEmployeeData();
		serviceObject.writeEmployeeDate();
	}
}