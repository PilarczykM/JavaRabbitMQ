# JavaRabbitMQ

* RabbitMQ via docker
> docker run --rm -it --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:4.1.4-management

## Build

For all projects
> mvn clean package

## Run
java -jar target/{FILE_LOCATION}.jar