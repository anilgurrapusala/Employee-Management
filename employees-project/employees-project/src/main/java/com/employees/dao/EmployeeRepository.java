package com.employees.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employees.model.Company;
import com.employees.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
