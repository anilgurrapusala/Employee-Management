package com.employees.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employees.dtos.CompanyDto;
import com.employees.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	  @PostMapping("/add")
	    public ResponseEntity<CompanyDto> saveCompany(@RequestBody CompanyDto companyDTO) {

		  CompanyDto savedCompany = companyService.saveCompany(companyDTO);

	        return ResponseEntity.ok(savedCompany);
	
}
}