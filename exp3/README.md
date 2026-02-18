## Book Management System (Java)

This repository contains a Java-based implementation of a **Book Management System** that demonstrates object-oriented principles, custom exception handling, and data processing using Java Streams.

---

### Features

* **Custom Exception Handling:** Implements `InvalidPriceException` and `InvalidGenreException` to validate book data during object creation.
* **Data Isolation:** Uses separate `try-catch` blocks to ensure that one invalid entry doesn't prevent other valid entries from being processed.
* **Stream API Integration:** * Calculates the **average price** of all books in the list.
* Groups books **genre-wise** into a Map for organized display.


* **Object Copying:** Demonstrates the difference between reference copying and deep/constructor copying.

---

### Prerequisites

* **Java Development Kit (JDK):** Version 8 or higher.
* **IDE:** IntelliJ IDEA, Eclipse, or VS Code (optional).

---

### Usage

1. Clone the repository.
2. Ensure `Book.java`, `InvalidPriceException.java`, and `InvalidGenreException.java` are in the same directory.
3. Compile and run `ArrayListOfBooks.java`.

```bash
javac ArrayListOfBooks.java
java ArrayListOfBooks

```

---



The system will output the details of each successfully added book, followed by the calculated average price and a categorized list by genre. If a book fails validation, a descriptive error message is printed to the console without crashing the program.

Would you like me to help you write the `.gitignore` file for this project?
