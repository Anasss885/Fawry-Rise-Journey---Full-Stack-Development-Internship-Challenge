
#  Fawry Rise Mini E-Commerce System (Java Console App)

This project simulates a **console-based e-commerce system** designed as part of the Fawry Rise Internship Challenge. It demonstrates the use of **Object-Oriented Programming**, **SOLID principles**, and efficient **data structures** to create a scalable, maintainable, and readable backend system.

---

## Features

- Define Products (with price, quantity, expiry date, shipping eligibility, weight)
- Add products to a cart with stock and expiry checks
- Associate each cart with a specific customer
- Perform checkout with:
  - Subtotal, shipping fee, and final amount calculations
  - Shipment notice for shippable items
  - Validation for balance, expiry, and stock
- Clear and update stock after purchase

---

##  OOP Principles in Action

| Principle       | How It's Applied |
|----------------|------------------|
| **Encapsulation** | All class fields are private and accessed via getters/setters. Product, Customer, and Cart objects hide internal details. |
| **Abstraction**   | Users interact only with `Cart` and `Customer` through clear public methods (e.g. `addProduct()`, `checkout()`), hiding internal logic. |
| **Inheritance**   | Not directly applied here since the design didn’t require shared base classes — kept intentionally simple. |
| **Polymorphism**  | Polymorphism can be extended later with a `Shippable` interface (planned for integration with ShippingService). ( unfortunately , i didn't have enough time to implment the Shipping Services side propelry insiptie of it's very easy , promising if i have extra time i'm capable of implmenting it in an extra well-effecient way.

---

##  SOLID Principles

| Principle | Application |
|----------|-------------|
| **S – SRP (Single Responsibility)** | Each class has one clear job: `Product` handles product data, `Customer` handles balance and payment, and `Cart` coordinates operations. |
| **O – OCP (Open/Closed)** | The design is open for extension (e.g. adding discounts, promotions, loyalty programs) without modifying core logic. |
| **L – LSP (Liskov Substitution)** | Objects of `Product`, `Customer` can be used as-is without breaking behavior — ready for further inheritance. |
| **I – ISP (Interface Segregation)** | Reserved for future enhancements (e.g. splitting shipping behavior into an interface). Not applicable in this scope. |
| **D – DIP (Dependency Inversion)** | `Cart` depends on an abstraction of `Customer`, injected via the constructor (Dependency Injection). The system avoids hard-coded dependencies. |

---

## Data Structures Used

| Structure | Usage |
|----------|-------|
| `HashMap<Product, Integer>` | Maps products in the cart to their quantities — fast lookup, clear association |
| `ArrayList<Product>` | Used for storing and displaying shippable products |
| `LocalDate` | Used to handle expiry date validation clearly and natively |

---

## 🧪 Sample Flow (From `main()`)

```java
c1.addProduct(cheese, 6);
c1.addProduct(tv, 1);
c1.addProduct(mobile, 2);
c1.checkout();

