FROM eclipse-temurin:21.0.1_12-jdk-jammy

LABEL corporation="test"
LABEL maintainer="test"
LABEL email="test@test.com"

WORKDIR /app

COPY . ./build/

RUN apt update; \
    apt install -y maven; \
    mkdir -p /app/{results,build};

WORKDIR /app/build

RUN mvn clean install -e -Dmaven.test.skip=true; \
    mv target/quarkus-app/* /app/;

WORKDIR /app

RUN rm -rf ./build/

ENTRYPOINT  ["java", "-jar", "/app/quarkus-run.jar", "--server.address=0.0.0.0", "--server.port=8080"]

EXPOSE 8080
