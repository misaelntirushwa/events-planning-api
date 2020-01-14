FROM maven:3.6.3-jdk-8 as maven
WORKDIR /app
COPY pom.xml pom.xml
COPY . .
RUN mvn clean package

FROM openjdk:8
COPY --from=maven /app/target/events-planning-api-0.0.1-SNAPSHOT.jar events-planning-api-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "events-planning-api-0.0.1-SNAPSHOT.jar"]

