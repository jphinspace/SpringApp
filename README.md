# Web Application

[![GitHub License](https://img.shields.io/github/license/jphinspace/webapp?style=plastic&logo=creativecommons&logoColor=white)](LICENSE)
[![Java](https://img.shields.io/badge/Java-21-blue?style=plastic&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.4-brightgreen?style=plastic&logo=spring&logoColor=white)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-3.9.0-orange?style=plastic&logo=apache-maven&logoColor=white)](https://maven.apache.org/)

A modern Spring Boot web application for data visualization, with rate limiting and security best practices.

## Quick Overview
- Spring Boot 3.1.4
- Java 21 (release build)
- Thymeleaf templating
- Chart.js data visualization
- H2 in-memory database
- JPA / Hibernate
- Rate limiting with Bucket4j
- Spring Security configuration

## Getting Started

### Prerequisites
- Java 21+
- Maven 3.9+

### Generate self-signed certificate (keystore.p12)

To generate a self-signed certificate and put it in the correct location, run the following command from the repository root:

```sh
keytool -genkeypair \
	-alias tomcat \
	-keyalg RSA \
	-keysize 2048 \
	-storetype PKCS12 \
	-keystore src/main/resources/keystore.p12 \
	-storepass changeit \
	-validity 3650 \
	-dname "CN=localhost, OU=Dev, O=Example, L=City, ST=State, C=US"
```

### Build the Project

```sh
mvn clean install
```

### Run the Application
```sh
mvn spring-boot:run
```

The app will start on https://localhost:8443 with HTTPS enabled.

### Run Tests
```sh
mvn test
```

## License
This project is released under the [CC0 1.0 Universal Public Domain Dedication](LICENSE).

## Contributing
Feel free to fork, submit issues, or open pull requests!
