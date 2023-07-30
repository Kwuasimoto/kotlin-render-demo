FROM gradle:latest AS build
COPY . .
RUN gradle clean build

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/render-plain-demo-0.0.1-SNAPSHOT.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "demo.jar"]