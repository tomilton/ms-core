FROM openjdk:23

WORKDIR /app

COPY ./build/libs/ms-users-0.0.1-SNAPSHOT.jar .

ARG PORT_APP=8001
ENV PORT $PORT_APP
EXPOSE $PORT

ENTRYPOINT ["java", "-jar", "ms-users-0.0.1-SNAPSHOT.jar"]