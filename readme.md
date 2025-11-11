E-Commerce Backend System (Spring Boot)

This is a production-grade backend system for a complete e-commerce platform. It is built with Java, Spring Boot, Spring Security (JWT), and MySQL. The system manages users, products, orders, payments, and inventory, exposing a comprehensive RESTful API.

Project Overview

This backend powers all online shopping operations, including product listing, user registration, shopping cart management, order placement, and payment simulation. It follows a layered architecture (Controller-Service-Repository) for a clean, scalable, and maintainable codebase.

Core Features

User Management:

User registration and JWT-based login.

Role-based access control: ROLE_ADMIN and ROLE_CUSTOMER.

Admin-only access for managing users and products.

Product Management:

Admin: Full CRUD operations (Create, Read, Update, Delete) for products.

Customer: Publicly viewable product listings with pagination and filtering.

Shopping Cart:

Persistent, per-user shopping cart.

Add/remove products and update item quantities.

Order Management:

Convert a cart into a finalized order.

Stores order history and tracks order status (e.g., PLACED, SHIPPED, DELIVERED).

Inventory Management:

Automatically reduces product stock after a successful order.

Prevents ordering of out-of-stock items.

Technical Stack

Component

Technology

Language

Java 17+

Framework

Spring Boot 3+

Security

Spring Security 6+ (with JWT)

Data

Spring Data JPA / Hibernate

Database

MySQL

Build Tool

Maven

API

RESTful API

How to Run Locally

Prerequisites

Java 17+ (JDK)

Apache Maven

MySQL Server

Git (for cloning)

A REST API client (like Postman)

Setup & Configuration

Clone the Repository:

