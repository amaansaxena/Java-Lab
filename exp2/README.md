# Experiment 2: Vehicle Management System

This directory contains the Java implementation for **Experiment 2**, focusing on fundamental Object-Oriented Programming (OOP) concepts such as encapsulation, constructor overloading, and array manipulation.

## 📂 Project Structure

All files for this experiment are organized within the `exp2` folder:

* **`Vehicle.java`**: The blueprint class containing public and private data members, multiple constructors, and operational methods.
* **`MainForVehicle.java`**: The driver class that instantiates the `Vehicle` array and handles the formatted output.

---

## 🚀 Key Technical Features

### 1. Robust Encapsulation

The system protects sensitive technical data by using **private** access modifiers. These are accessed and modified through secure **getter and setter** methods:

* `mfgCode` (Manufacturing Code)
* `noOfCylinders` (Engine Cylinders)

### 2. Constructor Overloading

The implementation includes three distinct types of constructors to handle different initialization scenarios:

* **Default Constructor**: Initializes a standard "Honda Accord" with preset values.
* **Parameterized Constructor**: Allows custom creation of vehicles with specific attributes like brand, price, and fuel type.
* **Copy Constructor**: Enables the creation of a new object by copying data from an existing `Vehicle` instance.

### 3. Operational Logic

* **Movement**: Functional methods for `start()`, `drive()`, and `stop()`.
* **Efficiency**: A `displayFuelEfficiency()` method that uses a switch-case to calculate metrics based on the fuel type (Petrol, Diesel, or Electric).
* **Safety**: The `changeSpeed()` method validates if the input speed exceeds the vehicle's `speedLimit`.

---

## 📊 Data Representation

The program processes a fleet of vehicles stored in a `Vehicle[]` array and generates a clean, technical report in a tabular format.

| Attribute | Details |
| --- | --- |
| **Brands Included** | Honda, Toyota, Tesla, Ford, Volvo |
| **Fuel Types** | Petrol, Diesel, Electric |
| **Metrics Tracked** | Price, Engine Power, Cylinders, MFG Code, Efficiency |

---

## ⚙️ How to Compile & Run

To run this experiment, navigate to the `exp2` directory in your terminal and execute the following commands:

1. **Compile the source files**:
```bash
javac Vehicle.java MainForVehicle.java

```


2. **Execute the program**:
```bash
java MainForVehicle

```
