# Spring OculusDB Application [![Build Status](https://travis-ci.org/spring-projects/spring-oculusdb.png?branch=master)](https://travis-ci.org/spring-projects/spring-oculusdb/)


## Running oculusdb locally
oculusdb is a [Spring Boot](https://spring.io/guides/gs/spring-boot) application built using [Maven](https://spring.io/guides/gs/maven/). You can build a jar file and run it from the command line:


```
https://github.com/Avilocap/ODB
cd ODB
./mvnw package
java -jar target/*.jar
```

You can then access OculusDB here: http://localhost:8080/

<img width="1042" alt="oculusdb-screenshot" src="https://cloud.githubusercontent.com/assets/838318/19727082/2aee6d6c-9b8e-11e6-81fe-e889a5ddfded.png">

Or you can run it from Maven directly using the Spring Boot Maven plugin. If you do this it will pick up changes that you make in the project immediately (changes to Java source files require a compile as well - most people use an IDE for this):

```
./mvnw spring-boot:run
```

## In case you find a bug/suggested improvement for Spring oculusdb
Our issue tracker is available here: https://github.com/spring-projects/spring-oculusdb/issues


## Database configuration


You could start MySql locally with whatever installer works for your OS, or with docker:

```
docker run -e MYSQL_USER=oculusdb -e MYSQL_PASSWORD=oculusdb -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=oculusdb -p 3306:3306 mysql:5.7.8
```

## Looking for something in particular?

|Spring Boot Configuration | Class or Java property files  |
|--------------------------|---|
|The Main Class | [oculusdbApplication](https://github.com/spring-projects/spring-oculusdb/blob/master/src/main/java/org/springframework/samples/oculusdb/oculusdbApplication.java) |
|Properties Files | [application.properties](https://github.com/spring-projects/spring-oculusdb/blob/master/src/main/resources) |
|Caching | [CacheConfiguration](https://github.com/spring-projects/spring-oculusdb/blob/master/src/main/java/org/springframework/samples/oculusdb/system/CacheConfiguration.java) |

## Interesting Spring oculusdb branches and forks

The Spring OculusDB master branch in the main [spring-projects](https://github.com/spring-projects/spring-oculusdb)
GitHub org is the "canonical" implementation, currently based on Spring Boot and Thymeleaf. There are
[quite a few forks](https://spring-oculusdb.github.io/docs/forks.html) in a special GitHub org
[spring-oculusdb](https://github.com/spring-oculusdb). If you have a special interest in a different technology stack
that could be used to implement the Pet Clinic then please join the community there.


## Interaction with other open source projects

One of the best parts about working on the Spring oculusdb application is that we have the opportunity to work in direct contact with many Open Source projects. We found some bugs/suggested improvements on various topics such as Spring, Spring Data, Bean Validation and even Eclipse! In many cases, they've been fixed/implemented in just a few days.
Here is a list of them:

| Name | Issue |
|------|-------|
| Spring JDBC: simplify usage of NamedParameterJdbcTemplate | [SPR-10256](https://jira.springsource.org/browse/SPR-10256) and [SPR-10257](https://jira.springsource.org/browse/SPR-10257) |
| Bean Validation / Hibernate Validator: simplify Maven dependencies and backward compatibility |[HV-790](https://hibernate.atlassian.net/browse/HV-790) and [HV-792](https://hibernate.atlassian.net/browse/HV-792) |
| Spring Data: provide more flexibility when working with JPQL queries | [DATAJPA-292](https://jira.springsource.org/browse/DATAJPA-292) |


# Contributing

The [issue tracker](https://github.com/spring-projects/spring-oculusdb/issues) is the preferred channel for bug reports, features requests and submitting pull requests.

For pull requests, editor preferences are available in the [editor config](.editorconfig) for easy use in common text editors. Read more and download plugins at <https://editorconfig.org>. If you have not previously done so, please fill out and submit the [Contributor License Agreement](https://cla.pivotal.io/sign/spring).

# License

The Spring OculusDB application is released under version 2.0 of the [Apache License](https://www.apache.org/licenses/LICENSE-2.0).

[spring-oculusdb]: https://github.com/spring-projects/spring-oculusdb
[spring-framework-oculusdb]: https://github.com/spring-oculusdb/spring-framework-oculusdb
[spring-oculusdb-angularjs]: https://github.com/spring-oculusdb/spring-oculusdb-angularjs 
[javaconfig branch]: https://github.com/spring-oculusdb/spring-framework-oculusdb/tree/javaconfig
[spring-oculusdb-angular]: https://github.com/spring-oculusdb/spring-oculusdb-angular
[spring-oculusdb-microservices]: https://github.com/spring-oculusdb/spring-oculusdb-microservices
[spring-oculusdb-reactjs]: https://github.com/spring-oculusdb/spring-oculusdb-reactjs
[spring-oculusdb-graphql]: https://github.com/spring-oculusdb/spring-oculusdb-graphql
[spring-oculusdb-kotlin]: https://github.com/spring-oculusdb/spring-oculusdb-kotlin
[spring-oculusdb-rest]: https://github.com/spring-oculusdb/spring-oculusdb-rest
