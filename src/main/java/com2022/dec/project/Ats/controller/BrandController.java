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

import com2022.dec.project.Ats.model.Brand;
import com2022.dec.project.Ats.repository.BrandRepository;

@RestController
@RequestMapping("/api/brand/")
public class BrandController {
	@Autowired
	private BrandRepository brandRepository;

	/* create end point API using PostMapping */
	@PostMapping("/createbrand")
	public Brand createBrand(@RequestBody Brand brand) {
		return brandRepository.save(brand);
	}

	// get Assets list
	@GetMapping("/listall")
	public List<Brand> getAllBrand() {
		return brandRepository.findAll();
	}

	// get Assets by id rest API
	@GetMapping("/list/{serialNo}")
	public ResponseEntity<Brand> getAssteById(@PathVariable String serialNo) {
		Brand brand = brandRepository.findById(serialNo).orElseThrow();
		return ResponseEntity.ok(brand);
	}

	// update asset rest API
	@PutMapping("/update/{serialNo}")
	public ResponseEntity<Brand> updateBrand(@PathVariable String serialNo, @RequestBody Brand brandDetails) {
		Brand brand = brandRepository.findById(serialNo).orElseThrow();
		brand.setSerialNo(brandDetails.getSerialNo());
		brand.setBrandName(brandDetails.getBrandName());
		Brand updateBrand = brandRepository.save(brand);
		return ResponseEntity.ok(updateBrand);
	}

	// delete Asset rest API
	@DeleteMapping("/delete/{serialNo}")
	public ResponseEntity<Map<String, Boolean>> deleteBrand(@PathVariable String serialNo) {
		Brand brand = brandRepository.findById(serialNo).orElseThrow();
//						.orElseThrow(() -> new ResourceNotFoundException("Brand not exist with Serial NO :" + serialNo));
		brandRepository.delete(brand);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
