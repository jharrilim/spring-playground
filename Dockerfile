FROM    openjdk:11-jdk-slim as build
WORKDIR /app
COPY    . .
RUN     ./gradlew build
RUN     ls ./build/libs
FROM    openjdk:11-jre-slim as runtime
WORKDIR /app
ARG     name
ARG     version="0.0.1-SNAPSHOT"
COPY    --from=build /app/build/libs/${name}-${version}.jar .
CMD     [ "java", "-jar", "${name}-${version}.jar" ]
