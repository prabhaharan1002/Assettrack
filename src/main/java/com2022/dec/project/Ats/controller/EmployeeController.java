package com2022.dec.project.Ats.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com2022.dec.project.Ats.dto.AssetRequest;
import com2022.dec.project.Ats.model.Employee;
import com2022.dec.project.Ats.model.EmployeeRole;
import com2022.dec.project.Ats.repository.EmployeeRepository;
import com2022.dec.project.Ats.repository.EmployeeRoleRepository;
import jakarta.validation.Valid;


@RequestMapping("/api/employees/")
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeRoleRepository employeeRoleRepository;

	/*
	 *  Create a new employees
	 */
	@PostMapping("/create")
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		String firstName = employee.getFirstName();
		String lastName  = employee.getLastName();
		int empid		 = employee.getEmpId();
		System.out.println(empid);
		employee.setDisplayName(firstName + " " + lastName);
		String k = employee.getContactNo();
		int c = k.length();
		if (c == 10) {
			return employeeRepository.save(employee);
		} else {
			return null;
		}
	
	}

	/*
	 *  Create a new user along with asset (Auto Asset Assign)
	 */
	@PostMapping("/assignrequest")
	public Employee assignLaptop(@RequestBody AssetRequest request) {
		return employeeRepository.save(request.getEmployee());
	}

	// get all employees
	@GetMapping("/findall")
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();

	}

	// get employee by id rest api
	@GetMapping("/findbyid/{empId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int empId) {
		Employee employee = employeeRepository.findById(empId).orElseThrow();
		return ResponseEntity.ok(employee);
	}

	/*
	 *  update employee rest api
	 */
	@PutMapping("/update/{empId}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int empId, @RequestBody Employee employeeDetails) {
		Employee employee = employeeRepository.findById(empId).orElseThrow();
		employee.setEmpId(employeeDetails.getEmpId());
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setEmailId(employeeDetails.getEmailId());
		employee.setContactNo(employeeDetails.getContactNo());
		employee.setEmpRole(employeeDetails.getEmpRole());
		employee.setDepartmentName(employeeDetails.getDisplayName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setManager(employeeDetails.getManager());
		employee.setDisplayName(employeeDetails.getDisplayName());
		Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}

	/*
	 *  delete employee rest api
	 */
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Integer empId) {
		Employee employee = employeeRepository.findById(empId).orElseThrow();
//				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	@PostMapping("/role/post")
	public EmployeeRole createrole(@RequestBody EmployeeRole employeeRole) {

		return employeeRoleRepository.save(employeeRole);
	}

	@GetMapping("/role")
	public List<EmployeeRole> findrole() {
		return employeeRoleRepository.findAll();
	}

}
