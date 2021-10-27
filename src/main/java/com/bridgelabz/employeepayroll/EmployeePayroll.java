package com.bridgelabz.employeepayroll;

public class EmployeePayroll {

	private int employeeId;
	private String employeeName;
	private double salary;

	public EmployeePayroll() {
	}

	public EmployeePayroll(int employeeId, String employeeName, double salary) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.salary = salary;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeePayroll [employeeId=" + employeeId + ", employeeName=" + employeeName + ", salary=" + salary
				+ "]";
	}

}
