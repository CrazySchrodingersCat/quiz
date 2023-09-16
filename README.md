# QUIZ. Iplementation of Open Travia Database

A full-stack web application with a Java backend and an Angular frontend for answering trivia questions.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
  - [Building the Application](#building-the-application)
  - [Running the Application](#running-the-application)

## Prerequisites

Before you begin, ensure you have met the following requirements:
- **Backend**:
  - Java Development Kit (JDK) 11 or higher
  - Apache Maven (for building)
  - Git (optional but recommended for version control)
  - An Integrated Development Environment (IDE) like IntelliJ IDEA or Eclipse (optional but recommended)
 
- **Frontend**:
  - Node.js and npm (Node Package Manager)

## Getting Started

### Building the Application

1. Clone the repository (if you haven't already):

   ```bash
   git clone https://github.com/CrazySchrodingersCat/quiz.git
   
2. Open the project in your preferred IDE if you are using one.

Backend Setup

4. Navigate to backend directory backend/quiz4quad and build the application using Maven:

     ```bash
     mvn clean install

Frontend Setup

5. Navigate to frontend directory (or open it in VS Studio Code en use the integrated terminal)
3. Install frontend dependencies:

    ```bash
    npm install
    
### Running the Application

Backend

After building the application, you can run it using Maven:

     ```bash
     mvn spring-boot:run

Alternatively, you can run the JAR file generated during the build:

     ```bash
     java -jar target/your-application-1.0.0.jar

Once the application is running, you can access it in your web browser at http://localhost:8080.

Frontend

Navigate to frontend directory and start the frontend development server:

     ```bash
     ng serve

The frontend development server should be running at http://localhost:4200.

Open your web browser and navigate to http://localhost:4200 to access the frontend.
