# Stage 1: Build the application using Maven with Java 21
FROM maven:3.9.5-eclipse-temurin-21 AS builder
WORKDIR /kinetics-app

# Copy pom.xml first to leverage Docker caching
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline -B # Added -B for non-interactive mode

# Copy the source code
COPY src ./src

# Build the application and package it as a jar
RUN mvn clean package -DskipTests

# Stage 2: Run the application using a lightweight OpenJDK 21 runtime
FROM eclipse-temurin:21-jre-alpine
WORKDIR /kinetics-app

# Copy the built jar from the builder stage. Adjust the jar name if needed.
COPY --from=builder /kinetics-app/target/*.jar kinetics-app.jar

EXPOSE 8083

ENTRYPOINT ["java", "-jar", "kinetics-app.jar"]