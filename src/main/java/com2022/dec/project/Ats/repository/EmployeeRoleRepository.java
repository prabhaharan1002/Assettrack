package com2022.dec.project.Ats.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com2022.dec.project.Ats.model.EmployeeRole;

public interface EmployeeRoleRepository extends MongoRepository<EmployeeRole,String> {

	@Query("empRole: '?0'")
	List<EmployeeRole> findEmployeeRole(String empRole);

}

