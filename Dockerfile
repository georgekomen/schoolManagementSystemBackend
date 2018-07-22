FROM java:8
VOLUME /tmp
MAINTAINER George komen <gkkomensi@gmail.com>
# ADD build/libs/arafatproject-0.0.1-SNAPSHOT.jar app.jar
ADD build/docker/libs /libs
ADD build/classes/java/main /classes
ADD build/resources/main /resources
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]