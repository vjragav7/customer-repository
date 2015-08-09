package com.vodafone.customer.stepdefs;

import org.junit.Assert;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.HttpClientErrorException;

import com.vodafone.customer.entity.Customer;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class CustomerManagerStepdefs extends BaseStepDefs {

	public CustomerManagerStepdefs(final TestContext ctx) {
		this.context = ctx;
	}

	@Given("^Vodafone has a new customer$")
	public void Vodafone_has_a_new_customer() throws Throwable {

		this.context.setCustomer(returnTestCustomer());
	}

	@When("^I add a new customer$")
	public void I_add_a_new_customer() throws Throwable {

		HttpEntity<String> response = this.executePost(
				"http://localhost:8080/customers", this.context.getCustomer());

		assertThat(response.getHeaders().getLocation(), is(notNullValue()));

		context.setLocationUrl(response.getHeaders().getLocation());
	}

	@Then("^customer is added successfully$")
	public void customer_is_added_successfully() throws Throwable {

		Customer customer = this.executeGet(context.getLocationUrl().toURL()
				.toString());

		assertNotNull(customer);
		assertEquals(this.context.customer.getFirstName(),
				customer.getFirstName());
		assertEquals(this.context.customer.getLastName(),
				customer.getLastName());

	}

	@Given("^A customer has requested change of details$")
	public void A_customer_has_requested_change_of_details() throws Throwable {

		this.context.setCustomer(returnTestCustomer());

		HttpEntity<String> response = this.executePost(
				"http://localhost:8080/customers", this.context.getCustomer());

		assertThat(response.getHeaders().getLocation(), is(notNullValue()));

		context.setLocationUrl(response.getHeaders().getLocation());

	}

	@When("^I update the details of the customer$")
	public void I_update_the_details_of_the_customer() throws Throwable {

		this.context.getCustomer().setAddress("Auckland,New Zealand");

		this.executePut(this.context.locationUrl.toURL().toString(),
				this.context.getCustomer());

	}

	@Then("^customer details are updated successfully$")
	public void customer_details_are_updated_successfully() throws Throwable {

		Customer customer = this.executeGet(context.getLocationUrl().toURL()
				.toString());

		assertNotNull(customer);
		assertEquals(this.context.customer.getFirstName(),
				customer.getFirstName());
		assertEquals(this.context.customer.getLastName(),
				customer.getLastName());
		assertEquals(this.context.customer.getAddress(), customer.getAddress());

	}

	@Given("^A customer has requested to terminate the services$")
	public void A_customer_has_requested_to_terminate_the_services()
			throws Throwable {

		this.context.setCustomer(returnTestCustomer());

		HttpEntity<String> response = this.executePost(
				"http://localhost:8080/customers", this.context.getCustomer());

		assertThat(response.getHeaders().getLocation(), is(notNullValue()));

		context.setLocationUrl(response.getHeaders().getLocation());

	}

	@When("^I delete the customer from vodafone$")
	public void I_delete_the_customer_from_vodafone() throws Throwable {

		executeDelete(context.locationUrl.toString());
	}

	@Then("^the customer is deleted successfully$")
	public void the_customer_is_deleted_successfully() throws Throwable {
		try {
			executeGet(context.locationUrl.toString());
			Assert.fail("Customer was not successfully deleted");
		} catch (HttpClientErrorException ex) {
			assertEquals("404 Not Found", ex.getMessage());

		}

	}

}
