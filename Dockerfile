FROM openjdk:21-rc-jdk

WORKDIR /app

COPY target/atividade_devops_2-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]