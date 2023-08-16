
# **Introduction to Spring Boot Microservices with Docker**

## **Use Case: Account Balance Inquiry**

In today's digital banking era, customers demand instant access to their account details, including checking their balance in real-time. In this lab, we'll build a microservice named "Account Balance Inquiry" using Spring Boot. This service will simulate checking an account balance. For added depth, we'll containerize this microservice using Docker, making it ready for scalable deployment.

## **Steps**

### **1. Create a New Directory for Your Project**

Begin by initializing a new directory for our microservice:

\```bash
mkdir account-balance-service
cd account-balance-service
\```

### **2. Bootstrap Your Spring Boot Application with Gradle**

Use Spring Initializr to bootstrap your Spring Boot project with Gradle:

\```bash
curl https://start.spring.io/starter.zip -o account-balance-service.zip -d type=gradle-project -d dependencies=web
unzip account-balance-service.zip
\```

### **3. Remove the Default `demo` Folder**

Eliminate the automatically generated `demo` folder:

\```bash
rm -r src/main/java/com/example/demo
\```

### **4. Create Your Main Application Class**

Set up the primary entry point:

\```bash
mkdir -p src/main/java/com/bank/balance
touch src/main/java/com/bank/balance/AccountBalanceApplication.java
\```

Input the following content:

\```java
package com.bank.balance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccountBalanceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountBalanceApplication.class, args);
    }
}
\```

### **5. Create a Simple REST Controller for Account Balance Inquiry**

Set up a basic controller:

\```bash
touch src/main/java/com/bank/balance/BalanceController.java
\```

Populate with:

\```java
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
\```

### **6. Build Your Application with Gradle**

In your Gitpod terminal, execute:

\```bash
./gradlew build
\```

### **7. Run Your Application**

Still in the terminal:

\```bash
./gradlew bootRun
\```

Once your application starts, you can access the balance check at `http://localhost:8080/balance`.

### **8. Docker Bonus: Containerize the Microservice**

To containerize, you first need a Dockerfile. Create one in the root directory:

\```bash
touch Dockerfile
\```

Populate with:

\```Dockerfile
FROM openjdk:11
EXPOSE 8080
ADD build/libs/account-balance-service-0.0.1-SNAPSHOT.jar account-balance-service.jar
ENTRYPOINT ["java", "-jar", "/account-balance-service.jar"]
\```

Build the Docker image:

\```bash
docker build -t account-balance-service .
\```

Run the container:

\```bash
docker run -p 8080:8080 account-balance-service
\```

Access the service again at `http://localhost:8080/balance`.

## **Conclusion**

Kudos! You've successfully developed, containerized, and deployed a Spring Boot microservice using Docker. This "Account Balance Inquiry" service demonstrates the power and flexibility of Spring Boot combined with the scalability and portability of Docker containers. Such skills are invaluable in today's cloud-native world.
