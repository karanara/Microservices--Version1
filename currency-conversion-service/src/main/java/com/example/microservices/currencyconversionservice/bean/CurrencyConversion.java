package com.example.microservices.currencyconversionservice.bean;

import java.math.BigDecimal;

public class CurrencyConversion {

	private long id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	private BigDecimal quantity;
	private BigDecimal totalAmount;
	private int port;
	public CurrencyConversion() {
	}
	public CurrencyConversion(long id, String from, String to, BigDecimal conversionMultiple,BigDecimal quantity,
			BigDecimal totalAmount,int port)
	{
		this.id = id;
		this.to = to;
		this.from = from;
		this.quantity = quantity;
		this.conversionMultiple = conversionMultiple;
		this.totalAmount = totalAmount;
		this.port = port;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	
	
}
