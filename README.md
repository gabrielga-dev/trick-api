# Trick API
This project is being constructed with the intention of training Backend and Devops skills with Spring boot, Docker and
Kubernetes.

## Subject
This is a simple CRUD API about tricks on the [Tony Hawk video games series](https://pt.wikipedia.org/wiki/Tony_Hawk%27s).

_It was part of my childhood, so... why not use it as the subject of this project? =]_

## Running locally
To run this project locally, you can run the following command to create the necessary docker database containers:

> docker compose up -d

Once with the database container running, you can run the Spring Boot application with this command:

> mvn spring-boot:run

Or just create the .jar file and run it:

> mvn clean package && java -jar ./taget/<OUTPUT_FILE_NAME>.jar

## Using the APIs

To use the APIs, you can access the Swagger documentation available at:

> http://localhost:8080/swagger-ui/index.html

## Running with kubernetes
**🚧🚧🚧 Currently under construction... 🚧🚧🚧**