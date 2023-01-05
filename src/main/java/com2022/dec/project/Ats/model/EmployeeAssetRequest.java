package com2022.dec.project.Ats.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Document("employeeAssetRequest")
public class EmployeeAssetRequest {
	@Id
	private int reqNo;
	
	private int empId;
	
	@NotEmpty(message="cpu is should be correct sequence")
	private String cpu;
	
	@NotEmpty(message="ram is should be correct sequence")
	private String ram;
	
	@NotEmpty(message="storage is should be correct sequence")
	private String storage;
	
	@NotEmpty(message="storage is should be correct sequence")
	private String order;
	
	
}
