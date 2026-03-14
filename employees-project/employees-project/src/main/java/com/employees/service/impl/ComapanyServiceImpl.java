package com.employees.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employees.dao.CompanyRepository;
import com.employees.dtos.CompanyDto;
import com.employees.dtos.DepartmentDTO;
import com.employees.dtos.EmployeeDTO;
import com.employees.model.Company;
import com.employees.model.Department;
import com.employees.model.Employee;
import com.employees.service.CompanyService;
@Service
public class ComapanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public CompanyDto saveCompany(CompanyDto companyDTO) {
		Company company = new Company();
		
		company.setCompanyName(companyDTO.getCompanyName());
		company.setLocation(companyDTO.getLocation());
		List<Department> depList = new ArrayList<>();

		if (companyDTO.getDepartments() != null) {

			for (DepartmentDTO deptDTO : companyDTO.getDepartments()) {
				Department dept = new Department();
				
				dept.setDeptName(deptDTO.getDeptName());
				//dept.setCompany(company);

				List<Employee> empList = new ArrayList<>();
				if (deptDTO.getEmployees() != null) {
					for (EmployeeDTO empDTO : deptDTO.getEmployees()) {
						Employee emp = new Employee();
						
						emp.setEmpName(empDTO.getEmpName());
						emp.setSalary(empDTO.getSalary());

						//emp.setDepartment(dept);

						empList.add(emp);

					}
				}
				dept.setEmployees(empList);

				depList.add(dept);
			}
		}
		company.setDepartments(depList);

		Company savedCompany = companyRepository.save(company);
		 CompanyDto responseDTO = new CompanyDto();
		 responseDTO.setCompanyId(savedCompany.getCompanyId()); // important
		    responseDTO.setCompanyName(savedCompany.getCompanyName());
		    responseDTO.setLocation(savedCompany.getLocation());
		    List<DepartmentDTO> deptLisss=new ArrayList<>();
		    for(Department sss:savedCompany.getDepartments()) {
		    	
		    	DepartmentDTO dto=new DepartmentDTO();
		    	dto.setDeptId(sss.getDeptId());
		    	dto.setDeptName(sss.getDeptName());
		    	List<EmployeeDTO> empDtoList=new ArrayList<>();
		    	for(Employee ee:sss.getEmployees()) {
		    		EmployeeDTO edt=new EmployeeDTO();
		    		edt.setEmpId(ee.getEmpId());
		    		edt.setEmpName(ee.getEmpName());
		    		edt.setSalary(ee.getSalary());
		    		empDtoList.add(edt);
		    	}
		    	dto.setEmployees(empDtoList);
		    	deptLisss.add(dto);
		    
		    }
		    responseDTO.setDepartments(deptLisss);
		return responseDTO;
	}

}
