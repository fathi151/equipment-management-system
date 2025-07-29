FROM eclipse-temurin:22-jdk
WORKDIR /app
COPY .. .
RUN ./mvnw clean package -DskipTests
CMD ["java", "-jar", "target/pi-0.0.1-SNAPSHOT.jar"]
