# Use OpenJDK 21 as base image
FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /app

# Copy the JAR file (will be passed as build argument)
ARG JAR_FILE
COPY target/${JAR_FILE} app.jar

# Expose port (if the application had a web interface)
EXPOSE 8080

# Set JVM options for production
ENV JAVA_OPTS="-Xms256m -Xmx512m -XX:+UseG1GC -XX:+UseContainerSupport"

# Run the application
CMD ["sh", "-c", "java \$JAVA_OPTS -jar app.jar"]