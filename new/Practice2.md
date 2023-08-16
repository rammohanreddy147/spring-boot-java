
# **Monitoring Banking Microservices with Spring Boot Actuator**

## **Use Case: Banking Microservice Monitoring**

Imagine you're a developer at a modern bank that has embraced microservices architecture. As the bank's services grow, it becomes vital to monitor the health, performance, and status of each microservice. For this, the bank has chosen Spring Boot Actuator, a tool that makes monitoring and introspecting applications seamless. In this lab, we'll build a basic banking microservice and integrate Spring Boot Actuator to monitor it.

## **Steps**

### **1. Create a New Directory for Your Project**

Start by initializing a new directory for our banking microservice:

\```bash
mkdir banking-service
cd banking-service
\```

### **2. Bootstrap Your Spring Boot Application with Gradle and Actuator**

Use Spring Initializr to bootstrap your Spring Boot project with Gradle, the Web, and Actuator dependencies:

\```bash
curl https://start.spring.io/starter.zip -o banking-service.zip -d type=gradle-project -d dependencies=web,actuator
unzip banking-service.zip
\```

### **3. Remove the Default `demo` Folder**

The bootstrap process sometimes creates a `demo` folder that we won't use. Delete it:

\```bash
rm -r src/main/java/com/example/demo
\```

### **4. Create Your Main Application Class**

Set up the main entry point for your application:

\```bash
mkdir -p src/main/java/com/bank/service
touch src/main/java/com/bank/service/BankingServiceApplication.java
\```

Then, write the following content:

\```java
package com.bank.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankingServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(BankingServiceApplication.class, args);
    }
}
\```

### **5. Create a Simple REST Controller for Banking Operations**

Create a basic controller:

\```bash
touch src/main/java/com/bank/service/BankingController.java
\```

Open the file and add:

\```java
package com.bank.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankingController {
    @GetMapping("/balance")
    public String checkBalance() {
        // This is a mock balance check for the purpose of this lab.
        return "Your current balance is $5000.";
    }
}
\```

### **6. Integrate Spring Boot Actuator**

Since we've added the Actuator dependency during bootstrap, it's already integrated. By default, only a few endpoints are exposed over HTTP, mainly for security reasons.

### **7. Change the Default Port**

By default, Spring Boot applications run on port 8080. To change this, modify the `application.properties`:

\```properties
server.port=8081
\```

This will run the application on port 8081.

### **8. Run Your Application**

In your terminal, start your Spring Boot application:

\```bash
./gradlew bootRun
\```

Now, you can access your banking service's balance check at `http://localhost:8081/balance` and the Actuator's health check at `http://localhost:8081/actuator/health`.

## **Conclusion**

Congratulations! You've built a basic banking microservice with integrated monitoring via Spring Boot Actuator. In a real-world scenario, Actuator can provide insights into the application's health, performance metrics, and more, ensuring that any issues are promptly identified and resolved, thereby guaranteeing customers seamless access to their banking information.
