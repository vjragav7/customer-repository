# Customer Repository Rest Application
A simple Rest application which exposes CRUD operations backed by Integration and Acceptance Tests based on cucumber

## Get the source code
[Download](https://github.com/vjragav7/customer-repository/archive/master.zip) and unzip the source for this application, or clone it using Git: 

git clone https://github.com/vjragav7/customer-repository.git

cd customer-repository 

## Run the application

To run the application, execute:

mvn package && java -jar target/customer-repo-0.0.1-SNAPSHOT.jar 
or
mvn spring-boot:run

## Run the cucumber tests

After running the application and ensuring that it has launched successfully, to run the cucumber test, execute:

mvn -Dtest=RunCustomerCukes test


