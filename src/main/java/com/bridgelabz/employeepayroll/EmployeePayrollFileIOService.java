/* UC-6: Ability for Employee Payroll Service to read the Employee payroll
 *  file so that some analysis can be performed .
 * 
 * @author : Navaya Shree
*/
package com.bridgelabz.employeepayroll;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollFileIOService {
	public static final String PAYROLL_FILE_NAME = "employee-payroll-file.txt";

	public void writeData(List<EmployeePayroll> employeeList) {

		StringBuffer employeeBufferString = new StringBuffer();
		employeeList.forEach(employee -> {
			String employeeDataString = employee.toString().concat("\n");
			employeeBufferString.append(employeeDataString);
		});

		try {
			Files.write(Paths.get(PAYROLL_FILE_NAME), employeeBufferString.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public long countEntries() {
		long countOfEntries = 0;
		try {
			countOfEntries = Files.lines(Paths.get(PAYROLL_FILE_NAME)).count();
		} catch (IOException e) {
		}
		return countOfEntries;
	}

	public void printEmployeePayrolls() {
		try {
			Files.lines(Paths.get(PAYROLL_FILE_NAME)).forEach(System.out::println);
		} catch (IOException e) {
		}
	}

	public List<EmployeePayroll> readData() {
		List<EmployeePayroll> employeeReadList = new ArrayList<EmployeePayroll>();
		String lin = null;
		try {
			Files.lines(Paths.get(PAYROLL_FILE_NAME)).map(line -> line.trim()).forEach(line -> {
				String[] data = line.split("[a-zA-Z]+ : ");
				int id = Character.getNumericValue(data[1].charAt(0));
				String name = data[2];
				double salary = Double.parseDouble(data[3]);
				EmployeePayroll employeeobject = new EmployeePayroll(id, name, salary);
				employeeReadList.add(employeeobject);
			});
		} catch (IOException e) {
		}
		return employeeReadList;
	}

}