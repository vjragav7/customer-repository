package com.vodafone.customer;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vodafone.customer.entity.Customer;
import com.vodafone.customer.repository.CustomerRepository;

import static org.hamcrest.Matchers.is;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CustomerDataRepositoryApplication.class)
public class CustomerDataRepositoryApplicationTests {

	@Autowired
	CustomerRepository customerRepo;

	Customer customer;

	@Before
	public void setupCustomer() {
		customer = customerRepo.save(generateTestCustomer());
		Assert.assertNotNull(customer);
	}

	@After
	public void tearDownCustomers() {
		customerRepo.deleteAll();
	}

	@Test
	public void testSearchCustomerByLastName() {

		List<Customer> customers = customerRepo.findByLastName(customer
				.getLastName());
		assertEquals(1, customers.size());
		assertEquals(customer.getLastName(), customers.get(0).getLastName());
	}

	@Test
	public void testSearchCustomerById() {
		Customer returnedCustomer = customerRepo.findOne(customer.getId());

		assertEquals(customer.getLastName(), returnedCustomer.getLastName());
		assertEquals(customer.getId(), returnedCustomer.getId());
	}

	@Test(expected = EmptyResultDataAccessException.class)
	public void testCustomerDeleteFailsWhenDeletingWithInvalidId() {
		customerRepo.delete(Long.valueOf(9999));
	}

	@Test
	public void testUpdateCustomerFirstNameIsSuccess() {

		customer.setFirstName("Scott");
		customerRepo.save(customer);

		Customer updatedCustomer = customerRepo.findOne(customer.getId());
		assertEquals(customer.getFirstName(), updatedCustomer.getFirstName());
	}

	@Test
	public void testUpdateCustomerLastNameIsSuccess() {

		customer.setLastName("Hodder");
		customerRepo.save(customer);

		Customer updatedCustomer = customerRepo.findOne(customer.getId());
		assertEquals(customer.getLastName(), updatedCustomer.getLastName());
	}

	@Test
	public void testUpdateCustomerAddressIsSuccess() {
		customer.setAddress("Auckland,New Zealand");
		customerRepo.save(customer);

		Customer updatedCustomer = customerRepo.findOne(customer.getId());
		assertEquals(customer.getAddress(), updatedCustomer.getAddress());
	}

	@Test
	public void testUpdateTelephoneNumberIsSuccess() {

		customer.setTelephoneNumber("02108432348");
		customerRepo.save(customer);

		Customer updatedCustomer = customerRepo.findOne(customer.getId());
		assertEquals(customer.getTelephoneNumber(),
				updatedCustomer.getTelephoneNumber());
	}

	@Test
	public void testSearchForMultipleCustomersWithSameLastNameIsSuccess() {

		Assert.assertThat(customerRepo.findByLastName(customer.getLastName())
				.size(), is(1));

		Customer anotherCustomerWithSameLastName = generateTestCustomer();
		anotherCustomerWithSameLastName.setLastName(customer.getLastName());
		customerRepo.save(anotherCustomerWithSameLastName);

		Assert.assertThat(customerRepo.findByLastName(customer.getLastName())
				.size(), is(2));

	}

	private Customer generateTestCustomer() {

		return new Customer(RandomStringUtils.random(10),
				RandomStringUtils.random(10), RandomStringUtils.random(15),
				RandomStringUtils.random(10));
	}
}
