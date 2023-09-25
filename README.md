# comercio-electronico

## Description

This project is focused on providing a RESTful API for handling price information. It includes a `PriceController` and its required dependencies. The application uses an H2 database and offers a Swagger UI interface for API documentation.

## Prerequisites

- Java 8 or 11
- Maven 3.x
- H2 Database (embedded version included)

## Installation & Setup

### Clone the Repository

bash
git clone https://github.com/luisrio/comercio-electronico.git


### Navigate to the Project Directory

bash
cd comercio-electronico


### Build the Project

bash
mvn clean install


This will download the necessary dependencies, compile the source code, and run the unit tests.

## Running the Application

### Run with Maven

bash
mvn spring-boot:run


### Run with Executable Jar

bash
java -jar target/comercio-electronico.jar


## Testing

Run the tests with Maven:

bash
mvn test


## Database

The application uses an embedded H2 database. The database schema will be automatically created when you run the application.

## API Documentation with Swagger UI

Once the application is running, the API documentation can be accessed via Swagger UI:

- Open your browser
- Go to `http://localhost:8080/swagger-ui.html`

## Endpoints

This application primarily exposes a `PriceController` that handles price information.