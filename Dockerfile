# Stage 1: Build
FROM eclipse-temurin:21-jdk AS builder
WORKDIR /workspace
COPY . .
RUN ./gradlew assemble --no-daemon

# Stage 2: Run
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
COPY --from=builder /workspace/build/libs/*-all.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]