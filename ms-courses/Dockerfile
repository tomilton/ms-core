FROM openjdk:23-slim

WORKDIR /app

COPY . .

RUN ./gradlew clean build -x test

EXPOSE 8002

ENTRYPOINT ["java","-jar","./build/libs/ms-courses-0.0.1-SNAPSHOT.jar"]