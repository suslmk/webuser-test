FROM openjdk:8-jdk-alpine
ARG JAR_FILE=build/libs/*.war
COPY ${JAR_FILE} paas-ta-caas-dashboard.war
ENTRYPOINT ["java","-jar","/paas-ta-caas-dashboard.war"]
