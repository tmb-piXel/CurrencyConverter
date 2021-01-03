FROM openjdk:14-jdk-alpine
VOLUME /tmp
EXPOSE 8555
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT [ "java","-jar","--enable-preview","/app.jar"]