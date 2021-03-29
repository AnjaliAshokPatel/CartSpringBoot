### This is a Cart Total Calculator project.
#### Developed an application by using Spring Boot.

### Tech stack:
  - Spring Boot

### Requirements

For building and running the application you need:
- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)
- [IntelliJ IDEA Community Edition 2020.3.3](https://www.jetbrains.com/idea/download/#section=windows)
- [Postman REST Client](https://www.postman.com/product/rest-client/)

### Build & Run 
* Open the project in IntelliJ IDEA Community Edition IDE.
* Set the Java SDK version to 11, JDK version 1.8
* Create a file `products.txt` inside the `src` folder which contains product names and prices separated by space, one line per product
* Build the project using Ctrl + F9
* Run the project

### Port
```
  http://localhost:8080
```

### API Documentation
GET request to calculate the cart total
```
GET http://localhost:8080/calculateTotal
```
Body:
A JSON object containing mapping of the product names to quantities.
Example:
```
{
    "A":1,
    "B":2
}
```

Response:
Upon successful operation, a JSON object is returned containing the
1. Cart Total
2. Discount Applied
3. Final Total Bill

In case of an error, the error is returned.