package com.example.microservices.currencyconversionservice.bean;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="currency-exchange",url="localhost:8000")
//@FeignClient(name="currency-exchange")
//request to API Gateway zuul
@FeignClient(name="netflix-zuul-api-gateway")
@RibbonClient(name="currency-exchange")
public interface CurrencyConversionFeignExchangeProxy {

	//@GetMapping("/currency-exchange/from/{from}/to/{to}")
	@GetMapping("/currency-exchange/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retreivalExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
