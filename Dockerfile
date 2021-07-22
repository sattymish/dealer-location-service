FROM openjdk:8
ADD target/dealer-data-service.jar dealer-data-service.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "dealer-data-service.jar"]
