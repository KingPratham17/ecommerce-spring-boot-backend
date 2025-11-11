# 🛒 E-Commerce Backend System (Spring Boot)

This is a **production-grade backend system** for a complete e-commerce platform built with **Java, Spring Boot, Spring Security (JWT), and MySQL**.  
The system manages users, products, orders, payments, and inventory, exposing a comprehensive **RESTful API**.

---

## 🚀 Project Overview

This backend powers all online shopping operations, including:

- Product listing  
- User registration and authentication  
- Shopping cart management  
- Order placement and tracking  
- Payment simulation  

It follows a **layered architecture** (`Controller → Service → Repository`) for a clean, scalable, and maintainable codebase.

---

## 💡 Core Features

### 👤 User Management
- User registration and **JWT-based login**
- **Role-based access control**: `ROLE_ADMIN` and `ROLE_CUSTOMER`
- Admin-only access for managing users and products

### 🛍️ Product Management
- **Admin:**
  - Full CRUD operations (Create, Read, Update, Delete)
- **Customer:**
  - Publicly viewable product listings
  - Pagination and filtering support

### 🛒 Shopping Cart
- Persistent, per-user shopping cart  
- Add/remove products and update quantities  

### 📦 Order Management
- Convert cart items into a finalized order  
- Track order status (`PLACED`, `SHIPPED`, `DELIVERED`)  
- View order history  

### 🏪 Inventory Management
- Automatically reduces product stock after an order  
- Prevents ordering of out-of-stock items  

---

## 🧰 Technical Stack

| Component | Technology |
|------------|-------------|
| **Language** | Java 17+ |
| **Framework** | Spring Boot 3+ |
| **Security** | Spring Security 6+ (with JWT) |
| **Data Layer** | Spring Data JPA / Hibernate |
| **Database** | MySQL |
| **Build Tool** | Maven |
| **API Architecture** | RESTful API |

---

## ⚙️ How to Run Locally

### 🧩 Prerequisites
- Java 17+
- Apache Maven
- MySQL Server
- Git
- REST client (e.g., Postman)

---

### 🪜 Setup & Configuration

#### 1️⃣ Clone the Repository
```bash
git clone https://github.com/KingPratham17/ecommerce-spring-boot-backend.git
cd ecommerce-spring-boot-backend

2️⃣ Create a MySQL Database
CREATE DATABASE ecommerce_db;

3️⃣ Configure Application Properties

Edit the file:
src/main/resources/application.properties

# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db
spring.datasource.username=root
spring.datasource.password=your-mysql-password

# Hibernate
spring.jpa.hibernate.ddl-auto=update

# JWT Secret Key (optional)
# jwt.secret.key=your-very-strong-secret-key

4️⃣ Build and Run the Application
mvn clean install
mvn spring-boot:run

✅ Application is Ready

The backend will start and connect to your MySQL database.
Access the API at:
👉 http://localhost:8085

🧪 Testing with Postman (API Endpoints)
🚨 Critical First Step: Create an Admin User

Register a user
POST /api/auth/register
→ This user will have ROLE_CUSTOMER by default.

Promote to Admin (manual step)
Log in to MySQL and update the user's role:

UPDATE users SET role = 'ROLE_ADMIN' WHERE email = 'your-email@example.com';


Login as Admin
POST /api/auth/login
→ Get your JWT token and use it in Authorization headers.

🔐 Authentication Endpoints
Method	Endpoint	Access	Description
POST	/api/auth/register	Public	Register a new user (ROLE_CUSTOMER by default)
POST	/api/auth/login	Public	Login and get a JWT token
🧾 Product Endpoints
🔸 Admin (Requires ROLE_ADMIN)
Method	Endpoint	Description
POST	/api/products	Create a new product
PUT	/api/products/{id}	Update a product
DELETE	/api/products/{id}	Delete a product
🔹 Public
Method	Endpoint	Description
GET	/api/products	List all products (with pagination/filtering)
GET	/api/products/{id}	Get product details by ID
🛒 Cart Endpoints (Customer Only)
Method	Endpoint	Description
POST	/api/cart/add?productId={id}&quantity={qty}	Add an item to the cart
GET	/api/cart	View all items in the cart
DELETE	/api/cart/remove/{cartItemId}	Remove an item from the cart
📦 Order Endpoints (Customer Only)
Method	Endpoint	Description
POST	/api/orders/checkout	Convert cart items to an order
GET	/api/orders	View user's order history
🧠 Architecture Overview
Controller → Service → Repository → Database


Controller: Handles API requests and responses.

Service: Contains business logic.

Repository: Handles database operations using Spring Data JPA.

🧑‍💻 Contributing

Contributions are welcome!
If you'd like to improve or add new features:

Fork this repository

Create a new branch (feature/your-feature)

Commit your changes

Submit a pull request 🎉
