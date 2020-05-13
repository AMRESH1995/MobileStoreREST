package com.amresh.restapp.mobilestorerestapp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.amresh.restapp.mobilestorerestapp.model.Mobiles;

@Repository
public interface MobileRepository extends MongoRepository<Mobiles, Integer> {

	public List<Mobiles> findByModelName(String modelName);

	
}
