package com.amresh.restapp.mobilestorerestapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amresh.restapp.mobilestorerestapp.model.Mobiles;
import com.amresh.restapp.mobilestorerestapp.service.MobileService;

@RestController
@RequestMapping("/mobiles")
public class MobileController {

	@Autowired
	private MobileService service;

	@PostMapping("/addMobile")
	public String addMobile(@RequestBody Mobiles mobile) {
		service.save(mobile);
		return "Mobile Added Successfully";
	}

	@GetMapping("/getAll")
	public List<Mobiles> getAllMobiles() {
		return service.findAll();
	}

	@GetMapping("/{modelName}")
	public List<Mobiles> getAllByModelName(@PathVariable String modelName) {
		return service.findByModelName(modelName);
	}

}
