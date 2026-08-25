# E-Commerce Automation Framework

A Selenium WebDriver automation framework built using Java, TestNG, Maven, Page Object Model, and Apache POI for data-driven testing.

## 🚀 Project Overview

This project automates the major user flows of an e-commerce application, including:

- User login
- Product selection
- Add product to cart
- Cart validation
- Checkout
- Order confirmation

The framework is designed using reusable components and supports maintainable, scalable test automation.

## 🛠️ Technologies Used

- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- Apache POI
- Log4j2
- ExtentReports
- WebDriverManager
- Git & GitHub

## 🏗️ Framework Features

- Page Object Model
- Data-driven testing using Excel
- Reusable Selenium utilities
- Explicit waits
- Configuration management
- TestNG groups
- Retry mechanism
- Failure screenshots
- Log4j2 logging
- ExtentReports
- Smoke testing
- Regression testing
- Cross-browser testing
- Headless execution
- Parallel execution
- Maven test execution
  
## 📁 Project Structure

```text
ECommerceAutomationFramework
│
├── pom.xml
├── testng.xml
├── testng-smoke.xml
├── testng-regression.xml
│
├── src/main/java
│   └── com.ecommerce
│       ├── config
│       ├── driver
│       ├── pages
│       ├── testdata
│       └── utilities
│
├── src/test/java
│   └── com.ecommerce
│       ├── base
│       ├── dataproviders
│       ├── listeners
│       ├── retry
│       ├── tests
│       └── utilities
│
└── src/test/resources
    ├── config
    ├── testdata
    └── log4j2.xml
```
## 🧪 Test Suites

### Smoke Testing
```bash
mvn clean test -DsuiteXmlFile=testng-smoke.xml

```
##Regression Testing
```bash
mvn clean test -DsuiteXmlFile=testng-regression.xml

##Cross-Browser Execution
```
**Chrome**
```bash
mvn clean test -Dbrowser=chrome -Dheadless=true
```
**Edge**
```bash
mvn clean test -Dbrowser=edge -Dheadless=true
```
**Firefox**
```bash
mvn clean test -Dbrowser=firefox -Dheadless=true
```
## 📊 Reporting
```
- ExtentReports for HTML test reporting
- Log4j2 for execution logging
- Automatic screenshots on test failure

## 🔄 Retry Mechanism

Failed tests can be automatically retried using the custom TestNG `RetryAnalyzer`.

## ⚡ Parallel Execution

TestNG parallel execution is configured using multiple threads.

The framework uses `ThreadLocal<WebDriver>` to maintain separate WebDriver instances during parallel execution.

## 📈 Test Coverage

The current automation covers:

- Login validation
- Product selection
- Add product to cart
- Cart validation
- Checkout flow
- Order confirmation

## ▶️ How to Run

### Prerequisites

- Java JDK
- Maven
- Eclipse or another Java IDE
- Chrome, Edge, or Firefox

### Run Maven Tests

```bash
mvn clean test

## 🔮 Future Enhancements

- GitHub Actions CI/CD
- Additional test scenarios
- API automation integration
- Docker-based execution

## 👨‍💻 Author

**Akheel Basha**

Java | Selenium | TestNG | Maven | Automation Testing
