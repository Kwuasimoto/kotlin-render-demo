FROM gradle:latest AS build
COPY . .
RUN gradle clean build

FROM openjdk:17
ENV JAR_NAME=tradeagent-server-0.0.1-SNAPSHOT.jar

WORKDIR .
COPY --from=build /target/$JAR_NAME demo.jar

EXPOSE 8080
ENTRYPOINT exec java -jar ./build/libs/demo.jar