package net.greg.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import net.greg.jpa.models.Department;


public interface DepartmentRepository extends JpaRepository<Department, Long> {   }
