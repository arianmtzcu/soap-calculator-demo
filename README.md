# SOAP Calculator Demo
This project is a Spring Boot application that demonstrates the use of SOAP web services along with various Spring technologies, including Spring Web, Spring WebFlux, and Spring Web Services. The application provides a simple calculator API with operations such as addition, subtraction, multiplication, and division, and it exposes these operations through SOAP endpoints.

## Table of Contents

- [Project Structure](#project-structure)
- [Dependencies](#dependencies)
- [Features](#features)
- [Running the Application](#running-the-application)
- [API Documentation](#api-documentation)
- [Contributing](#contributing)
- [License](#license)

## Prerequisites
- **Java 11**: Ensure that Java 11 is installed on your system. You can download it from [AdoptOpenJDK](https://adoptopenjdk.net/) or [Oracle](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
- **Maven 3.6.3 or higher**: Maven is required to build and run the project.

## Project Structure
The project is structured as follows:

- **src/main/java**: Contains the main Java source code, including controllers, services, and configurations.
- **src/main/resources**: Contains the resources such as WSDL files for SOAP and configuration files.
- **src/test/java**: Contains the test cases for the application.

## Dependencies
The project uses the following key dependencies:

- **Spring Boot 2.7.18**: The foundation for building the application.
- **Spring Boot Starter Web**: For building RESTful web services.
- **Spring Boot Starter WebFlux**: For building reactive web applications.
- **Spring Boot Starter Web Services**: For creating and consuming SOAP web services.
- **Springdoc OpenAPI**: For generating OpenAPI documentation.
- **MapStruct**: For mapping between DTOs and entities.
- **Lombok**: To reduce boilerplate code.
- **JAXB**: For working with XML and WSDL files.
- **JUnit**: For unit testing.

For a complete list of dependencies, see the `pom.xml` file.

## Features
- **SOAP Web Services**: The application exposes a set of calculator operations as SOAP web services.
- **Spring Boot Integration**: Uses Spring Boot to configure and run the application.
- **OpenAPI Documentation**: Provides API documentation through Swagger UI.
- **WSDL Integration**: Generates classes from WSDL using JAXB.

## Running the Application
To run the application locally:

1. **Clone the repository:**
   ```bash
   git clone https://github.com/arianmtzcu/soap-calculator-demo.git
   cd soap-calculator-demo
   ```
   
2. **Build the project using Maven:**
   ```bash
   mvn clean install
   ```
   
3. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```
   
4. The application will start on: http://localhost:9001/api/v1

## Configuration
The project properties are configured in the application.yml file located in the src/main/resources directory. You can modify this file to change the application's configuration, such as server port, SOAP endpoints, and other application settings.

## API Documentation
The API documentation can be accessed via Swagger UI at: http://localhost:9001/api/v1/swagger-ui/index.html <br/>
Here, you can explore the available endpoints and try out the SOAP services directly from the browser.

## Contributing
Contributions are welcome! If you would like to contribute to this project, please fork the repository, make your changes, and submit a pull request.

## License
This project is licensed under the [MIT License](https://opensource.org/license/MIT).