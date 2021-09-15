# library-management-service

This is a simple CRUD project using java spring boot full rest APIs.

This project using jdk 11 and mysql database.

# ddl create schema and table

- create schema

*CREATE SCHEMA `LIBRARY`;

- create table

*CREATE TABLE `LIBRARIAN` (
  `ID` varchar(15) NOT NULL,
  `NAME` varchar(120) DEFAULT NULL,
  `CONTACT` varchar(12) DEFAULT NULL,
  `ADDRESS` varchar(150) DEFAULT NULL,
  `IS_DELETED` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

