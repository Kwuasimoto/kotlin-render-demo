FROM gradle:latest AS build

# mkdir required on some web services were the app directory is not created by default.
RUN mkdir usr/app
ENV APP_HOME=usr/app
WORKDIR $APP_HOME

# copy the root dir to the docker instance.
COPY . .
RUN gradle clean build

FROM openjdk:17
ENV JAR_NAME=render-plain-demo-0.0.1-SNAPSHOT.jar

RUN cd usr/app && ls

#
#EXPOSE 8080
#ENTRYPOINT exec java -jar /build/libs/demo.jar