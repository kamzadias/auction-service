# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the executable jar file from the build context into the container
COPY build/libs/auction-service-0.0.1-SNAPSHOT.jar app.jar

# Expose the port on which the application runs
EXPOSE 8080

# Define the command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
