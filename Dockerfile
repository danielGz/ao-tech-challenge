# Start with a base image containing Java runtime
FROM alpine/java:21-jdk as builder

# Set the location of the app directory
WORKDIR /app

# Copy the project files into the image
COPY . .

# Build the application using only the bootJar task to generate the executable jar
RUN ./gradlew bootJar

# Start a new stage from scratch
FROM alpine/java:21-jdk

WORKDIR /app

# Copy the executable jar from the build stage
COPY --from=builder /app/build/libs/*.jar /app/app.jar

# Expose port 8080
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar","--spring.profiles.active=prod"]