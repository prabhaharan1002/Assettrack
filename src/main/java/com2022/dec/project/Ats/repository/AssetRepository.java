package com2022.dec.project.Ats.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com2022.dec.project.Ats.model.Asset;

public interface AssetRepository extends MongoRepository<Asset, String>{
	

}
