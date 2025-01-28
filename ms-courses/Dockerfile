FROM openjdk:23

WORKDIR /app

COPY ./build/libs/ms-courses-0.0.1-SNAPSHOT.jar .

ENV PORT 8002

EXPOSE $PORT

ENTRYPOINT ["java", "-jar", "ms-courses-0.0.1-SNAPSHOT.jar"]