

DROP DATABASE IF EXISTS eStudent;
CREATE DATABASE IF NOT EXISTS eStudent;

USE eStudent;

DROP TABLE IF EXISTS Student;
CREATE TABLE IF NOT EXISTS Student (
    IDStudent INT NOT NULL AUTO_INCREMENT PRIMARY KEY,

    Name NVARCHAR(32) NOT NULL,
    Address NVARCHAR(128),
    Phone VARCHAR(32)

    #PRIMARY KEY (IDStudent)
);

INSERT INTO Student (Name, Address, Phone) VALUES ('Name', 'Address', 'Phone');



