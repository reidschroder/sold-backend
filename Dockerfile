FROM amazoncorretto:8
COPY target/sold*.war sold.war
ENTRYPOINT [ "java", "-jar", "\"\\sold.war\"" ]
EXPOSE 7070