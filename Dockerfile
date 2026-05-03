# AWS Corretto Java 21 (official Amazon image)
FROM amazoncorretto:21-alpine

# Set working directory
WORKDIR /app

# Copy the jar file
COPY target/*.jar app.jar

# Expose application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
