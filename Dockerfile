FROM maven:latest

LABEL authors="viktoria"

WORKDIR /app

COPY  pom.xml /app

COPY . /app

RUN mvn package

CMD ["java", "-jar", "target/tracker.jar"]