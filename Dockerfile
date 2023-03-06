FROM amazoncorretto:8
COPY target/sold*.jar sold.jar

EXPOSE 7070
CMD [ "java", "-jar", "sold.jar"  ]