
# Spring Boot Microservices Lab

In this lab, you will walk through the process of creating a simple Spring Boot microservice from scratch using Gitpod, Gradle, and Java 17. By the end of this lab, you'll have a running microservice that can handle multiple HTTP requests.

## **Prerequisites**

- Familiarity with Java and Spring Boot.
- A Gitpod account and the setup from the previous instructions.

## **Steps**

### 1. **Setup Gitpod Workspace and Install Java 17**

Ensure your Gitpod workspace is set up using the previous instructions. Then, install and set Java 17 as the default version:

```bash
# Install and set the desired Java version
sdk install java 17.0.8-oracle
sdk use java 17.0.8-oracle
```

### 2. **Create and Navigate to `my-service` Directory**

Before we bootstrap our Spring Boot application, create a new directory:

```bash
mkdir my-service
cd my-service
```

### 3. **Bootstrap Your Spring Boot Application with Gradle**

Use Spring Initializr to bootstrap your Spring Boot project with Gradle and the Spring Web dependency:

```bash
curl https://start.spring.io/starter.zip -o my-service.zip -d type=gradle-project -d dependencies=web
unzip my-service.zip
```

All the bootstrapped files will now be inside the `my-service` directory.

### 4. **Remove Unwanted `demo` Folder**

The bootstrap process creates a `demo` folder that we won't be using. Let's remove it:

```bash
rm -r src/main/java/com/example/demo
```

### 5. **Create Your Main Application Class**

1. First, create the required directory and file from the terminal:

```bash
mkdir -p src/main/java/com/example/myservice
touch src/main/java/com/example/myservice/MyServiceApplication.java
```

2. Now, navigate to the newly created `MyServiceApplication.java` file in the Explorer pane of Gitpod. Open it and input the following content:

```java
package com.example.myservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyServiceApplication.class, args);
    }
}
```

### 6. **Create a Simple REST Controller**

1. Create a new file for the controller:

```bash
touch src/main/java/com/example/myservice/HelloController.java
```

2. Open `HelloController.java` in the Explorer pane and add the following content:

```java
package com.example.myservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, Spring Boot Microservice!";
    }
}
```

### 7. **Run Your Application**

In your Gitpod terminal, navigate to your project root (`my-service`) and execute:

```bash
./gradlew bootRun
```

This will start your Spring Boot application.

### 8. **Access Your Microservice**

Once your application is up, access the Gitpod-exposed port to interact with your microservice. Click the "Open Browser" notification in Gitpod, leading to a new browser tab showcasing your running service. Navigate to `/hello` to view the greeting.

### 9. **Add More Endpoints**

Let's expand our microservice by adding more endpoints. Open `HelloController.java` and add the following methods:

```java
@GetMapping("/greet/{name}")
public String greetByName(@PathVariable String name) {
    return "Hello, " + name + "!";
}

@GetMapping("/info")
public Map<String, String> getInfo() {
    Map<String, String> info = new HashMap<>();
    info.put("version", "1.0.0");
    info.put("description", "My Spring Boot Microservice");
    return info;
}
```

Now, after restarting your application, you can access:

- `/greet/{name}` to get a personalized greeting.
- `/info` to get basic service information.

### 10. **Experiment Further**

With a microservice up and running, you can:

- Connect to a database.
- Incorporate authentication and authorization.
- Integrate other Spring Boot features.

## **Conclusion**

Bravo! You've successfully developed a Spring Boot microservice with multiple endpoints using Gitpod, Gradle, and Java 17. As you journey further into microservices, you'll tackle intricate scenarios, integrations, and patterns. Ensure your services are always tested, documented, scalable, and maintainable.
