package com.bridgelabz.employeepayroll.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.employeepayroll.EmployeePayroll;
import com.bridgelabz.employeepayroll.EmployeePayrollService;

public class EmployeePayrollServiceTest {
	@Test
	public void given3EmployeesWhenWrittenToFileShouldMatchNumberOfEmployeeEntries() {
		EmployeePayroll[] arrayOfEmployees = { new EmployeePayroll(1, "Navaya Shree", 800000.0),
				new EmployeePayroll(2, "Anokhi Sha", 850000.0),
				new EmployeePayroll(3, "Lisha", 900000.0) };
		EmployeePayrollService payrollServiceObject = new EmployeePayrollService(Arrays.asList(arrayOfEmployees));
		payrollServiceObject.writeEmployeeDdate(EmployeePayrollService.IOService.FILE_IO);

		Assert.assertEquals(3, payrollServiceObject.countEnteries(EmployeePayrollService.IOService.FILE_IO));
	}
}
