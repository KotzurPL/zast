FROM openjdk:21-jdk-oracle

WORKDIR /zast

COPY ./.mvn/ ./.mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src

EXPOSE 8080

CMD ["./mvnw", "spring-boot:run"]