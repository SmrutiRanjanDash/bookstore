# bookstore

About the Project
A Java/Spring Boot/Maven based Microservice for an online bookstore, where the user can perform the following operations:

CRUD operations on Books
Checkout operation for single or multiple books which will return the total payable amount.
 

Notes:
1. Book object have the following attributes:
    - Name
    - Description
    - Author
    - Type/Classification
    - Price
    - ISBN
2. Checkout method will take list of books as parameters plus optional promotion code and return total price after discount (if applicable).
Promotion/Discounts is variant according to book type/classification, ex: fiction books may have 10% discount while comic books have 0% discount.

# How to Run
This application is packaged as a war which has Tomcat 8 embedded. No Tomcat or JBoss installation is necessary.

1. Clone this repository
2. Make sure you are using JDK 1.8, Maven 3.x and IntelliJ/Eclipse
3. You can import the project to IntelliJ, Configure and run the bookstore Application
4. Once successfully built, you can run the service by one of these URLs:

  READ:GET
       - Get the list of Books: http://localhost:8080/book
       - Get a specific book: http://localhost:8080/book/{id}  Note: Please enter 1 or 2[Dummy Data]
       
  CREATE/UPDATE: POST
        - Pay Load: 
                  {
                  "name": "SpringBoot",
                  "Description": "Spring Boot",
                  "Author": "SDash",
                  "type": "Comic",
                  "Price": 100.00,
                  "isbn": "I100002"
                  }
   DELETE: DELETE
        - 
