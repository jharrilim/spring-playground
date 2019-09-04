FROM    openjdk:11-jdk-slim as build
WORKDIR /app
COPY    . .
RUN     ./gradlew build

FROM    openjdk:11-jre-slim as runtime
WORKDIR /app
ARG     name
ARG     version="0.0.1-SNAPSHOT"
ENV     APP_NAME ${name}
ENV     APP_VERSION ${version}
COPY    --from=build /app/build/libs/${name}-${version}.jar .
CMD     java -jar "${APP_NAME}-${APP_VERSION}.jar"
