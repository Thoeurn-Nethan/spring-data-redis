FROM openjdk:17

ADD target/Redis-OKD.jar Redis-OKD.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","Redis-OKD.jar"]