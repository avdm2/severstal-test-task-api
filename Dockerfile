FROM openjdk:17-alpine

COPY out/artifacts/severstal_test_task_api_jar/*.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]