FROM amazoncorretto:11-alpine-jdk
MAINTAINER SMS294
COPY ./smst/sms/target/sms-0.0.1-SNAPSHOT.jar sms-app.jar
ENTRYPOINT ["java", "-jar", "/sms-app.jar"]
EXPOSE 8080