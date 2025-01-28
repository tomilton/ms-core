./gradlew clean build -x test &&
docker build -t ms-courses:1.0.0 . &&
#docker run --add-host=host.docker.internal:host-gateway -p 8002:8070 --env-file \.env ms-courses:1.0.0
docker run -p 8002:8002 --name ms-courses --network=spring --env-file \.env ms-courses:1.0.0