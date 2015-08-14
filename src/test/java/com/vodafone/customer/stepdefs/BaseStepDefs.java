/**
 * 
 */
package com.vodafone.customer.stepdefs;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.vodafone.customer.CustomerDataRepositoryApplication;
import com.vodafone.customer.entity.Customer;

/**
 * @author vijay
 *
 */
@ContextConfiguration(classes = CustomerDataRepositoryApplication.class, loader = SpringApplicationContextLoader.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@IntegrationTest
public class BaseStepDefs {
	
	protected TestContext context;
	protected RestTemplate restTemplate;
	
	protected Customer executeGet(String url) throws IOException {
		
		final Map<String, String> headers = new HashMap<>();
		headers.put("Accept", "application/json");
		
		ParameterizedTypeReference<Resource<Customer>> responseType = new ParameterizedTypeReference<Resource<Customer>>() {
		};
		ResponseEntity<Resource<Customer>> responseEntity =  getRestTemplate()
				.exchange(url, HttpMethod.GET, null, responseType);
		if (responseEntity.hasBody()) {
			return responseEntity.getBody().getContent();
		
		}

		return null;


	}

	protected HttpEntity<String> executePost(String url, Customer customer) {

		
		return  getRestTemplate().postForEntity(url, customer, String.class);
	}


	protected void executePut(String url, Customer customer) {

		
		 getRestTemplate().put(url,customer);
	}
	
	protected void executeDelete(String url){
		
		 getRestTemplate().delete(url);
		
	}
	
	protected Customer returnTestCustomer(){
		
		return new Customer(RandomStringUtils.random(10),RandomStringUtils.random(10),RandomStringUtils.random(15),RandomStringUtils.random(10));
	}
	
	private RestTemplate getRestTemplate() {
		if (restTemplate == null) {
			restTemplate = new TestRestTemplate();
		}
		return restTemplate;
	}
}
