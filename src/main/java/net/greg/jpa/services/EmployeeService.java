package net.greg.jpa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.*;

import net.greg.jpa.models.Employee;
import net.greg.jpa.repositories.EmployeeRepository;


@Component
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	/**
	 * Compute/return salary for given employee
	 * @return Calculate salary of extant employee (@param empId), else return 0.0
	 */
	public double getSalary(long empId) {

		Optional<Employee> optEmployee =
			employeeRepository.findById(empId);

		// Alternatively: throw net.greg.jpa.exceptions.EmployeeNotFound
		if ( ! optEmployee.isPresent()) { return 0.0; }

		Employee emp = optEmployee.get();

		return emp.
				getSalary().
				getSalaryComponents().
				parallelStream().
				reduce(
					Double.valueOf(0.0),
					(total, sc) -> total + (sc.getFactor() *  emp.getSalary().getBaseSalary()),
					(c1, c2) -> c1 + c2
				);
  }
}
