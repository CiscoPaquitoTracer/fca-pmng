# =========================
# Etapa 1: Build
# =========================
FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /app

# Copiar primero el pom para aprovechar la caché de Docker
COPY pom.xml .

# Descargar dependencias
RUN mvn dependency:go-offline -B

# Copiar código fuente
COPY src ./src

# Compilar el proyecto
RUN mvn clean package -DskipTests


# =========================
# Etapa 2: Runtime
# =========================
FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

# Copiar el JAR generado
COPY --from=build /app/target/*.jar app.jar

# Puerto de Spring Boot (Jenkins ya está en el 8080)
EXPOSE 8081

# Ejecutar aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]