FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /build

COPY ATPS/Back_End/discovery-server/pom.xml pom.xml
COPY ATPS/Back_End/discovery-server/src src

RUN mvn clean package -DskipTests


FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

COPY --from=build /build/target/*.jar app.jar

EXPOSE 8761

ENTRYPOINT ["java","-jar","app.jar"]