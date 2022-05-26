# Test task for FKR
## For API documentation, go to org.bookshop.controller
### Project stack
* Java 8
* Spring 4
* Flyway
* Postgresql
* Maven

To run flyway migration: clean flyway:migrate -Dflyway.configFiles=flywayConfig.properties 

To run application:
+ Set environmental variables: db.username=postgres;db.password=postgres
+ install tomcat7:run

