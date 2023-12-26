package com.example.microservices.currencyexchangeservice.bean;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeInterface extends JpaRepository<CurrencyExchange, Long> {

	public CurrencyExchange findByFromAndTo(String From,String To);
}
