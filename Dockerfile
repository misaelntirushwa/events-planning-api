FROM maven:3.6.3-jdk-8 as maven
WORKDIR /app
COPY pom.xml pom.xml
COPY . .
RUN mvn clean package

FROM openjdk:8
ARG JAR_FILE=/app/target/*.jar
COPY --from=maven ${JAR_FILE} events-planning-api.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "events-planning-api.jar"]

