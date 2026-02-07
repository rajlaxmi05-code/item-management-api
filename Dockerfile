# Use Java 17
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy Maven wrapper & pom
COPY item-management-api/mvnw .
COPY item-management-api/.mvn .mvn
COPY item-management-api/pom.xml .

# Download dependencies
RUN chmod +x mvnw && ./mvnw dependency:go-offline

# Copy source code
COPY item-management-api/src src

# Build the application
RUN ./mvnw clean package -DskipTests

# Run the jar
CMD ["java", "-jar", "target/item-management-api-0.0.1-SNAPSHOT.jar"]
