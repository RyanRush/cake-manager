# https://docs.docker.com/engine/reference/builder/#from
FROM openjdk:8-jdk-alpine

# https://docs.docker.com/engine/reference/builder/#volume
VOLUME /tmp

# https://docs.docker.com/engine/reference/builder/#expose
EXPOSE 8080

# https://docs.docker.com/engine/reference/builder/#arg
ARG JAR_FILE=build/libs/cake-manager-1.0-SNAPSHOT.jar

# https://docs.docker.com/engine/reference/builder/#add
ADD ${JAR_FILE} cake-manager.jar

# https://docs.docker.com/engine/reference/builder/#entrypoint
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","cake-manager.jar"]