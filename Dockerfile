FROM gradle:latest AS build
ENV APP_HOME=/usr/app
WORKDIR $APP_HOME

COPY . .
RUN gradle clean build

FROM openjdk:17
ENV JAR_NAME=render-plain-demo-0.0.1-SNAPSHOT.jar

RUN cd usr && ls
#COPY --from=build /build/libs/$JAR_NAME demo.jar
#
#EXPOSE 8080
#ENTRYPOINT exec java -jar /build/libs/demo.jar