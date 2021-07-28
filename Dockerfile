FROM openjdk:11
ENV JAEGER_ENDPOINT="http://localhost:14268/api/traces"
ENV JAEGER_SAMPLER_TYPE=const
ENV JAEGER_SAMPLER_PARAM=1
ENV JAEGER_REPORTER_LOG_SPANS=true
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} tracing-demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/tracing-demo.jar"]