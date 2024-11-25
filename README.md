# Loan Project 💼

This project is a loan management system built with Java, Spring Boot, and Maven. It provides functionalities to determine loan eligibility and calculate interest rates for different types of loans.

## Features ✨

- **Personal Loan**: Eligibility and interest rate calculation.
- **Guaranteed Loan**: Eligibility and interest rate calculation.
- **Consignment Loan**: Eligibility and interest rate calculation.

## Technologies Used 🛠️

- **Java**: Programming language.
- **Spring Boot**: Framework for building the application.
- **Maven**: Build and dependency management tool.
- **JUnit 5**: Testing framework.
- **Mockito**: Mocking framework for unit tests.

## Getting Started 🚀

### Prerequisites

- Java 23 or higher
- Maven 4.0.0 or higher

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/Josepch1/loan-project.git
    ```
2. Navigate to the project directory:
    ```sh
    cd loan-project
    ```
3. Build the project using Maven:
    ```sh
    ./mvnw clean package
    ```

### Running the Application

To run the application, use the following command:
```sh
java -jar target/loanproject-0.0.1-SNAPSHOT.jar
```

### Running Tests

To run the tests, use the following command:
```sh
./mvnw test
```

## Usage 📝

**[POST]** `{{host}}/customer-loans`

```json
{
    "age": 26,
    "cpf": "275.484.389-23",
    "name": "Vuxaywua Zukiagou",
    "income": 7000.00,
    "location": "SP"
}
```

200 code:

```
HTTP/1.1 200 Ok
```

```json
{
    "customer": "Vuxaywua Zukiagou",
    "loans": [
        {
            "type": "CONSIGNMENT",
            "interest_rate": 2
        }
    ]
}
```


## Contributing 🤝

Contributions are welcome! Please fork the repository and submit a pull request.

---

Made with ❤️ by @Josepch1
