FROM gradle:latest AS BUILD

RUN mkdir /usr/app
ENV APP_HOME=/usr/app
WORKDIR $APP_HOME

# mkdir required on some web services were the app directory is not created by default.
# copy the root dir to the docker instance.
COPY . .
RUN gradle clean build

FROM openjdk:17
ENV JAR_NAME=render-plain-demo-0.0.1-SNAPSHOT.jar

ENV APP_HOME=/usr/app
WORKDIR $APP_HOME

COPY --from=BUILD $APP_HOME .

ENTRYPOINT exec java -jar $APP_HOME/build/libs/$JAR_NAME --spring.profiles.active=prod
