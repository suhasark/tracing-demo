FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} tracing-demo.jar
ENTRYPOINT ["java","-jar","/tracing-demo.jar"]