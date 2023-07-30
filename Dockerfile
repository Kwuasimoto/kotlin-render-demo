FROM gradle:latest AS build

# mkdir required on some web services were the app directory is not created by default.


# copy the root dir to the docker instance.
COPY . .
RUN gradle clean build

FROM openjdk:17

RUN mkdir usr/app
RUN cd usr && ls

#ENV JAR_NAME=render-plain-demo-0.0.1-SNAPSHOT.jar
#ENV APP_HOME=usr/app
#WORKDIR $APP_HOME



#
#EXPOSE 8080
#ENTRYPOINT exec java -jar /build/libs/demo.jar