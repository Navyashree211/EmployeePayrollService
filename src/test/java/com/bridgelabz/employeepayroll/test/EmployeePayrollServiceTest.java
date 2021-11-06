/* UC-6 : Ability for Employee Payroll Service to read the Employee payroll
 *  file so that some analysis can be performed .
 * 
 * @author : Navaya Shree
*/
package com.bridgelabz.employeepayroll.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.employeepayroll.EmployeePayroll;
import com.bridgelabz.employeepayroll.EmployeePayrollService;

public class EmployeePayrollServiceTest {
	@Test
	public void given3EmployeesWhenWrittenToFileShouldMatchNumberOfEmployeeEntries() {
		EmployeePayroll[] arrayOfEmployees = { new EmployeePayroll(1, "Navya Shree", 990000.0),
				new EmployeePayroll(2, "Anokhi Sha", 850000.0), new EmployeePayroll(3, "Anamika Raj", 900000.0) };

		EmployeePayrollService payrollServiceObject = new EmployeePayrollService(Arrays.asList(arrayOfEmployees));
		payrollServiceObject.writeEmployeeDdate(EmployeePayrollService.IOService.FILE_IO);
		payrollServiceObject.printEmployeePayrollData();

		Assert.assertEquals(3, payrollServiceObject.countEnteries(EmployeePayrollService.IOService.FILE_IO));
	}

	@Test
	public void given3EmployeesWhenReadFromFileShouldMatchNumberOfEmployeeEntries() {

		EmployeePayrollService payrollServiceObject = new EmployeePayrollService();
		payrollServiceObject.readEmployeeData(EmployeePayrollService.IOService.FILE_IO);
		int countOfEntriesRead = payrollServiceObject.sizeOfEmployeeList();
		Assert.assertEquals(3, countOfEntriesRead);
	}

}