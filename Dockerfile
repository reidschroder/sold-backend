FROM amazoncorretto:8
COPY target/sold*.jar sold.jar
ENTRYPOINT [ "java", "-jar", "C:\\Users\\reids\\revature\\projects\\staging\\sold-backend\\sold.jar"  ]
EXPOSE 7070