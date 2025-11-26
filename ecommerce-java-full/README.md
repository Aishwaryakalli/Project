# Online Shopping - Spring Boot (ecommerce-java)

## Overview
This project is a resume-ready Online Shopping web application backend built with Java and Spring Boot.
It includes a simple static frontend page for demoing product listing.

## Run locally
1. Install Java 17+ and MySQL.
2. Create database `onlineshop` or let JPA create tables automatically.
3. Edit `src/main/resources/application.yml` and set your MySQL username/password.
4. Build & run:
   mvn clean package
   mvn spring-boot:run
5. Open http://localhost:8080/index.html to see the demo page.

## Notes
- Basic HTTP Basic authentication is enabled for protected endpoints (admin); create users via /api/auth/register.
- For demo admin actions, use an account with role ADMIN (change in DB or register then update role).

