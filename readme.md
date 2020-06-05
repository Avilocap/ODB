# Spring OculusDB Application 

## CI / CD Deployments
![Java CI with Maven](https://github.com/Avilocap/ODB/workflows/Java%20CI%20with%20Maven/badge.svg)

## Running oculusdb locally
oculusdb is a [Spring Boot](https://spring.io/guides/gs/spring-boot) application built using [Maven](https://spring.io/guides/gs/maven/). You can build a jar file and run it from the command line:

You can log in on the application with the administrator user testuser with password testuser.

```
https://github.com/Avilocap/ODB
cd ODB
./mvnw package
java -jar target/*.jar
```

You can then access OculusDB here: http://localhost:8080/

<img width="1042" alt="oculusdb-screenshot" src="https://github.com/Avilocap/ODB/blob/master/docs/landing_snapshop.png?raw=true">

Or you can run it from Maven directly using the Spring Boot Maven plugin. If you do this it will pick up changes that you make in the project immediately (changes to Java source files require a compile as well - most people use an IDE for this):

```
./mvnw spring-boot:run -Dspring.profiles.active=development

```

## Database configuration
1. Install [MySQL Community Server 8.0.19](https://dev.mysql.com/downloads/mysql/). Follow the steps and create a password for root user.

2. Open mysql console with:

`mysql -u root -p`

 and the password you just have chosen in the installation step.

4. Create the database of the project with the following command:

`CREATE DATABASE IF NOT EXISTS oculusdb;
ALTER DATABASE oculusdb   DEFAULT CHARACTER SET utf8   DEFAULT COLLATE utf8_general_ci;
CREATE USER 'oculusdb'@'%' IDENTIFIED BY 'oculusdb';
GRANT ALL PRIVILEGES ON *.* TO 'oculusdb'@'%' WITH GRANT OPTION;`

## User to login

User: testuser

Password: testuser


# License

The Spring OculusDB application is released under version 2.0 of the [Apache License](https://www.apache.org/licenses/LICENSE-2.0).
