package com.amresh.restapp.mobilestorerestapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amresh.restapp.mobilestorerestapp.model.Mobiles;
import com.amresh.restapp.mobilestorerestapp.repository.MobileRepository;

@Service
public class MobileService {
	@Autowired
	MobileRepository repository;

	public void save(Mobiles mobile) {
		repository.save(mobile);

	}

	public List<Mobiles> findAll() {
		return repository.findAll();
	}

	public List<Mobiles> findByModelName(String modelName) {
		return repository.findByModelName(modelName);
	}

}
