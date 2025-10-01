# JavaRabbitMQ

This project demonstrates a simple publisher-consumer pattern using Java, Spring Boot, and RabbitMQ.

* RabbitMQ via docker
> docker run --rm -it --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:4.1.4-management

## Projects

### `rabbitmq_publisher`
*   **Purpose:** A Spring Boot web application that acts as a message publisher.
*   **Technology:** Java 17, Spring Boot, Maven.
*   **Functionality:** Exposes a REST endpoint at `/orders`. When it receives a POST request with a product name, it creates an `Order` object and sends it to the `order-queue` in RabbitMQ.
*   **Key Libraries:** `spring-boot-starter-web`, `spring-boot-starter-amqp`, `lombok`.

### `rabbitmq_consumer`
*   **Purpose:** A Spring Boot application that acts as a message consumer.
*   **Technology:** Java 17, Spring Boot, Maven.
*   **Functionality:** Listens to the `order-queue` on RabbitMQ. When a message arrives, it deserializes the `Order` object and prints it to the console.
*   **Key Libraries:** `spring-boot-starter-amqp`, `lombok`.

## Build and Run

Navigate into each project's directory to build and run them.

### Build

First, build the JAR files for both projects using Maven.

```bash
# From the root directory
(cd rabbitmq_publisher && mvn clean package)
(cd rabbitmq_consumer && mvn clean package)
```

### Run

After building, you can run the applications.

**1. Run the Consumer**
```bash
java -jar rabbitmq_consumer/target/rabbitmq_consumer-0.0.1-SNAPSHOT.jar
```

**2. Run the Publisher** (Defaults to port 8080)
```bash
java -jar rabbitmq_publisher/target/rabbitmq_publisher-0.0.1-SNAPSHOT.jar
```

### Usage

Once both applications are running, you can send a `POST` request to the publisher to create an order, which will then be consumed and logged by the consumer.

```bash
curl -X POST -H "Content-Type: application/json" -d '"MyNewProduct"' http://localhost:8080/orders
```
