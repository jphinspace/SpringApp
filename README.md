# Web Application

![Java](https://img.shields.io/badge/Java-17-blue.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.4-brightgreen.svg)
![Maven](https://img.shields.io/badge/Maven-3.9.0+-orange.svg)
![License: CC0](https://img.shields.io/badge/License-CC0%201.0-lightgrey.svg)
![Build](https://img.shields.io/badge/build-passing-brightgreen.svg)

A modern Spring Boot web application for data visualization, rate limiting, and security best practices. This project is public domain and ready for open source collaboration.

## Features
- Spring Boot 3.1.4
- Java 17
- Thymeleaf templating
- Chart.js data visualization
- H2 in-memory database
- JPA/Hibernate
- Modern Spring Security (HTTPS, headers, CSP)
- Rate limiting with Bucket4j
- JUnit 5 test slices

## Getting Started

### Prerequisites
- Java 17+
- Maven 3.9+

### Build the Project

```sh
mvn clean install
```

### Run the Application
```sh
mvn spring-boot:run
```

The app will start on [https://localhost:8443](https://localhost:8443) with HTTPS enabled.

### Run Tests
```sh
mvn test
```

## Directory Structure
```
src/
  main/
    java/com/example/webapp/...
    resources/
      templates/dashboard.html
      application.properties
      ...
  test/
    java/com/example/webapp/...
    resources/application.properties
```

## License
This project is released under the [CC0 1.0 Universal Public Domain Dedication](LICENSE).

## Contributing
Feel free to fork, submit issues, or open pull requests!
# webapp
