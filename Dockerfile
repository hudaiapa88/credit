FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} credit-api.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/credit-api.jar"]
