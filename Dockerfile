FROM maven:3.8.3-openjdk-17 AS build
COPY . .
RUN mvn clean package

FROM openjdk:17.0.1-alphine
COPY --from=build /app/target/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]