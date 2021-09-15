# library-management-service

This is a simple CRUD project using java spring boot full rest APIs.

This project using jdk 11 and mysql database.


# ddl create schema

CREATE SCHEMA `LIBRARY`;


# ddl create table

*CREATE TABLE `LIBRARIAN` (
  `ID` varchar(15) NOT NULL,
  `NAME` varchar(120) DEFAULT NULL,
  `CONTACT` varchar(12) DEFAULT NULL,
  `ADDRESS` varchar(150) DEFAULT NULL,
  `IS_DELETED` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


# don't forget to change the datasource config at application.properties as yours

spring.datasource.username
spring.datasource.password


# run this project 

*mvn spring-boot:run


# path url

http://localhost:7667/LibraryService/
