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
@Document("employee")
public class Employee { 
	
	/* 
	 * employee id primary key for  employee
	 * */
	@Id
	private int empId;
	
	/*
	 * firstName field for employee
	 * */
	@NotEmpty(message="first name is should be correct sequence")
	private String firstName;
	
	/*
	 * lastName field for employee
	 * */
	@NotEmpty(message="lastName is should be correct sequence")
	private String lastName;
	
	/*
	 * email field for employee
	 * */
	private String emailId;

	/*
	 * contactNo field for employee
	 * */
	@NotEmpty(message="contactNo is should be correct sequence")
	private String contactNo;

	/*
	 * empRole field for employee
	 * */
	private String empRole;

	/*
	 * displayName field for employee
	 * */
	private String displayName;

	/*
	 * departmentName field for employee
	 * */
	@NotEmpty(message="departmentName is should be correct sequence")
	private String departmentName;

	/*
	 * manager field for employee to accept or not
	 * */
	@NotEmpty(message="manager is should be correct sequence")
	private String manager;
	
	
}
