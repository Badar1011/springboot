FROM openjdk:8
WORKDIR /usr/src/app
COPY target/*.jar application.jar
CMD ["java", "-jar", "application.jar"]
