FROM openjdk:17
EXPOSE 8080
ARG JAR_FILE=target/entumovil-service-backend-tienda-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar 
ENTRYPOINT ["java","-jar","/app.jar"]