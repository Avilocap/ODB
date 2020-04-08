FROM openjdk:8-jdk-alpine
MAINTAINER migantber@alum.us.es
WORKDIR /opt/springbootapp/
ARG JAR_FILE=target/spring-oculusdb-2.2.0.BUILD-SNAPSHOT.jar
ADD ${JAR_FILE} /opt/springbootapp/
RUN chmod +x spring-oculusdb-2.2.0.BUILD-SNAPSHOT.jar
CMD ["java", "-jar", "spring-oculusdb-2.2.0.BUILD-SNAPSHOT.jar"]

EXPOSE 8080


#https://medium.com/@marcus.cavalcanti/deploying-microservices-with-aws-fargate-f0578d8199a3