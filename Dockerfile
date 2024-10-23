FROM openjdk:22-jdk-slim
ARG JAR_FILE=target/rocketnotes-0.0.1.jar
COPY ${JAR_FILE} app_rocketnotes.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_rocketnotes.jar"]