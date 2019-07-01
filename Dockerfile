FROM openjdk:alpine
MAINTAINER Junaid Ansari <junaid.ans@gmail.com>
ADD target/spring-docker.jar springboot-mongo.jar
ENTRYPOINT ["java", "-jar", "/springboot-mongo.jar"]
EXPOSE 8080