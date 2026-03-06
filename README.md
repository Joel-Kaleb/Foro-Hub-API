# Foro-Hub-API

A robust and secure backend REST API for a forum platform, developed as part of the **Oracle Next Education (ONE)** program in collaboration with **Alura Latino**. This project manages forum topics, user authentication, and business rules using modern software engineering practices.



---

## 🚀 Features

* **User Authentication:** Secure login system using **Spring Security** and **JWT (JSON Web Tokens)**.
* **Topic Management (CRUD):** * Register new topics with automated validation.
    * List all active topics with **pagination** and sorting.
    * Retrieve detailed information about a specific topic.
    * Update topic data (title, message, status, and course).
    * **Logical Delete:** Topics are deactivated (`active = false`) instead of being physically removed from the database to preserve data integrity.
* **Advanced Validations:**
    * Prevention of duplicate topics (same title and message).
    * Integrity checks for Courses and Users.
    * Usage of the **Strategy Pattern** to keep validation logic clean and scalable.

---

## 🛠️ Tech Stack

* **Java 25:** Leveraging the latest features of the language.
* **Spring Boot 3.x:** Core framework for the API.
* **Spring Data JPA:** For database persistence.
* **PostgreSQL:** Production-ready relational database.
* **Flyway:** Database migration management.
* **Spring Security & JWT (Auth0):** For stateless authentication and authorization.
* **Lombok:** To reduce boilerplate code.
* **Maven:** Project management and build tool.

---

## 📋 Prerequisites

Before running the project, ensure you have:
* **JDK 25** installed.
* **PostgreSQL** running on port `5432`.
* An IDE (IntelliJ IDEA, Eclipse, or VS Code).

---

## ⚙️ Configuration

Set the following environment variables or update your `application.properties` file:

| Variable | Description | Default Value |
| :--- | :--- | :--- |
| `DB_PORT` | PostgreSQL Port | `5432` |
| `DB_USER` | Database Username | `your_user` |
| `DB_PASSWORD` | Database Password | `your_password` |
| `JWT_SECRET` | Secret key for JWT signing | `your_secret_key` |

---

## 🚦 API Endpoints

### 🔐 Authentication
* `POST /login`: Authenticates a user and returns a JWT token.

### 📝 Topics (Requires Authentication)
* `POST /topics`: Register a new topic.
* `GET /topics`: List all active topics (paginated).
* `GET /topics/{id}`: Show details of a specific topic.
* `PUT /topics/{id}`: Update topic information.
* `DELETE /topics/{id}`: Perform a logical delete on a topic.

---

## 🏗️ Architecture Note

This project follows a **Layered Architecture**:
1.  **Controller Layer:** Handles HTTP requests and responses.
2.  **Service Layer:** Orchestrates business logic and validations.
3.  **Domain Layer:** Contains Entities (Rich Domain Model) and Repositories.
4.  **Infrastructure Layer:** Handles security (JWT), filters, and global exception handling.

---

## 📈 Roadmap (Future Improvements)

While the MVP is fully functional, the following features are planned for future releases:
* [ ] Full CRUD for **Users**, **Courses**, and **Answers**.
* [ ] Interactive API documentation with **SpringDoc/Swagger**.
* [ ] Integration Testing for critical business flows.
* [ ] Role-based access control (Admin vs. User).

---

## ✍️ Author

Developed by **Joel Kaleb**
* GitHub: [@Joel-Kaleb](https://github.com/Joel-Kaleb)