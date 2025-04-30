# ---------- BUILD STAGE ----------
FROM eclipse-temurin:21-jdk AS build

WORKDIR /app

# Copy build files
COPY . .

# Build the Spring Boot app (assuming using Maven)
RUN ./mvnw clean package -DskipTests

# ---------- RUNTIME STAGE ----------
FROM eclipse-temurin:21-jre-alpine AS runtime

WORKDIR /app

# Copy the JAR from the build stage
COPY --from=build /app/target/proxy-0.0.1-SNAPSHOT.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
