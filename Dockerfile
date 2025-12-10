# Stage 1: Build do projeto - vamos usar uma máquina que já tem o gradle
FROM gradle:8.7-jdk21-jammy AS builder
WORKDIR /workspace

# Copia arquivos do projeto
COPY . .

# Executa o build
RUN gradle assemble --no-daemon

# Stage 2: Run
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
COPY --from=builder /workspace/build/libs/*-all.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]