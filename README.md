# Employee Management System

## Description

RESTful web service with JWT authentication for Employee Management System. Employee management system revolutionise manual data entry work. It's help to manage employee information in more convenient way. 

You can manage information with proper security. Employee can only view their details and Admin can perform register/update/delete operations for any employee record.

## Getting Started

### Requirments

* For building and running the application you need:

Java 17

eclipse/STS

Spring Boot 3.3.2

Maven

MySQL database


## Features

- Security with JWT Authentication
- Role based access protection
- Secure
- Easy to manage


### Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the com.employee.management.employee_management class from your IDE.

Alternatively you can use the Spring Boot Maven plugin like so:

mvn spring-boot:run

Note: Before running the application change the DB credentials in your application.properties file.

## API Reference

#### Employee:

```http
GET /employee/list/view - Retrieve all employee
GET /employee/id/{id} - Retrieve an employee by ID
POST /employee/login - Login
POST /employee/register - Register employee
PUT /employee/edit/{id} - Update an existing employee
DELETE /employee/delete/id/{id} - Delete an employee
```
- [REF Employee controller](https://github.com/roypunam/Employee-management-system/blob/main/src/main/java/com/employee/management/emp_manager/controller/EmployeeController.java)

#### Role:

```http
GET /role/add - create new role
```
- [REF Role controller](https://github.com/roypunam/Employee-management-system/blob/main/src/main/java/com/employee/management/emp_manager/controller/RoleController.java)

## Documentation

  [swagger-ui](http://localhost:9091/swagger-ui/index.html)

## Version History

* 1.0.0
    * Initial Release

## Author
Punam Pal  

## Feedback
If you have any feedback, please reach out to us at 
[linkedin](https://www.linkedin.com/in/punam-roy/)
