package com.employees.dtos;

import java.util.List;

public class CompanyDto {

	  private Long companyId;
	    private String companyName;
	    private String location;

	    private List<DepartmentDTO> departments;

		public Long getCompanyId() {
			return companyId;
		}

		public void setCompanyId(Long companyId) {
			this.companyId = companyId;
		}

		public String getCompanyName() {
			return companyName;
		}

		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public List<DepartmentDTO> getDepartments() {
			return departments;
		}

		public void setDepartments(List<DepartmentDTO> departments) {
			this.departments = departments;
		}
	    
	    
	
}
