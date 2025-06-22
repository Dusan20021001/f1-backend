# Formula 1 Spring Boot Backend

## Overview
Simple Spring Boot REST API to manage **Teams** and **Drivers** in Formula 1.

- **Relational database** via Spring Data JPA  
- Two related tables: `teams` (1) ↔️ `drivers` (many)  
- Full CRUD endpoints for both entities

## Quick Start

```bash
# Prerequisites: Java 17+, Maven 3.9+
mvn spring-boot:run
```

The API will start at **http://localhost:8080**.

Available endpoints:

| Method | Endpoint              | Description               |
|--------|-----------------------|---------------------------|
| GET    | /api/teams            | List teams                |
| GET    | /api/teams/{id}       | Get team by id            |
| POST   | /api/teams            | Create team               |
| PUT    | /api/teams/{id}       | Update team               |
| DELETE | /api/teams/{id}       | Delete team               |
| GET    | /api/drivers          | List drivers              |
| GET    | /api/drivers/{id}     | Get driver by id          |
| POST   | /api/drivers          | Create driver             |
| PUT    | /api/drivers/{id}     | Update driver             |
| DELETE | /api/drivers/{id}     | Delete driver             |
| POST   | /api/drivers/{driverId}/team/{teamId} | Assign driver to team |

## Database

- Uses **H2 in‑memory** DB by default. Access H2 console at http://localhost:8080/h2-console  
- Switch to MySQL/MariaDB by commenting/uncommenting settings in `src/main/resources/application.properties`.

## Build

```bash
mvn clean package
```

The resulting JAR is in `target/`.

## Notes
- Lombok is included; enable Lombok plugin in your IDE for best experience.
