FROM openjdk:23

WORKDIR /app

COPY ./build/libs/ms-users-0.0.1-SNAPSHOT.jar .

ENV PORT 8001

EXPOSE $PORT

ENTRYPOINT ["java", "-jar", "ms-users-0.0.1-SNAPSHOT.jar"]