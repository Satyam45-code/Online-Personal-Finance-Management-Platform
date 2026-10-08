CREATE DATABASE IF NOT EXISTS personal_finance;
USE personal_finance;

CREATE TABLE IF NOT EXISTS users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    role VARCHAR(20) NOT NULL DEFAULT 'USER',
    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS transactions (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    category VARCHAR(60) NOT NULL,
    amount DECIMAL(12,2) NOT NULL,
    transaction_date DATE NOT NULL,
    description VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS budgets (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    category VARCHAR(60) NOT NULL,
    amount DECIMAL(12,2) NOT NULL,
    duration VARCHAR(30) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS goals (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    description VARCHAR(255) NOT NULL,
    target_amount DECIMAL(12,2) NOT NULL,
    saved_amount DECIMAL(12,2) NOT NULL DEFAULT 0,
    deadline DATE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS security_settings (
    id INT PRIMARY KEY AUTO_INCREMENT,
    encryption_enabled BOOLEAN DEFAULT TRUE,
    access_control_enabled BOOLEAN DEFAULT TRUE,
    login_security_enabled BOOLEAN DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS system_settings (
    id INT PRIMARY KEY AUTO_INCREMENT,
    application_name VARCHAR(100) DEFAULT 'Finora',
    currency VARCHAR(10) DEFAULT 'INR',
    notifications_enabled BOOLEAN DEFAULT TRUE
);

INSERT IGNORE INTO users(id,name,email,password,role,status)
VALUES
(1,'Satyam','satyam@gmail.com','1234','USER','ACTIVE'),
(2,'Administrator','admin@finance.com','admin123','ADMIN','ACTIVE');

INSERT IGNORE INTO security_settings(id,encryption_enabled,access_control_enabled,login_security_enabled)
VALUES (1,TRUE,TRUE,TRUE);

INSERT IGNORE INTO system_settings(id,application_name,currency,notifications_enabled)
VALUES (1,'Finora','INR',TRUE);
