/* UC-5 Ability for Employee Payroll service to print the Employee Payrolls.
 *      Ability for Employee Payroll Service to show number of Entries .
 * 
 * @author : Navaya Shree
*/
package com.bridgelabz.employeepayroll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
	public enum IOService {
		CONSOLE_IO, FILE_IO, DB_IO, REST_IO
	}

	public static final Scanner SC = new Scanner(System.in);
	private List<EmployeePayroll> employeeList;

	public EmployeePayrollService() {
		this.employeeList = new ArrayList<EmployeePayroll>();
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

	public void writeEmployeeDdate(IOService ioType) {
		if (ioType.equals(IOService.CONSOLE_IO)) {
			for (EmployeePayroll o : employeeList)
				System.out.println(o.toString());
		} else if (ioType.equals(IOService.FILE_IO)) {
			new EmployeePayrollFileIOService().writeData(employeeList);
		}
	}

	public long countEnteries(IOService ioType) {
		if (ioType.equals(IOService.FILE_IO))
			return new EmployeePayrollFileIOService().countEntries();
		return 0;
	}

	public void printEmployeePayrollData() {
		new EmployeePayrollFileIOService().printEmployeePayrolls();
	}

}