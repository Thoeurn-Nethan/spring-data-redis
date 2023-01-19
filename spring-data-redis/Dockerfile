FROM openjdk:17

ADD target/redis-openshift.jar redis-openshift.jar

ENTRYPOINT ["java","-jar","redis-openshift.jar"]