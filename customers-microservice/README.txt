1) This folder contains the source code of the Customers MicroService implemented using SpringBoot/JPA/Hibernate/PostgreSQL.
2) Build the application using Eclipse:
   a) Use Maven Plugin and the application will build automatically
   b) Create DB as specificed in application.properties
   c) Run the application as a Java Application.
3) Build & Run the application from command line:
   a) mvn clean install
   b) cd target
   c) java -jar customers-microservice-0.0.1-SNAPSHOT.jar
4) To test the REST APIs use the Swagger UI, the API documentation is automatically published at: http://localhost:8080/swagger-ui.html