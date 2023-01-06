package com2022.dec.project.Ats.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com2022.dec.project.Ats.model.EmployeeRole;
import com2022.dec.project.Ats.repository.EmployeeRoleRepository;
@RequestMapping("/api/employees/role/")
@RestController
public class EmployeeRoleController {

	@Autowired
	private EmployeeRoleRepository employeeRoleRepository;
	
	/*
	 * create the EmployeeRole Data to db
	 */
	@PostMapping("/post")
	public EmployeeRole createrole(@RequestBody EmployeeRole employeeRole) {

		return employeeRoleRepository.save(employeeRole);
	}
	
	/*
	 * find all the EmployeeRole Data from db
	 */
	@GetMapping("/findall")
	public List<EmployeeRole> findrole() {
		return employeeRoleRepository.findAll();
	}
}
