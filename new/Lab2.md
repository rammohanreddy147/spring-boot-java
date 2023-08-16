
**Lab 2: Advanced Account Management with Spring Boot and Docker**

---

## **Use Case: Enhanced Account Operations**

Building upon our foundational "Account Balance Inquiry" service from Lab 1, we're now tasked with implementing more intricate account operations. This expansion will enable customers to not only view but also modify their account balances through deposits and withdrawals. This service will simulate these operations and maintain a transaction history for the session.

## **Prerequisites**

Ensure you've successfully completed [Lab 1](/mnt/data/Lab1.md) as we'll continue developing that project.

## **Steps**

### **1. Navigate to the Project Directory**

```bash
cd /workspace/spring-boot-java/account-balance-service
```

### **2. Enhance the Controller with New Endpoints**

Modify `BalanceController.java` to include endpoints that handle deposits, withdrawals, and transaction history.

Make sure to add these imports:
```java
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Arrays;
```
Here's a breakdown of what each import does:

- GetMapping and PostMapping: Annotations for handling HTTP GET and POST requests respectively.
- RequestBody: Annotation to indicate that a method parameter should be bound to the body of the HTTP request.
- RequestParam: Annotation to indicate that a method parameter should be bound to a web request parameter.
- List: Java's List class for handling lists of data.
- Arrays: Java's Arrays class which contains various methods for manipulating arrays.

#### **a. Deposit Endpoint (Using GET and POST)**

For demonstration purposes, we'll allow deposits using both `GET` and `POST` methods:

```java
// Using GET
@GetMapping("/deposit")
public String depositViaGet(@RequestParam Double amount) {
    // Mock operation
    return String.format("Successfully deposited $%.2f to your account via GET.", amount);
}

// Using POST
@PostMapping("/deposit")
public String depositViaPost(@ModelAttribute("amount") Double amount) {
    // Mock operation
    return String.format("Successfully deposited $%.2f to your account via POST.", amount);
}
```

#### **b. Withdrawal Endpoint (Using GET and POST)**

Similarly, we'll handle withdrawals using both methods:

```java
// Using GET
@GetMapping("/withdraw")
public String withdrawViaGet(@RequestParam Double amount) {
    // Mock operation
    return String.format("Successfully withdrew $%.2f from your account via GET.", amount);
}

// Using POST
@PostMapping("/withdraw")
public String withdrawViaPost(@ModelAttribute("amount") Double amount) {
    // Mock operation
    return String.format("Successfully withdrew $%.2f from your account via POST.", amount);
}
```

#### **c. Transaction History Endpoint**

To simulate transaction history:

```java
@GetMapping("/history")
public List<String> getAccountHistory() {
    // Mock data for demonstration
    return Arrays.asList(
        "Deposited $500",
        "Withdrew $50",
        "Deposited $200",
        "Withdrew $100",
        "Deposited $1000"
    );
}
```

### **3. Test New Endpoints**

After implementing the new endpoints, compile and run the service:

```bash
./gradlew build
./gradlew bootRun
```

In Gitpod's browser or using a tool like `curl`, you can now:

- Deposit using GET: `http://localhost:8080/deposit?amount=500`

For POST requests, you can use Postman, a popular tool for API testing. Alternatively, you can use `curl` directly from the terminal:

- Deposit using POST:

```bash
curl -X POST -H "Content-Type: application/json" -d "500" http://localhost:8080/deposit
```

- Withdraw using POST:

```bash
curl -X POST -H "Content-Type: application/json" -d "50" http://localhost:8080/withdraw
```

- View transaction history: `http://localhost:8080/history`

### **4. Dockerize and Test**

Just as in Lab 1, build the Docker image and run it:

```bash
docker build -t account-balance-service .
docker run -p 8080:8080 account-balance-service
```

Test the Dockerized service using the same endpoints as before.

### **5. Push to Docker Hub (Optional)**

If desired, you can push the updated Docker image to Docker Hub:

```bash
docker push [YOUR_DOCKERHUB_USERNAME]/account-balance-service:latest
```

### **6. Bonus: Create a Simple HTML Form for Testing**

You can set up a basic HTML form to test the deposit and withdrawal functionalities without using Postman or `curl`.

Create a new file `index.html`:

```bash
touch src/main/resources/static/index.html
```

Edit `index.html` and input:

```html
<!DOCTYPE html>
<html>
<head>
    <title>Account Operations</title>
</head>
<body>

<h2>Deposit</h2>
<form action="/deposit" method="post">
  Amount: <input type="text" name="amount">
  <input type="submit" value="Deposit">
</form>

<h2>Withdraw</h2>
<form action="/withdraw" method="post">
  Amount: <input type="text" name="amount">
  <input type="submit" value="Withdraw">
</form>

</body>
</html>
```

Restart your Spring Boot application and navigate to `http://localhost:8080` in Gitpod's browser to access and test using the form.

## **Conclusion**

Congratulations on completing Lab 2! You've now extended your microservice to support more advanced operations and tested them through multiple avenues. Whether you're using a browser, Postman, `curl`, or a basic HTML form, Spring Boot makes it seamless to interface with your service.
