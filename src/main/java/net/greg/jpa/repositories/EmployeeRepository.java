package net.greg.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import net.greg.jpa.models.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {  }
