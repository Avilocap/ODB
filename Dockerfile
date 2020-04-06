FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/spring-oculusdb-2.2.0.BUILD-SNAPSHOT.jar
COPY ${JAR_FILE} oculusdb.jar
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /oculusdb.jar"]