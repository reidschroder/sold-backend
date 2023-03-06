FROM amazoncorretto:8
COPY target/sold*.jar sold.jar
ENTRYPOINT [ "java", "-jar", "sold.jar" ]
EXPOSE 7070