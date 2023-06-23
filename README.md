# Simple Expense Tracker Application

The Simple CRM Application is a basic customer relationship management system designed to manage employee records. It provides functionalities to create, retrieve, update, and delete employee information.

On top of that it is used to track, and approve of expenses.

## Features

- Create a new employee record by providing their details such as first name, last name, email, contact, and department.
- Retrieve a specific employee's information by their ID.
- Retrieve a list of all employees in the system.
- Update an existing employee's information, including their first name, last name, email, contact, and department.
- Delete an employee from the system.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL (or any other compatible relational database)
- Maven

## Getting Started

Follow these instructions to get a local copy of the project up and running on your machine.

### Prerequisites

- Java Development Kit (JDK) installed
- Maven installed
- PostgreSQL (or any other compatible relational database) installed and running

### Installation

1. Clone the repository:

   ```bash
   git clone <repository-url>
Navigate to the project directory:

bash
Copy code
cd simple-crm
Build the project using Maven:

bash
Copy code
mvn clean install
Run the application:

bash
Copy code
mvn spring-boot:run
The application should now be accessible at http://localhost:8080.

Usage
You can interact with the application using a tool like cURL or Postman to send HTTP requests to the exposed endpoints.

Create Employee
Send a POST request to http://localhost:8080/employees with the following JSON payload:

json
Copy code
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "johndoe@example.com",
  "contact": "1234567890",
  "department": "Operations",
  "loginId": "123456"
}
Retrieve All Employees
Send a GET request to http://localhost:8080/employees to retrieve a list of all employees.

Retrieve Employee by ID
Send a GET request to http://localhost:8080/employees/{id} where {id} is the ID of the employee you want to retrieve.

Update Employee
Send a PUT request to http://localhost:8080/employees/{id} with the following JSON payload to update an employee's information:

json
Copy code
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "johndoe@example.com",
  "contact": "1234567890",
  "department": "Operations",
  "loginId": "123456"
}
Delete Employee
Send a DELETE request to http://localhost:8080/employees/{id} where {id} is the ID of the employee you want to delete.

Contributing
Contributions are welcome! If you have any ideas, suggestions, or improvements, feel free to open an issue or submit a pull request.

License
This project is licensed under the MIT License.
