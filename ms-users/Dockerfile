FROM openjdk:23-slim

WORKDIR /app

COPY . .

RUN ./gradlew clean build -x test

EXPOSE 8001

ENTRYPOINT ["java","-jar","./build/libs/ms-users-0.0.1-SNAPSHOT.jar"]