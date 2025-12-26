# DataRecord Backend

## Overview
DataRecord is a Spring Boot backend that loads data from a CSV file into a MySQL database (hosted on Aiven) and exposes REST APIs for frontend or API clients. The backend is containerized using Docker and deployed on Render.

---

## 🧱 Tech Stack & Tools

**Language & Framework**
- Java 22
- Spring Boot 3
- Spring Web
- Spring Data JPA
- Hibernate

**Database**
- MySQL (Cloud – Aiven)
- MySQL Workbench (Client)

**DevOps / Hosting**
- Docker
- GitHub
- Render Web Service
- Postman (API Testing)

---

## 📂 Important Files

### 1️⃣ DataRecordApplication.java
- Bootstraps Spring Boot application  
- Enables component scanning  
- Triggers startup processes like DB initialization  

### 2️⃣ DataController.java
- Handles API endpoints under `/data`  
- Accepts inputs using `@PathVariable`  
- Returns JSON responses  
**Example:** `GET /data/all/accounts`

### 3️⃣ ServiceDto.java
- Service interface for business logic  
- Keeps Controller independent  
- Improves maintainability  

### 4️⃣ DataService.java
- Implements `ServiceDto`  
- Contains filtering and business logic  
- Calls `DataRepository` for DB access  

### 5️⃣ DataRepository.java
- Extends `JpaRepository<Data, Long>`  
- Uses JPQL for queries  
- Handles CRUD operations  

### 6️⃣ Data.java
- Entity mapping to MySQL table  
- Uses `@Entity`, `@Id`, `@GeneratedValue`  
- Matches CSV columns exactly  

### 7️⃣ ServerPortCustomizer.java
- Handles dynamic ports (`PORT` for Render, `X_ZOHO_CATALYST_LISTEN_PORT` for Catalyst)  
- Defaults to `2222` for local  
- Ensures cloud deployments don’t crash  

### 8️⃣ application.properties
```properties
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=${PORT}
No hardcoded DB or localhost

Works with cloud and local environments

9️⃣ Dockerfile
dockerfile
Copy code
FROM eclipse-temurin:22-jdk-alpine
WORKDIR /app
COPY . .
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests
EXPOSE 8080
ENTRYPOINT java -jar target/*.jar
Builds JAR inside container

Cloud-ready for Render

🗄️ Database Setup
1️⃣ Aiven MySQL
Cloud-hosted MySQL with SSL security

Environment variables used in Render:

ini
Copy code
DB_URL=jdbc:mysql://aiven-host:port/defaultdb
DB_USERNAME=avnadmin
DB_PASSWORD=******
PORT=auto by Render
2️⃣ MySQL Workbench
Connect using SSL mode REQUIRED

Verify tables & data manually

☁️ Deployment Flow
css
Copy code
Code → GitHub → Render Web Service → Aiven MySQL
GitHub stores backend code

Render auto-deploys on git push

Environment variables injected automatically

🌐 Live API Base URL
arduino
Copy code
https://datarecord-backend.onrender.com
Example Endpoints

GET /data/all/accounts

GET /data/id/{id}

GET /data/endYear/{year}

GET /data/topics/{topic}

GET /data/sector/{sector}

GET /data/region/{region}

GET /data/pest/{pest}

GET /data/source/{source}

GET /data/swot/{swot}

GET /data/country/{country}

GET /data/city/{city}

✅ Achievements
Dockerized Spring Boot backend

Cloud MySQL with SSL

Zero hardcoded secrets

Auto-deploy via GitHub → Render

Production-ready architecture

🧠 Quick Memory Cheat
Controller → Service → Repository → MySQL

PORT → ServerPortCustomizer

GitHub → Render → Live API

Aiven → MySQL Workbench → DB Verification
