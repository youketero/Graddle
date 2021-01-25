FROM openjdk:8-alpine
RUN mkdir -p /usr/src/app/
WORKDIR /usr/src/app/
COPY . /usr/src/app/

ENTRYPOINT ["./gradlew", "runGatlingSimulation"]
#CMD ["./gradlew", "runGatlingSimulation"]