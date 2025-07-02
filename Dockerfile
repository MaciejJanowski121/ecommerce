FROM eclipse-temurin:21-jdk
COPY target/ecommerce-*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]