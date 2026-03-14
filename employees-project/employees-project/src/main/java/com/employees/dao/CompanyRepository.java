package com.employees.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employees.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>{

}
