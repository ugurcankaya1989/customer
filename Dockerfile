FROM openjdk:13-jdk-alpine
VOLUME /tmp
COPY target/*.jar customer.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/customer.jar"]