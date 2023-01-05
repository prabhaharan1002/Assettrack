package com2022.dec.project.Ats.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document("asset")
public class Asset {
	@JsonProperty("assetNo")
	private long assetNo;
	@Id
	@JsonProperty("serialNo")
	private String serialNo;
	@JsonProperty("brandName")
	@NotEmpty(message="Enter the Brand Name must")
	private String brandName;
	@JsonProperty("modelName")
	private String modelName;
	@JsonProperty("modelNo")
	private String modelNo;
	@JsonProperty("cpuInfo")
	private String cpuInfo;
	@JsonProperty("memInfo")
	private String memInfo;
	@JsonProperty("storageInfo")
	private String storageInfo;

}
