/* UC-5 Ability for Employee Payroll service to print the Employee Payrolls.
 *      Ability for Employee Payroll Service to show number of Entries .
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
	        EmployeePayroll[] arrayOfEmployees = {
	                new EmployeePayroll(1, "Navaya Shree", 8800000.0),
	                new EmployeePayroll(2, "Anokhi Sha", 850000.0),
	                new EmployeePayroll(3, "Aradhiya", 900000.0) };

	        EmployeePayrollService payrollServiceObject = new EmployeePayrollService(Arrays.asList(arrayOfEmployees));
	        payrollServiceObject.writeEmployeeDdate(EmployeePayrollService.IOService.FILE_IO);
	        payrollServiceObject.printEmployeePayrollData();

	        Assert.assertEquals(3, payrollServiceObject.countEnteries(EmployeePayrollService.IOService.FILE_IO));
	    }
}
