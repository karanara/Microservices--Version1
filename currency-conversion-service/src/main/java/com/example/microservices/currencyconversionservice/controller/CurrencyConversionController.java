package com.example.microservices.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.microservices.currencyconversionservice.bean.CurrencyConversion;
import com.example.microservices.currencyconversionservice.bean.CurrencyConversionFeignExchangeProxy;

@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyConversionFeignExchangeProxy currencyFeignProxy;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion getCalculateConvertedValue(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity ) {
		
		HashMap<String,String> uriVariables = new HashMap<>();
		uriVariables.put("from",from);
		uriVariables.put("to",to);
		
		ResponseEntity<CurrencyConversion> responseEntity = 
				
				new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/USD/to/INR",CurrencyConversion.class,uriVariables);
		CurrencyConversion response=responseEntity.getBody();
		
		return new CurrencyConversion(response.getId(), 
				from, to, quantity, 
				response.getConversionMultiple(), 
				quantity.multiply(response.getConversionMultiple()),response.getPort());
	}
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion getCalculateConvertedValueFeign(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity ) {
		
	
		CurrencyConversion response=currencyFeignProxy.retreivalExchangeValue(from,to);
		logger.info("{}",response);
		
		return new CurrencyConversion(response.getId(), 
				from, to, quantity, 
				response.getConversionMultiple(), 
				quantity.multiply(response.getConversionMultiple()),response.getPort());
	}
}
