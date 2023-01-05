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
	 * Creating new requestAsset from employee
	 */
	@PostMapping("/create")
	public  EmployeeAssetRequest EmployeeAssetRequest (@Valid @RequestBody EmployeeAssetRequest employeeAssetRequest) {
     
		String cpu1="i9";
		String cpu2="i7";
		String cpu3="i5";
		String ram1="8GB";
		String ram2="16GB";
		String storage1="256GB";
		String storage2="512GB";
		String storage3="1TB";
		
		String cpu=employeeAssetRequest.getCpu();
		String ram=employeeAssetRequest.getRam();
		String storage=employeeAssetRequest.getStorage();
		
		if(cpu==cpu1|| cpu==cpu2 || cpu==cpu3) {
			employeeAssetRequest.setCpu(cpu);
			System.out.println(cpu);
		}
		
		if(ram==ram1 || ram==ram2) {
			employeeAssetRequest.setCpu(cpu);
			System.out.print(ram);
		}

		if(storage==storage1 || storage==storage2 || storage==storage3) {
			employeeAssetRequest.setStorage(storage);
		}
		
	
		
	return	employeeassetRepository.save(employeeAssetRequest);
	}
	/*
	 * findAll requestAsset from employee
	 */
	@GetMapping("/findall")
	public List<EmployeeAssetRequest> getEmployeeAssetRequest() {
		return employeeassetRepository.findAll();

	}
	
	/*
	 * Delete requestAsset from employee by reqNo
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
