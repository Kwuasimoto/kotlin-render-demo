FROM gradle:latest AS build
COPY . .
RUN gradle clean build

FROM openjdk:17
ENV JAR_NAME=tradeagent-server-0.0.1-SNAPSHOT.jar
ENV APP_HOME=/usr/app

RUN mkdir $APP_HOME

WORKDIR $APP_HOME
COPY --from=build $APP_HOME .

EXPOSE 8080
ENTRYPOINT exec java -jar $APP_HOME/build/libs/$JAR_NAME