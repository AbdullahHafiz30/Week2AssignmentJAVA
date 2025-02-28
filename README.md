# E-Commerce Java Application

## Overview
This project is a simple e-commerce application implemented in Java. It demonstrates key OOP concepts including inheritance, polymorphism, and exception handling. The application allows users to place orders and view their order history through a command-line interface.

## Key OOP Implementations
- **Classes & Inheritance:**  
  The `Product` class is extended by `Electronics` and `Clothing` to add specific attributes and discount logic.
- **Polymorphism:**  
  The `calculateDiscount()` method is overridden in both subclasses to implement product-specific discount strategies.
- **Collections:**  
  Orders are stored in an `ArrayList<Order>`, and user order histories are managed using a `HashMap<Integer, ArrayList<Order>>`.
- **Exception Handling:**  
  A custom exception, `OutOfStockException`, is used to manage stock issues during order placement.
- **CLI Interface:**  
  A simple CLI menu allows users to place orders and view order histories.

## How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/your_username/ecommerce-java-app.git
