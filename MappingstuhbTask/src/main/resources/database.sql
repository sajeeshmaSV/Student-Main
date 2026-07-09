CREATE DATABASE studentdb;

USE studentdb;

CREATE TABLE student(
    id INT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    gender VARCHAR(10),
    city VARCHAR(50),
    state VARCHAR(50),
    mobile_number VARCHAR(15),
    email_id VARCHAR(100) UNIQUE,

);