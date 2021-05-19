FROM openjdk:12
VOLUME /tmp
ADD ./target/spring-boot-service-oauth-0.0.1-SNAPSHOT.jar service-oauth.jar
ENTRYPOINT ["java", "-jar", "/service-oauth.jar"]