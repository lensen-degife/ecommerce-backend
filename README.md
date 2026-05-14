# E-Commerce Full Stack Application

## Backend

A powerful **Spring Boot REST API** for an E-Commerce platform.

## 📖 Project Overview

This repository contains the **backend** for a complete full-stack e-commerce application. It provides RESTful APIs for product management, categories, shopping cart functionality, image handling, and search features.

It works together with the frontend application:

**Frontend Repository:**
[https://github.com/lensen-degife/ecommerce-frontend](https://github.com/lensen-degife/ecommerce-frontend)

---

## ✨ Features

* Product CRUD operations
* Category management
* Product search and filtering
* Image upload support
* Shopping Cart API
* RESTful architecture
* Database integration with MySQL/H2

---

## 🛠️ Tech Stack

* Java 17
* Spring Boot 3
* Spring Data JPA
* Maven
* MySQL / H2 Database

---

## 🚀 Running the Full Stack Application

### Step 1: Clone both repositories

```bash
git clone https://github.com/lensen-degife/ecommerce-backend.git
git clone https://github.com/lensen-degife/ecommerce-frontend.git
```

### Step 2: Run the Backend

```bash
cd ecommerce-backend
./mvnw spring-boot:run
```

Backend runs at:

```text
http://localhost:8080
```

### Step 3: Run the Frontend

Open a new terminal and run:

```bash
cd ecommerce-frontend
npm install
npm start
```

Frontend runs at:

```text
http://localhost:3000
```

> Important: Make sure the backend server is running before starting the frontend.

---

## 📡 API Base URL

```text
http://localhost:8080
```

---

## 🔗 Related Repository

* Frontend: [https://github.com/lensen-degife/ecommerce-frontend](https://github.com/lensen-degife/ecommerce-frontend)

---

## 📁 Project Structure

```text
src/main/java/
├── controller/
├── model/
├── repository/
├── service/
└── EcomProjApplication.java
```

---

## 🗄️ Database Configuration

Update your database settings in:

```text
src/main/resources/application.properties
```

Example configuration:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 📌 Notes

* Use H2 for quick local development/testing.
* Use MySQL for production-like environments.
* Ensure required dependencies are installed before running the application.

---

## 🤝 Contributing

Contributions, suggestions, and improvements are welcome.

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to your branch
5. Open a Pull Request

---

## 📄 License

Add your preferred license information here (MIT, Apache 2.0, etc.).
