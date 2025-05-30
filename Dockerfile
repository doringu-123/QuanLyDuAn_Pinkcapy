FROM maven:3-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/Job-Portal-0.0.1-SNAPSHOT.war .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "Job-Portal-0.0.1-SNAPSHOT.war"]
