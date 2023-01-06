package com2022.dec.project.Ats.dto;

import com2022.dec.project.Ats.model.Employee;
import com2022.dec.project.Ats.model.EmployeeRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class AssetRequest {
	private Employee employee;

	private EmployeeRole employeeRole;

	public EmployeeRole FindAll(EmployeeRole empId) {
		return empId;

	}

}
