# ---------- build stage ----------
FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /project

COPY . .

RUN mvn clean package -DskipTests


# ---------- run stage ----------
FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

COPY --from=build /project/target/*.jar app.jar

EXPOSE 8761

ENTRYPOINT ["java","-jar","app.jar"]