git clone [https://github.com/your-username/your-repository-name.git](https://github.com/your-username/your-repository-name.git)
cd your-repository-name


Create MySQL Database:

Log in to your MySQL server.

Create a new database for this project (e.g., ecommerce_db).

CREATE DATABASE ecommerce_db;


Configure Application Properties:

Open the src/main/resources/application.properties file.

Update the spring.datasource properties to match your local MySQL setup.

# Example Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db
spring.datasource.username=root
spring.datasource.password=your-mysql-password

# This line tells Hibernate to create/update tables automatically
spring.jpa.hibernate.ddl-auto=update

# (Optional) Set your JWT secret key
# jwt.secret.key=your-very-strong-secret-key


Build and Run the Application:

Use Maven to build the project:

mvn clean install


Run the application:

mvn spring-boot:run


Application is Ready!

The backend will start, connected to your database.

The API will be available at http://localhost:8085 (or your configured port).

Testing with Postman (API Endpoints)

🚨 Critical First Step: Creating an Admin

This system has secure registration and does not allow public admin sign-ups.

Register a User: POST /api/auth/register with a name, email, and password. This user will be a ROLE_CUSTOMER.

Manually Promote User: Go into your MySQL database users table and manually change the role for this new user from ROLE_CUSTOMER to ROLE_ADMIN.

Login as Admin: POST /api/auth/login with the admin's credentials to get your Admin JWT Token.

Authentication Endpoints

POST /api/auth/register - (Public) Register a new user (defaults to ROLE_CUSTOMER).

POST /api/auth/login - (Public) Log in to get a JWT token.

Product Endpoints (Admin)

Requires Admin Token

POST /api/products - Create a new product.

PUT /api/products/{id} - Update an existing product.

DELETE /api/products/{id} - Delete a product.

Product Endpoints (Public)

GET /api/products - Get a list of all products.

GET /api/products/{id} - Get details for a single product.

Cart Endpoints (Customer)

Requires Customer Token

POST /api/cart/add?productId={id}&quantity={qty} - Add an item to the cart.

GET /api/cart - View all items in the cart.

DELETE /api/cart/remove/{cartItemId} - Remove an item from the cart.

Order Endpoints (Customer)

Requires Customer Token

POST /api/orders/checkout - Convert cart to an order.

GET /api/orders - Get the logged-in user's order history.E-Commerce Backend System (Spring Boot)

This is a production-grade backend system for a complete e-commerce platform. It is built with Java, Spring Boot, Spring Security (JWT), and MySQL. The system manages users, products, orders, payments, and inventory, exposing a comprehensive RESTful API.

Project Overview

This backend powers all online shopping operations, including product listing, user registration, shopping cart management, order placement, and payment simulation. It follows a layered architecture (Controller-Service-Repository) for a clean, scalable, and maintainable codebase.

Core Features

User Management:

User registration and JWT-based login.

Role-based access control: ROLE_ADMIN and ROLE_CUSTOMER.

Admin-only access for managing users and products.

Product Management:

Admin: Full CRUD operations (Create, Read, Update, Delete) for products.

Customer: Publicly viewable product listings with pagination and filtering.

Shopping Cart:

Persistent, per-user shopping cart.

Add/remove products and update item quantities.

Order Management:

Convert a cart into a finalized order.

Stores order history and tracks order status (e.g., PLACED, SHIPPED, DELIVERED).

Inventory Management:

Automatically reduces product stock after a successful order.

Prevents ordering of out-of-stock items.

Technical Stack

Component

Technology

Language

Java 17+

Framework

Spring Boot 3+

Security

Spring Security 6+ (with JWT)

Data

Spring Data JPA / Hibernate

Database

MySQL

Build Tool

Maven

API

RESTful API

How to Run Locally

Prerequisites

Java 17+ (JDK)

Apache Maven

MySQL Server

Git (for cloning)

A REST API client (like Postman)

Setup & Configuration

Clone the Repository:

git clone [https://github.com/your-username/your-repository-name.git](https://github.com/your-username/your-repository-name.git)
cd your-repository-name


Create MySQL Database:

Log in to your MySQL server.

Create a new database for this project (e.g., ecommerce_db).

CREATE DATABASE ecommerce_db;


Configure Application Properties:

Open the src/main/resources/application.properties file.

Update the spring.datasource properties to match your local MySQL setup.

# Example Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db
spring.datasource.username=root
spring.datasource.password=your-mysql-password

# This line tells Hibernate to create/update tables automatically
spring.jpa.hibernate.ddl-auto=update

# (Optional) Set your JWT secret key
# jwt.secret.key=your-very-strong-secret-key


Build and Run the Application:

Use Maven to build the project:

mvn clean install


Run the application:

mvn spring-boot:run


Application is Ready!

The backend will start, connected to your database.

The API will be available at http://localhost:8085 (or your configured port).

Testing with Postman (API Endpoints)

🚨 Critical First Step: Creating an Admin

This system has secure registration and does not allow public admin sign-ups.

Register a User: POST /api/auth/register with a name, email, and password. This user will be a ROLE_CUSTOMER.

Manually Promote User: Go into your MySQL database users table and manually change the role for this new user from ROLE_CUSTOMER to ROLE_ADMIN.

Login as Admin: POST /api/auth/login with the admin's credentials to get your Admin JWT Token.

Authentication Endpoints

POST /api/auth/register - (Public) Register a new user (defaults to ROLE_CUSTOMER).

POST /api/auth/login - (Public) Log in to get a JWT token.

Product Endpoints (Admin)

Requires Admin Token

POST /api/products - Create a new product.

PUT /api/products/{id} - Update an existing product.

DELETE /api/products/{id} - Delete a product.

Product Endpoints (Public)

GET /api/products - Get a list of all products.

GET /api/products/{id} - Get details for a single product.

Cart Endpoints (Customer)

Requires Customer Token

POST /api/cart/add?productId={id}&quantity={qty} - Add an item to the cart.

GET /api/cart - View all items in the cart.

DELETE /api/cart/remove/{cartItemId} - Remove an item from the cart.

Order Endpoints (Customer)

Requires Customer Token

POST /api/orders/checkout - Convert cart to an order.

GET /api/orders - Get the logged-in user's order history.