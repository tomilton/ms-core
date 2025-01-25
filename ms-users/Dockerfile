FROM openjdk:23

WORKDIR /app

COPY ./build/libs/ms-users-0.0.1-SNAPSHOT.jar .

EXPOSE 8001

ENTRYPOINT ["java", "-jar", "ms-users-0.0.1-SNAPSHOT.jar"]

