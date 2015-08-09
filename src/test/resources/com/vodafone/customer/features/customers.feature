@integration
Feature: Ability to add/modify/remove customers
	As a leading service provider
	I want to have a Customer API
	So that I can Add/Udpdate/Delete/Search customers

Scenario: Add a new customer

Given Vodafone has a new customer
When I add a new customer
Then customer is added successfully

Scenario: Update the details of a customer

Given A customer has requested change of details
When I update the details of the customer
Then customer details are updated successfully

Scenario: A customer has unsubscribed for vodafone

Given A customer has requested to terminate the services
When I delete the customer from vodafone
Then the customer is deleted successfully

	
