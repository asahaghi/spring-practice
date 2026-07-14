# Task Manager REST API

## Features
- Create a task
- Get all tasks
- Get a task by ID
- Update a task
- Delete a task

## Technologies
- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven

## Database
Create a MySQL database named `task_manager` and run the provided SQL script.

## Configuration
Edit `application.properties`:

spring.datasource.url=...
spring.datasource.username=...
spring.datasource.password=...

## Run
1. Clone the repository
2. Open it in IntelliJ IDEA
3. Run `TaskManagerApplication`
4. Open Postman

## API Endpoints

GET    /api/tasks
GET    /api/tasks/{id}
POST   /api/tasks
PUT    /api/tasks
DELETE /api/tasks/{id}
