# Customer Repository Rest Application

A Rest application which exposes CRUD operations for a Customer entity.

# About the application

Visit [Customer Repository Wiki](https://github.com/vjragav7/customer-repository/wiki) for details about the application stack.

## Get the source code
[Download](https://github.com/vjragav7/customer-repository/archive/master.zip) and unzip the source for this application, or clone it using Git:   

`git clone https://github.com/vjragav7/customer-repository.git`


`cd customer-repository `

## Running the application

To run the application, execute:

`mvn package && java -jar target/customer-repo-0.0.1-SNAPSHOT.jar` 
or
`mvn spring-boot:run`

## Running the cucumber tests

After running the application and ensuring that it has launched successfully, to run the cucumber test, execute:

`mvn -Dtest=RunCustomerCukes test`

### Cucumber Reports
The cucumber test reports can be viewed from `target/cucumber/index.hmtl`



