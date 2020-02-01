FROM openjdk:8
ADD build/libs/sample-employee-microservice-1.0.0.jar sample-employee-microservice-1.0.0.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "sample-employee-microservice-1.0.0.jar"]