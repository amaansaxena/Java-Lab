# Vector Operations in Java

## Overview

This assignment implements a custom `Vector` class in Java that supports 2D and 3D vector mathematics. It includes robust error handling using a custom exception class to ensure that operations are only performed on vectors with compatible dimensions.

## Features

* **Dimension Constraint:** Specifically allows only 2D or 3D vector creation.
* **Vector Arithmetic:** Supports addition and subtraction of vectors.
* **Dot Product:** Calculates the scalar product of two vectors.
* **Dimension Validation:** A dedicated method ensures vectors are of the same dimension before performing operations.
* **Custom Exception Handling:** Uses `VectorException` to handle invalid dimensions or mismatched operations.

---

## File Structure

| File | Description |
| --- | --- |
| `Vector.java` | The core class containing vector components, math logic, and validation. |
| `VectorException.java` | Custom exception class for handling vector-specific errors. |
| `VectorOperations.java` | The main driver class that handles user input and displays results. |

---

## Implementation Details

### Mathematical Operations

The project implements standard Euclidean vector space operations:

1. **Addition:** 
$$\vec{a} + \vec{b} = (a_1 + b_1, a_2 + b_2, a_3 + b_3)$$


2. **Subtraction:** 
$$\vec{a} - \vec{b} = (a_1 - b_1, a_2 - b_2, a_3 - b_3)$$


3. **Dot Product:** 
$$\vec{a} \cdot \vec{b} = a_1b_1 + a_2b_2 + a_3b_3$$



### Exception Handling

The `VectorException` is thrown in the following scenarios:

* Attempting to create a vector that is not 2D or 3D (e.g., 1D or 4D).
* Attempting to add, subtract, or dot product two vectors of different dimensions (e.g., a 2D vector with a 3D vector).

---

## How to Run

1. **Clone the repository:**
```bash
git clone https://github.com/yourusername/vector-operations-java.git

```


2. **Compile the source files:**
```bash
javac VectorException.java Vector.java VectorOperations.java

```


3. **Run the application:**
```bash
java VectorOperations

```

---

