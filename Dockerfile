FROM openjdk:18.0-slim
COPY target/entumovil-service-backend-tienda-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","/app.jar"]