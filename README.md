# library-management-service

This is a simple CRUD project using java spring boot full rest APIs.
This project using jdk 11, mysql database, and implementing unit test.


# ddl create schema
```<language>
CREATE SCHEMA `LIBRARY`;
```

# ddl create table
```<language>
*CREATE TABLE `LIBRARIAN` (
  `ID` varchar(15) NOT NULL,
  `NAME` varchar(120) DEFAULT NULL,
  `CONTACT` varchar(12) DEFAULT NULL,
  `ADDRESS` varchar(150) DEFAULT NULL,
  `IS_DELETED` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
```

# don't forget to change the datasource configuration at application.properties as yours
```<language>
spring.datasource.username
spring.datasource.password
```

# run this project 
```<language>
mvn spring-boot:run
```

# path url
```<language>
http://localhost:7667/LibraryService/
```
