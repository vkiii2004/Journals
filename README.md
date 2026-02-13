Journal Management Application
Tech Stack
Java 17
Spring Boot
Spring Security
Spring Data JPA (Hibernate)
MySQL
Maven
Features
User registration and authentication
Role-based access control (ADMIN / USER)
CRUD operations on journal entries
Secure REST APIs
Global exception handling
DTO-based request/response handling
Security Flow
Authentication handled using Spring Security
User details loaded via UserDetailsServiceImpl
Passwords stored using BCrypt
Role-based endpoint access:
PUBLIC APIs → no authentication
USER APIs → authenticated users
ADMIN APIs → admin only
Sample APIs
Create Journal Entry (USER)
POST /api/journal Authorization: Bearer { "title": "My Day", "content": "Learned Spring Security" }

shell Copy code

Get All Entries
GET /api/journal

shell Copy code

Health Check
GET /health

markdown Copy code

Database Schema
User

id (PK)
username
password
role
JournalEntry

id (PK)
title
content
user_id (FK)
