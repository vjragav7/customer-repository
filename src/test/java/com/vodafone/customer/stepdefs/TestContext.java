package com.vodafone.customer.stepdefs;

import java.net.URI;

import com.vodafone.customer.entity.Customer;

public class TestContext {
	
	Customer customer;
	URI locationUrl;
	
	public TestContext(){
		
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public URI getLocationUrl() {
		return locationUrl;
	}
	public void setLocationUrl(URI uri) {
		this.locationUrl = uri;
	}
	
	

}
