package com.example.microservices.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.limitsservice.bean.ConfigurationLimit;
import com.example.microservices.limitsservice.bean.LimitConfiguration;

@RestController
public class LimitConfigurationController {

	@Autowired
	private ConfigurationLimit configurationLimit;
	
	@GetMapping("/limits")
	public LimitConfiguration retrievalLimits() {
		return new LimitConfiguration(configurationLimit.getMaximum(),configurationLimit.getMinimum());
	}
}
