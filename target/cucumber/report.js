$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("com/vodafone/customer/features/customers.feature");
formatter.feature({
  "id": "ability-to-add/modify/search-customers",
  "tags": [
    {
      "name": "@integration",
      "line": 1
    }
  ],
  "description": "As a leading service provider\nI want to have a Customer API\nSo that I can Add/Udpdate/Delete/Search customers",
  "name": "Ability to add/modify/search customers",
  "keyword": "Feature",
  "line": 2
});
formatter.scenario({
  "id": "ability-to-add/modify/search-customers;add-a-new-customer",
  "description": "",
  "name": "Add a new customer",
  "keyword": "Scenario",
  "line": 7,
  "type": "scenario"
});
formatter.step({
  "name": "Vodafone has a new customer",
  "keyword": "Given ",
  "line": 9
});
formatter.step({
  "name": "I add a new customer",
  "keyword": "When ",
  "line": 10
});
formatter.step({
  "name": "customer is added successfully",
  "keyword": "Then ",
  "line": 11
});
formatter.match({
  "location": "CustomerManagerStepdefs.Vodafone_has_a_new_customer()"
});
formatter.result({
  "duration": 240455000,
  "status": "passed"
});
formatter.match({
  "location": "CustomerManagerStepdefs.I_add_a_new_customer()"
});
formatter.result({
  "duration": 2228020000,
  "status": "passed"
});
formatter.match({
  "location": "CustomerManagerStepdefs.customer_is_added_successfully()"
});
formatter.result({
  "duration": 250910000,
  "status": "passed"
});
formatter.scenario({
  "id": "ability-to-add/modify/search-customers;update-the-details-of-a-customer",
  "description": "",
  "name": "Update the details of a customer",
  "keyword": "Scenario",
  "line": 13,
  "type": "scenario"
});
formatter.step({
  "name": "A customer has requested change of details",
  "keyword": "Given ",
  "line": 15
});
formatter.step({
  "name": "I update the details of the customer",
  "keyword": "When ",
  "line": 16
});
formatter.step({
  "name": "customer details are updated successfully",
  "keyword": "Then ",
  "line": 17
});
formatter.match({
  "location": "CustomerManagerStepdefs.A_customer_has_requested_change_of_details()"
});
formatter.result({
  "duration": 54105000,
  "status": "passed"
});
formatter.match({
  "location": "CustomerManagerStepdefs.I_update_the_details_of_the_customer()"
});
formatter.result({
  "duration": 102010000,
  "status": "passed"
});
formatter.match({
  "location": "CustomerManagerStepdefs.customer_details_are_updated_successfully()"
});
formatter.result({
  "duration": 18302000,
  "status": "passed"
});
formatter.scenario({
  "id": "ability-to-add/modify/search-customers;a-customer-has-unsubscribed-for-vodafone",
  "description": "",
  "name": "A customer has unsubscribed for vodafone",
  "keyword": "Scenario",
  "line": 19,
  "type": "scenario"
});
formatter.step({
  "name": "A customer has requested to terminate the services",
  "keyword": "Given ",
  "line": 21
});
formatter.step({
  "name": "I delete the customer from vodafone",
  "keyword": "When ",
  "line": 22
});
formatter.step({
  "name": "the customer is deleted successfully",
  "keyword": "Then ",
  "line": 23
});
formatter.match({
  "location": "CustomerManagerStepdefs.A_customer_has_requested_to_terminate_the_services()"
});
formatter.result({
  "duration": 29496000,
  "status": "passed"
});
formatter.match({
  "location": "CustomerManagerStepdefs.I_delete_the_customer_from_vodafone()"
});
formatter.result({
  "duration": 29706000,
  "status": "passed"
});
formatter.match({
  "location": "CustomerManagerStepdefs.the_customer_is_deleted_successfully()"
});
formatter.result({
  "duration": 22602000,
  "status": "passed"
});
});