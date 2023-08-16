
# **Introduction to Spring Boot Microservices with Docker**

## **Use Case: Account Balance Inquiry**

Modern banks rely on microservices to deliver instantaneous results to their customers. Imagine you're a developer at such a bank, tasked with creating an "Account Balance Inquiry" service. This service will allow customers to check their account balances in real time. In this lab, we'll build this microservice using Spring Boot, and for an added challenge, we'll containerize it using Docker.

## **Lab Setup in Gitpod**

### **1. Open Terminal in Gitpod**

Start by opening the terminal from the Gitpod interface.

### **2. Install JDK 17**

Set up JDK 17 for our project by entering the following in the terminal:

```bash
sdk install java 17.0.8-oracle
sdk use java 17.0.8-oracle
```

### **3. Navigate to the Root Directory**

In the terminal, navigate to the root directory:

```bash
cd /workspace/spring-boot-java/account-balance-service
```

### **4. Bootstrap Your Spring Boot Application with Gradle**

Bootstrap your Spring Boot project using Spring Initializr:

```bash
curl https://start.spring.io/starter.zip -o account-balance-service.zip -d type=gradle-project -d dependencies=web
unzip account-balance-service.zip
```

### **5. Delete the Default Test File**

The default test file is named `DemoApplicationTests.java` and is located in the `src/test/java/com/example/demo` directory. Remove it:

```bash
rm src/test/java/com/example/demo/DemoApplicationTests.java
```

### **6. Remove the Default `demo` Folder**

Remove the auto-generated `demo` folder:

```bash
rm -r src/main/java/com/example/demo
```

### **7. Create the Main Application Class**

Navigate to the appropriate directory and establish the main class:

```bash
mkdir -p src/main/java/com/bank/balance
touch src/main/java/com/bank/balance/AccountBalanceApplication.java
```

Edit `AccountBalanceApplication.java` in Gitpod and populate with:

```java
package com.bank.balance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccountBalanceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountBalanceApplication.class, args);
    }
}
```

### **8. Craft the REST Controller for Account Balance Inquiry**

Set up a controller:

```bash
touch src/main/java/com/bank/balance/BalanceController.java
```

Edit `BalanceController.java` and input:

```java
package com.bank.balance;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {
    @GetMapping("/balance")
    public String checkBalance() {
        return "Your current balance is $5000.";
    }
}
```

### **9. Build the Application with Gradle**

Back in the terminal:

```bash
./gradlew build
```

### **10. Run the Application**

Execute:

```bash
./gradlew bootRun
```

Upon startup, in Gitpod's browser view, navigate to `http://localhost:8080/balance`.

### **11. Docker Bonus: Containerize the Microservice**

First, create a Dockerfile in the root directory:

```bash
touch Dockerfile
```

Edit `Dockerfile`:

```Dockerfile
FROM openjdk:11
EXPOSE 8080
ADD build/libs/demo-0.0.1-SNAPSHOT.jar account-balance-service.jar
ENTRYPOINT ["java", "-jar", "/account-balance-service.jar"]
```

Ensure you've built the application:

```bash
./gradlew build
```

Then, verify if the `.jar` file is generated:

```bash
ls build/libs/
```

If the `.jar` file is present, proceed with the Docker build:

```bash
docker build -t account-balance-service .
```

Run the container:

```bash
docker run -p 8080:8080 account-balance-service
```

Visit `http://localhost:8080/balance` to access the service.

## **Conclusion**

Congratulations! You've designed a Spring Boot microservice, containerized it with Docker within Gitpod, and deployed it. This "Account Balance Inquiry" service represents the union of Spring Boot and Docker in constructing robust, scalable services.
