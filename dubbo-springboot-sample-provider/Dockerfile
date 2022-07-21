FROM java:8
MAINTAINER Joker
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} dubbo-springboot-sample-provider.jar
ENTRYPOINT ["java","-jar","/dubbo-springboot-sample-provider.jar"]
ENV LISTEN_PORT 8080
EXPOSE 8080