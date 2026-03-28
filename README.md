# Digital Notes Organizer REST API

## Project Overview

Digital Notes Organizer is a Spring Boot based REST API that allows users to create, organize, and manage their personal notes.
The system helps users store notes in folders and categorize them using tags so that the notes are easier to manage and find later.

This project demonstrates the use of Spring Boot, REST APIs, Hibernate (JPA), and role-based security.
All APIs can be tested using Postman.

## Features

* User registration and login
* Create, update, view, and delete notes
* Organize notes into folders
* Add tags to notes for better categorization
* Role-based access (Admin and User)
* Password encryption using Spring Security

## Technologies Used

* Java
* Spring Boot
* Spring Data JPA (Hibernate)
* Spring Security
* MySQL / H2 Database
* Maven
* Postman (for API testing)

## Project Structure

The project follows a layered architecture.

Controller → Handles API requests
Service → Contains business logic
Repository → Handles database operations
Entity → Represents database tables

## Main Entities

User – stores user information such as name, email, password, and role.
Note – stores note content created by users.
Folder – used to organize notes.
Tag – used to categorize notes.

## Entity Relationships

* One User can create many Notes.
* One Folder can contain many Notes.
* Notes can have multiple Tags.

## Example APIs

Create User
POST /api/auth/register

Login User
POST /api/auth/login

Create Note
POST /api/notes

Get All Notes
GET /api/notes

Update Note
PUT /api/notes/{id}

Delete Note
DELETE /api/notes/{id}

## Security

The application uses Spring Security for authentication and authorization.
Passwords are encoded using BCryptPasswordEncoder.
Two roles are used in the system:

ADMIN – can manage folders and monitor the system
USER – can create and manage personal notes

## How to Run the Project

1. Clone the repository from GitHub.
2. Open the project in an IDE such as IntelliJ IDEA or VS Code.
3. Configure the database in the application.properties file.
4. Run the Spring Boot application.
5. Use Postman to test the REST APIs.

## Purpose of the Project

The purpose of this project is to demonstrate how to build a RESTful backend application using Spring Boot with proper architecture, entity relationships, CRUD operations, and role-based security.
