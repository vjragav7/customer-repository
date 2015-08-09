# Customer Repository Rest Application

A Rest application which exposes CRUD operations for a Customer entity.

# About the application

This application has been built using Spring Data JPA and Spring Boot, where exposing Restful data repositories is just a matter of defining the entity and having a repository interface. Spring Data takes care of generating the related CRUD operations for the entity and is available for use.

Spring Boot gives us the capability to run a web application without the need for creating a war file and having a web server. This has tomcat embedded within and hence is by itself a standalone application which can be executed anywhere.



# Database

The application uses the default configuration, which uses H2, which is a in-memory database. Everytime the application is restarted, the data is cleaned up as spring data wipes out the entire database.


# Integration Testing

The application has Integration Tests, but no unit tests. There was no point in mocking out the repository methods. 

#Acceptance Testing

This application has acceptance tests backed by cucumber. The split between the Acceptance and Integration tests is that the Integration Tests will have all corner cases included, but the Acceptance tests would include specific business scenarios. The idea is to test as much as possible with smaller tests and keep the big tests for clear end to end scenarios.

## Get the source code
[Download](https://github.com/vjragav7/customer-repository/archive/master.zip) and unzip the source for this application, or clone it using Git: 

git clone https://github.com/vjragav7/customer-repository.git

cd customer-repository 

## Running the application

To run the application, execute:

mvn package && java -jar target/customer-repo-0.0.1-SNAPSHOT.jar 
or
mvn spring-boot:run

## Accessing the Rest API

The Rest API is based on HATEOAS and returns content in HAL format. To access the api, if you have curl,
in the command prompt execute

'curl http://localhost:8080/customers'

This should return the list of customers in the system. If this is the first time you are executing the application,
there will be no customers. 

To add customers, you can execute the below command:

curl -i -X POST -H "Content-Type:application/json" -d '{  "firstName" : "Scott",  "lastName" : "Hodder" ,"address" :"Auckland","telephoneNumber":"0210443424"}' http://localhost:8080/customers/

## Running the cucumber tests

After running the application and ensuring that it has launched successfully, to run the cucumber test, execute:

mvn -Dtest=RunCustomerCukes test

### Cucumber Reports
The cucumber test reports can be viewed from 'target/cucumber/index.hmtl'



