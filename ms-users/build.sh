./gradlew clean build -x test &&
docker build -t ms-user:1.0.0 . &&
#docker run --add-host=host.docker.internal:host-gateway -p 8001:8090 --env PORT=8090 ms-user:1.0.0
docker run --add-host=host.docker.internal:host-gateway -p 8001:8090 --env-file \.env ms-user:1.0.0