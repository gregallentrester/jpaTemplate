package net.greg.jpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import net.greg.jpa.services.*;

import net.greg.jpa.exceptions.*;


/**
 * @Description:
 * Accounting for Employees that work in a department
 * Some supported ops:
 *  - Get total salary to be paid to a department
 *  - Get total salary to be paid to all departments
 *  - Get average salary to be paid to a department
 *  - Get average salary to be paid to all departments
 **/
@RestController
@RequestMapping("/account/accountstats")
public class AccountStatisticsController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/all/total")
	public double getTotalSalaryForAllDepartments() { return 222_222.0; }

	@GetMapping("/{deptId}/total")
	public double getTotalSalaryForDepartment() {

		return 0.0;

	}

	@GetMapping("/all/avg")
	public double getAverageSalaryForAllDepartments() {

   return 0.0;
	}

	@GetMapping("/{deptId}/avg")
	public double getAverageSalaryForDepartment(@PathVariable long deptId) {

		double result = 0.0;

		try {
			result = employeeService.getSalary(deptId);
		}
		catch (Throwable e) {
			throw new	DepartmentNotFound(deptId);
		}

		return result;
	}
}
