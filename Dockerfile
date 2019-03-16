FROM openjdk:jdk-10-slim AS build
COPY . .
RUN gradlew clean bootJar

FROM openjdk:jre-10-slim
COPY --from=build ./build/libs .
ENTRYPOINT ["java", "-jar", "billing-0.0.1-SNAPSHOT.jar"]