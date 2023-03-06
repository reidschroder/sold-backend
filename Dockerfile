FROM amazoncorretto:8
COPY ./target/sold.jar sold.jar
CMD [ "java", "-jar", "sold.jar"  ]
EXPOSE 7070