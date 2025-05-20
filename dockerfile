# Use an official OpenJDK image as base
FROM openjdk:17-jdk-slim

# Add the jar file to the container
COPY target/*.jar Employee-0.0.1-SNAPSHOT.jar

# Run the jar file
ENTRYPOINT ["java", "-jar", "Employee-0.0.1-SNAPSHOT.jar"]
