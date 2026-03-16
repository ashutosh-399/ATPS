# Use Java 21 image
FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /app

# Copy jar file from target folder
COPY target/*.jar app.jar

# Expose port (change if needed)
EXPOSE 8085

# Run jar
ENTRYPOINT ["java","-jar","app.jar"]