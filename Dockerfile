#Se toma la imagen maven:3.8.4-jdk-11-slim como base para compilar nuestro proyecto
#y generar el archivo jar con que se ejecuta nuestro proyecto. 
FROM maven:3.8.4-jdk-11-slim AS build

#crear una carpeta de trabajo en la imagen de maven
RUN mkdir -p workspace

#define la ubicacion por defecto en la imagen que estamos trabajando
WORKDIR workspace

#copiamos el pom que tiene las dependencias de nuestro proyecto
COPY pom.xml /workspace

#copiamos los fuentes nuestro proyecto
COPY src /workspace/src

#compilamos el proyecto y generamos el jar
RUN mvn -f pom.xml clean install -DskipTests=true

#segunda parte.
#construir finalmente la imagen donde quedará nuestro proyecto

FROM eclipse-temurin:11-jdk

#se copia el jar generado en la primera imagen a esta segunda imagen
#cambiandole el nombre a app.jar
COPY --from=build /workspace/target/*.jar app.jar

#se expone el puerto 8080 en nuestra imagen
EXPOSE 8080

#al final se debe ejecutar nuestro proyecto java -jar app.jar
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=dev", "app.jar"]