# 🛍️ E-Commerce Backend System (Spring Boot)

A **production-grade backend system** for a complete e-commerce platform built with Java, Spring Boot, Spring Security (JWT), and MySQL. It manages users, products, orders, payments, and inventory while exposing a comprehensive RESTful API.

---

## 📖 Project Overview

This backend powers all online shopping operations including product listing, user registration, shopping cart management, order placement, and payment simulation.

It follows a **layered architecture (Controller → Service → Repository)** for clean, scalable, and maintainable code.

---

## 🚀 Core Features

### 👤 User Management
- User registration and JWT-based login
- Role-based access control: `ROLE_ADMIN` and `ROLE_CUSTOMER`
- Admin-only access for managing users and products

### 🛍️ Product Management
- **Admin:** Full CRUD operations (Create, Read, Update, Delete)
- **Customer:** Publicly viewable product listings with pagination and filtering

### 🛒 Shopping Cart
- Persistent, per-user shopping cart
- Add/remove products and update item quantities

### 📦 Order Management
- Convert a cart into a finalized order
- Stores order history and tracks status (`PLACED`, `SHIPPED`, `DELIVERED`)

### 📊 Inventory Management
- Automatically reduces product stock after a successful order
- Prevents ordering of out-of-stock items

---

## 🧱 Technical Stack

| Component      | Technology                     |
|----------------|--------------------------------|
| Language       | Java 17+                       |
| Framework      | Spring Boot 3+                 |
| Security       | Spring Security 6+ (with JWT)  |
| Data Layer     | Spring Data JPA / Hibernate    |
| Database       | MySQL                          |
| Build Tool     | Maven                          |
| API            | RESTful API                    |

---

## ⚙️ How to Run Locally

### 🔧 Prerequisites
- Java 17+ (JDK)
- Apache Maven
- MySQL Server
- Git (for cloning)
- A REST API client (like Postman)

---

### 🪜 Setup & Configuration

#### 1. Clone the Repository
```
git clone https://github.com/your-username/your-repository-name.git
cd your-repository-name
```

#### 2. Create MySQL Database
Connect to MySQL and run:
```
CREATE DATABASE ecommerce_db;
```

#### 3. Configure `application.properties`
Edit `src/main/resources/application.properties`:

```
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db
spring.datasource.username=root
spring.datasource.password=your-mysql-password

# Hibernate
spring.jpa.hibernate.ddl-auto=update

# JWT Secret Key (optional)
# jwt.secret.key=your-very-strong-secret-key
```

🧩 **Tip:** For production, keep secrets out of source control using environment variables or a vault.

#### 4. Build & Run
```
# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

The app will start and connect to MySQL.  
Default API base URL: `http://localhost:8085`

---

## 🧪 Testing with Postman

### ⚠️ Critical: Create an Admin

Public registration only creates users with `ROLE_CUSTOMER`.  
You must manually promote your first admin.

#### 1. Register a User
`POST /api/auth/register`  
Send JSON body:
```
{
  "name": "John Doe",
  "email": "john@example.com",
  "password": "password123"
}
```

#### 2. Promote User (Manual DB Step)
Update the user's role in MySQL:
```
UPDATE users SET role = 'ROLE_ADMIN' WHERE email = 'john@example.com';
```

#### 3. Login as Admin
`POST /api/auth/login`  
Send the admin's email and password.

Copy the token from the response and include it in all protected requests:

```
Authorization: Bearer <token>
```

---

## 🌐 API Endpoints

### 🔐 Authentication Endpoints

| Method | Endpoint            | Access | Description |
|---------|--------------------|---------|--------------|
| POST    | /api/auth/register | Public  | Register a new user (defaults to ROLE_CUSTOMER) |
| POST    | /api/auth/login    | Public  | Login and receive a JWT token |

---

### 🧾 Product Endpoints

**Admin (Requires ROLE_ADMIN)**

| Method | Endpoint              | Description |
|---------|----------------------|--------------|
| POST    | /api/products        | Create a new product |
| PUT     | /api/products/{id}   | Update an existing product |
| DELETE  | /api/products/{id}   | Delete a product |

**Public Access**

| Method | Endpoint              | Description |
|---------|----------------------|--------------|
| GET     | /api/products        | List all products (with pagination/filtering) |
| GET     | /api/products/{id}   | Get details for a single product |

---

### 🛒 Cart Endpoints (Requires ROLE_CUSTOMER)

| Method | Endpoint                                             | Description |
|---------|-----------------------------------------------------|--------------|
| POST    | /api/cart/add?productId={id}&quantity={qty}         | Add an item to the cart |
| GET     | /api/cart                                            | View all items in the cart |
| DELETE  | /api/cart/remove/{cartItemId}                        | Remove an item from the cart |

---

### 📦 Order Endpoints (Requires ROLE_CUSTOMER)

| Method | Endpoint           | Description |
|---------|-------------------|--------------|
| POST    | /api/orders/checkout | Convert the current cart to a new order |
| GET     | /api/orders          | View the logged-in user's order history |

---

## 🧠 Architecture Overview

**Controller → Service → Repository → Database**

- **Controller:** Accepts HTTP requests and returns responses.  
- **Service:** Contains all business logic, transaction management, and validations.  
- **Repository:** Handles data access using Spring Data JPA.

---

## 🤝 Contributing

Contributions are welcome!  
Recommended workflow:

1. Fork the repository  
2. Create a new branch: `feature/your-feature-name`  
3. Commit your changes and push the branch  
4. Open a Pull Request  

Please follow the existing code style, add tests where applicable, and document any new endpoints.

---

## 📜 License

This project is licensed under the **MIT License**.

---

## 🙏 Acknowledgements

- Spring Boot & Spring Security documentation  
- Hibernate ORM  
- MySQL

---


