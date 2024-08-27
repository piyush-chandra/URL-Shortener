# URL Shortener

This project is a URL shortener application built with Spring Boot. It allows users to create shortened versions of long URLs, manage their links, and track usage statistics. It is system design problem that i want to solve. I will follow Alex Xu's system design book to solve this problem.

## Features

- URL shortening
- User authentication (login/signup)
- User dashboard for link management
- Click tracking and analytics
- Customizable short URLs
- RESTful API

## Technologies Used

- Java 22
- Spring Boot 3.1.0
- Spring Data JPA
- Thymeleaf
- PostgreSQL
- HTML/CSS/JavaScript
- Maven

## How to Run

1. Navigate to the project directory:
   ```
   cd url-shortener
   ```

3. Configure the database connection in `src/main/resources/application.properties`.

4. Build the project:
   ```
   mvn clean install
   ```

5. Run the application:
   ```
   java -jar target/url-shortener-0.0.1-SNAPSHOT.jar
   ```

6. Access the application at `http://localhost:42069`.

## Future Plans

- Implement rate limiting to prevent abuse
- Add support for custom domains
- Enhance analytics with geolocation data
- Develop mobile applications for iOS and Android
- Implement a caching layer for improved performance
- Add social media sharing options for shortened URLs

## Project Structure

The project follows a standard Spring Boot structure:

- `src/main/java`: Contains the Java source code
  - `click.shoort.URL_Shoortener`: Root package
    - `controller`: REST controllers and web controllers
    - `model`: Entity classes representing database tables
    - `repository`: Spring Data JPA repositories
    - `service`: Business logic and service layer
    - `config`: Configuration classes
- `src/main/resources`: Contains non-Java resources
  - `static`: Static web assets (CSS, JavaScript, images)
  - `templates`: Thymeleaf HTML templates
  - `application.properties`: Application configuration file
- `src/test`: Contains test classes
- `pom.xml`: Maven project configuration file

This structure separates concerns, making the project more organized and maintainable. The package names may vary based on your specific project setup.
