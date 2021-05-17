FROM openjdk:8
ADD target/AuthorizationService.jar AuthorizationService.jar
EXPOSE 8084
ENTRYPOINT ["java","-jar","/AuthorizationService.jar"]