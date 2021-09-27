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

