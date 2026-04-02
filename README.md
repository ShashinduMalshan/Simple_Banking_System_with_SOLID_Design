
---

##  **SOLID Principles – Simple Explanation with Banking System Example**

### 🔹 What is SOLID?

SOLID is a set of **5 design principles in Object-Oriented Programming (OOP)** that help developers write **clean, maintainable, and scalable code**.

---

## 🔹 1. Single Responsibility Principle (SRP)

 **Definition:**
A class should have **only one responsibility** (one job).

 **In our project:**

* `CustomerService` → handles customer logic
* `AccountService` → handles account operations
* `TransactionService` → handles transactions

 Each class does only one thing → **SRP followed**

---

## 🔹 2. Open/Closed Principle (OCP)

 **Definition:**
Software should be **open for extension but closed for modification**.

 **In our project:**

* We use interfaces like `TransactionService`, `AccountService`
* If we want new features, we can create new implementations without changing old code

 Example: Add new transaction types without modifying existing logic

---

## 🔹 3. Liskov Substitution Principle (LSP)

 **Definition:**
Child classes should be able to replace parent classes without breaking the system.

 **In our project:**

* `TransactionServiceImpl` can replace `TransactionService`
* Controller uses interface, not implementation

 System works even if implementation changes

---

## 🔹 4. Interface Segregation Principle (ISP)

 **Definition:**
Do not force a class to implement methods it does not use.

 **In our project:**

* Separate interfaces:

    * `CustomerService`
    * `AccountService`
    * `TransactionService`

 Each interface is small and focused

---

## 🔹 5. Dependency Inversion Principle (DIP)

 **Definition:**
High-level modules should depend on **abstractions (interfaces)**, not concrete classes.

 **In our project:**

```java
private final AccountService accountService;
```

* Controller depends on interface, not `AccountServiceImpl`

 Makes code flexible and testable

---

## 🏦 **Project Overview (Simple Banking System)**

### Features:

* Create Customer
* Create Account
* Deposit & Withdraw Money
* Record Transactions

### Structure:

* `controller` → handles API requests
* `service` → business logic (SOLID applied)
* `repository` → database access
* `entity` → database models
* `model` → data transfer

---

##  **How SOLID is Used in This Project**

| Principle | How We Used                                          |
| --------- | ---------------------------------------------------- |
| SRP       | Separate services for Customer, Account, Transaction |
| OCP       | Used interfaces for extension                        |
| LSP       | Implementation replaces interface safely             |
| ISP       | Small, specific interfaces                           |
| DIP       | Controller depends on service interface              |

---

##  **Conclusion**

Using SOLID principles helps to:

* Write clean code
* Reduce bugs
* Make system scalable
* Easy to maintain

This **Simple Banking System** is a basic example of applying SOLID principles in a real-world project.

---
