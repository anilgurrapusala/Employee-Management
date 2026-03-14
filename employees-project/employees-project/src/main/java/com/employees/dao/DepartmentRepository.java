package com.employees.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employees.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
