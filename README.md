
# Task_Management_Web_Application-
 This is a full-stack task management application built with Spring Boot for the backend and React for the frontend.
 
## Project Overview
This application allows users to manage tasks. Users can register, log in, view tasks, add new tasks, update existing tasks, and delete tasks.

## Technologies Used

- Backend:
  - Java
  - Spring Boot
  - Spring Data JPA
  - MySQL Database

- Frontend:
  - JavaScript
  - React
  - Axios
  - React Router


## Project Setup

### Backend (Spring Boot)

1. Clone the backend repository:
   

2. Navigate to the project directory:
   
3. Start the Spring Boot server:

   * mvn spring-boot:run *
   

### Frontend (React)

1. Clone the frontend repository:
   
   
2. Navigate to the project directory:
   
   3. Install dependencies:
  
    i. npm install
   

4. Start the React development server:

   i. npm start
   

## API Endpoints

### Authentication

- **Register User**
  - Endpoint: `POST /auth/register`
  - Request Body:
    
    {
      "username": "Robart",
      "password": "Robart@123"
    }
  
  - Response Example:
    {
      "id": 1,
      "username": "Robart"
    }
    

- **Login User**
  - Endpoint: `POST /auth/login`
  - Request Body:
    {
      "username": "Robart",
      "password": "Robart@123"
    }
    
  - Response Example:
   
    {
      "id": 1,
      "username": "Robart"
    }
    

### Task Management

- **Get All Tasks**
  - Endpoint: `GET /tasks`
  - Response Example:
        
      {
        "id": 1,
        "title": "Task 1",
        "description": "Description of Task 1",
        "completed": false
      },
      {
        "id": 2,
        "title": "Task 2",
        "description": "Description of Task 2",
        "completed": true
      }
    
    

- **Create Task**
  - Endpoint: `POST /tasks`
  - Request Body:
    {
      "title": "New Task",
      "description": "Description of New Task",
      "completed": false
    }
    
  - Response Example:
    {
      "id": 3,
      "title": "New Task",
      "description": "Description of New Task",
      "completed": false
    }
    

- **Update Task**
  - Endpoint: `PUT /tasks/{id}`
  - Request Body:
    {
      "title": "Updated Task",
      "description": "Updated description",
      "completed": true
    }
    
  - Response Example:
    {
      "id": 3,
      "title": "Updated Task",
      "description": "Updated description",
      "completed": true
    }
   

- **Delete Task**
  - Endpoint: `DELETE /tasks/{id}`
  - No request body required.
  - Response Status: `204 No Content`

## Database Configuration
Make sure MySQL is running locally.

Update the `application.properties` file in the backend project with your database configuration:

properties
spring.datasource.url=jdbc:mysql://localhost:3306/task_manager_db
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password


## Testing Endpoints
Use tools like Postman  to test each API endpoint with sample requests and observe the responses.

## Credentials
Provide credentials for database access and API usage as necessary.





