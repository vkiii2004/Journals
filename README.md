# Journal App

Small Spring Boot monolith for a simple journal application (Java + Maven).

## Overview

This project is a basic Spring Boot application that provides user and journal-entry management via controllers, entities, repositories, and services. It includes a Maven wrapper so you can build and run without installing Maven system-wide.

## Prerequisites

- Java 11 or newer installed
- Git (optional)

## Build

On Windows (from project root):

```powershell
./mvnw.cmd clean package
```

On macOS / Linux:

```bash
./mvnw clean package
```

## Run

Run with Maven:

```bash
./mvnw spring-boot:run
```

Or run the packaged jar (after `package`):

```bash
java -jar target/*.jar
```

## Tests

Run unit tests with:

```bash
./mvnw test
```

## Configuration

Application properties are in `src/main/resources/application.properties`. Update database or other settings there.

## Project layout (key folders)

- `src/main/java/com/project/journalApp/controller` : Spring MVC controllers
- `src/main/java/com/project/journalApp/entity` : JPA entities (`User`, `JournalEntry`)
- `src/main/java/com/project/journalApp/repository` : Spring Data repositories
- `src/main/java/com/project/journalApp/service` : Service layer implementations

## Notes

- This repo contains a Maven wrapper (`mvnw` / `mvnw.cmd`) so you can build with the included scripts.
- If you want, I can add example environment variables, Dockerfile, or run instructions for a specific database.

---

Created for quick onboarding. Enjoy!
