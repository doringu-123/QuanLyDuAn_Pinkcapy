# Giai đoạn build: Dùng Maven để build file WAR
FROM maven:3-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Giai đoạn runtime: Dùng Tomcat để chạy WAR
FROM tomcat:10.1-jdk17
# Xoá ứng dụng mặc định trong Tomcat nếu có
RUN rm -rf /usr/local/tomcat/webapps/*
# Copy WAR vào Tomcat
COPY --from=build /app/target/Job-Portal-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
