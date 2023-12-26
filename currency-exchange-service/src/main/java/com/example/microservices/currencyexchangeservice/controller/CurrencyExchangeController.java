package com.example.microservices.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.currencyexchangeservice.bean.CurrencyExchange;
import com.example.microservices.currencyexchangeservice.bean.CurrencyExchangeInterface;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment environment;
	@Autowired
	private CurrencyExchangeInterface currencyRepo;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retreivalExchangeValue(@PathVariable String from, @PathVariable String to) {
		CurrencyExchange curr = currencyRepo.findByFromAndTo(from, to);
		logger.info("{}",curr);
		curr.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return curr;
		
	}
	
}
