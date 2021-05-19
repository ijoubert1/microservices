FROM openjdk:12
VOLUME /tmp
ADD ./target/spring-boot-service-users-0.0.1-SNAPSHOT.jar service-users.jar
ENTRYPOINT ["java","-jar","/service-users.jar"]