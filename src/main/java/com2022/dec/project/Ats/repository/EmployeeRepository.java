package com2022.dec.project.Ats.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com2022.dec.project.Ats.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, Integer>{

}
