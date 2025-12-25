FROM eclipse-temurin:22-jdk-alpine

WORKDIR /app

COPY . .

# 1. Fix: Ensure mvnw is executable
RUN chmod +x mvnw

# 2. Fix: specific command to build (must be uppercase RUN)
RUN ./mvnw clean package -DskipTests

EXPOSE 8080

# 3. Fix: Use shell format (no brackets) so the "*" wildcard works
ENTRYPOINT java -jar target/*.jar


