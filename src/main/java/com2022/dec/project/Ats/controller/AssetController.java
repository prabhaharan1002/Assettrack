
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

import com2022.dec.project.Ats.model.Asset;
import com2022.dec.project.Ats.repository.AssetRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/asset/")
public class AssetController {

	@Autowired
	private AssetRepository assetRepository;

	// Create a new assets
	@PostMapping("/create")
	public Asset createAsset(@Valid @RequestBody Asset asset) {
		return assetRepository.save(asset);
	}

	// get Assets list
	@GetMapping("/listall")
	public List<Asset> getAllAssets() {
		return assetRepository.findAll();
	}

	// get Assets by id rest API
	@GetMapping("/list/{serialNo}")
	public ResponseEntity<Asset> getAssteById(@PathVariable String serialNo) {
		Asset asset = assetRepository.findById(serialNo).orElseThrow();
		return ResponseEntity.ok(asset);
	}

	// update asset rest API
	@PutMapping("/update/{serialNo}")
	public ResponseEntity<Asset> updateAsset(@PathVariable String serialNo, @RequestBody Asset assetDetails) {
		Asset asset = assetRepository.findById(serialNo).orElseThrow();
		asset.setSerialNo(assetDetails.getSerialNo());
		asset.setBrandName(assetDetails.getBrandName());
		asset.setModelName(assetDetails.getModelName());
		asset.setModelNo(assetDetails.getModelNo());
		asset.setCpuInfo(assetDetails.getCpuInfo());
		asset.setMemInfo(assetDetails.getMemInfo());
		asset.setStorageInfo(assetDetails.getStorageInfo());
		Asset updateAsset = assetRepository.save(asset);
		return ResponseEntity.ok(updateAsset);
	}

	// delete Asset rest API
	@DeleteMapping("/delete/{serialNo}")
	public ResponseEntity<Map<String, Boolean>> deleteAsset(@PathVariable String serialNo) {
		Asset assset = assetRepository.findById(serialNo).orElseThrow();
//					.orElseThrow(() -> new ResourceNotFoundException("Asset not exist with Serial NO :" + serialNo));
		assetRepository.delete(assset);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
