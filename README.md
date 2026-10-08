# Personal Finance Management Platform

A Java web-based personal finance management platform built with:
- Java 17
- Jakarta Servlets
- JSP
- MySQL
- JDBC
- HTML/CSS/JavaScript
- Apache Tomcat 10.1+

## Features

### User
- Dashboard
- Expense tracking
- Budget management
- Financial goals
- Progress summaries

### Admin
- User management
- Security settings
- System settings

### Java rubric coverage
- OOP: inheritance, polymorphism, interfaces, exception handling
- Collections & Generics
- Multithreading & synchronization
- DAO/database operation classes
- JDBC/MySQL connectivity

## Run
1. Create the MySQL database using `sql/personal_finance.sql`.
2. Edit `src/main/java/com/finance/dao/DatabaseConnection.java`.
3. Install Maven and JDK 17.
4. Install Apache Tomcat 10.1+.
5. Run `mvn clean package`.
6. Copy `target/PersonalFinanceManagement.war` into Tomcat's `webapps` folder.
7. Start Tomcat.
8. Open `http://localhost:8080/PersonalFinanceManagement/`

Default demo login:
- User: satyam@gmail.com
- Password: 1234
- Admin: admin@finance.com
- Password: admin123
