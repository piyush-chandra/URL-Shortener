FROM openjdk:22-slim

WORKDIR /app

COPY target/URL-Shortener-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]