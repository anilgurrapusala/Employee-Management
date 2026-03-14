package com.employees.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="company")
public class Company {
	@Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long companyId;

	    private String companyName;
	    private String location;

	    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL)
	    private List<Department> departments;

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

		public List<Department> getDepartments() {
			return departments;
		}

		public void setDepartments(List<Department> departments) {
			this.departments = departments;
		}
	    
	    
	    
}
