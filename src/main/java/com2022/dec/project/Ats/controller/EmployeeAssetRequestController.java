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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com2022.dec.project.Ats.model.EmployeeAssetRequest;
import com2022.dec.project.Ats.repository.EmployeeAssetRequestRepo;
import jakarta.validation.Valid;

@RequestMapping("/api/EmployeeAssetRequestController/")
@RestController
public class EmployeeAssetRequestController {

	@Autowired
	private EmployeeAssetRequestRepo employeeassetRepository;

	/*
	 * Create EmployeeAssetrequest from employee
	 */
	@PostMapping("/create")
	public ResponseEntity<Map<String, Boolean>> EmployeeAssetRequest(
			@Valid @RequestBody EmployeeAssetRequest employeeAssetRequest) {

		String cpu1 = "i9";
		String cpu2 = "i7";
		String cpu3 = "i5";
		String ram1 = "8GB";
		String ram2 = "16GB";
		String storage1 = "256GB";
		String storage2 = "512GB";
		String storage3 = "1TB";
		int id = employeeAssetRequest.getReqNo();
		String temp_cpu = employeeAssetRequest.getCpu();
		String ram = employeeAssetRequest.getRam();
		String storage = employeeAssetRequest.getStorage();
		// System.out.println(temp_cpu);
		if (temp_cpu.equals(cpu1) || temp_cpu.equals(cpu2) || temp_cpu.equals(cpu3)) {
			employeeAssetRequest.setCpu(temp_cpu);
		} else {
			Map<String, Boolean> response = new HashMap<>();
			response.put("not a valid config of cpu", Boolean.FALSE);
			return ResponseEntity.ok(response);
		}

		if (ram.equals(ram1) || ram.equals(ram2)) {
			employeeAssetRequest.setCpu(ram);
		} else {
			Map<String, Boolean> response = new HashMap<>();
			response.put("not a valid config of ram", Boolean.FALSE);
			return ResponseEntity.ok(response);
		}

		if (storage.equals(storage1) || storage.equals(storage2) || storage.equals(storage3)) {
			employeeAssetRequest.setStorage(storage);
		} else {

			Map<String, Boolean> response = new HashMap<>();
			response.put("not a valid config of storage", Boolean.FALSE);
			return ResponseEntity.ok(response);
		}
		employeeassetRepository.save(employeeAssetRequest);
		Map<String, Boolean> response = new HashMap<>();
		response.put("data is added by id: " + id, Boolean.TRUE);
		return ResponseEntity.ok(response);

	}

	/*
	 * findAll EmployeeAssetrequest from employee
	 */
	@GetMapping("/findall")
	public List<EmployeeAssetRequest> getEmployeeAssetRequest() {
		return employeeassetRepository.findAll();
	}

	/*
	 * Delete EmployeeAssetrequest from employee by reqNo
	 */
	@DeleteMapping("/delete/{reqNo}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployeeAssetRequest(@PathVariable Integer reqNo) {
		EmployeeAssetRequest employeeAssetRequest = employeeassetRepository.findById(reqNo).orElseThrow();
//				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		employeeassetRepository.delete(employeeAssetRequest);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
