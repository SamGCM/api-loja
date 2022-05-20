FROM amazoncorretto:11-alpine

COPY target/cliente-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

EXPOSE 8083