FROM openjdk:8-jdk-alpine

# Copy the JAR from the target folder into the container
COPY /target/Niceday-0.0.1-SNAPSHOT.jar  Niceday-0.0.1-SNPASHOT.jar

ENTRYPOINT ["java", "-jar", "/NiceDay-0.0.1-SNAPSHOT.jar"]