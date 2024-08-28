FROM maven:3.9.9-eclipse-temurin-22 AS build

WORKDIR /app

COPY pom.xml ./
RUN mvn dependency:go-offline -B

COPY src ./src

RUN mvn clean package -DskipTests

FROM eclipse-temurin:22-jdk

WORKDIR /app

COPY --from=build /app/target/URL-Shortener-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 42069

ENTRYPOINT ["java", "-jar", "app.jar"]