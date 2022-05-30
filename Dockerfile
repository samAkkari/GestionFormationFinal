FROM openjdk:8-jdk-alpine
EXPOSE 8088
ADD target/GesF-1.0.jar GesF
ENTRYPOINT ["java","-jar","/GesF-1.0.jar"]