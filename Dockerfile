FROM openjdk:8
ADD target/events-planning-api.jar events-planning-api.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "events-planning-api.jar"]
