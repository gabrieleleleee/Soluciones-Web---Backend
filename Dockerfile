# ===== Etapa 1: Compilar el proyecto con Maven =====
FROM eclipse-temurin:25-jdk AS build
WORKDIR /app

# Copiar primero el wrapper y pom.xml para aprovechar la cache de Docker
COPY .mvn/ .mvn/
COPY mvnw pom.xml ./
RUN chmod +x mvnw && ./mvnw dependency:go-offline -B

# Copiar el codigo fuente y compilar
COPY src/ src/
RUN ./mvnw clean package -DskipTests -B

# ===== Etapa 2: Imagen final liviana solo con el JAR =====
FROM eclipse-temurin:25-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "app.jar"]
