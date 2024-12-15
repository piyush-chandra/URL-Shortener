# FROM maven:3.9.9-eclipse-temurin-22 AS build

# WORKDIR /app

# COPY pom.xml ./
# RUN mvn dependency:go-offline -B

# COPY src ./src

# RUN mvn clean package -DskipTests

# FROM eclipse-temurin:22-jdk

# WORKDIR /app

# ENV DATABASE_URL=jdbc:postgresql://<DB_HOST>:<DB_PORT>/<DB_NAME>
# ENV DATABASE_USERNAME=<DB_USERNAME>
# ENV DATABASE_PASSWORD=<DB_PASSWORD>

# COPY --from=build /app/target/URL-Shortener-0.0.1-SNAPSHOT.jar app.jar

# EXPOSE 42069

# ENTRYPOINT ["java", "-jar", "app.jar"]

FROM openjdk:22-slim

WORKDIR /app

COPY target/URL-Shortener-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
