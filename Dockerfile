# Fetching latest version of Java
FROM openjdk:20

# Setting up work directory
WORKDIR /app
COPY . /app/
RUN mvn clean package

# Copy the jar file into our app
COPY --from=build /app/target/*.jar /app/app.jar

# Exposing port 8080
EXPOSE 8080

# Starting the application
CMD ["java", "-jar", "spring-0.0.1-SNAPSHOT.jar"]