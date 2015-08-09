package com.vodafone.customer;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;
import cucumber.api.junit.Cucumber.Options;

@RunWith(Cucumber.class)
@Options(format = { "html:target/cucumber", "json:target/cucumber.json" })
public class RunCustomerCukes {

}
