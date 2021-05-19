FROM openjdk:12
VOLUME /tmp
EXPOSE 8002
ADD ./target/spring-boot-service-items-0.0.1-SNAPSHOT.jar service-items.jar
ENTRYPOINT ["java", "-jar", "/service-items.jar"]