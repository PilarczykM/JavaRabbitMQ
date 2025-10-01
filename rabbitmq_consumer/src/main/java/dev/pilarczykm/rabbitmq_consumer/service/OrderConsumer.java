package dev.pilarczykm.rabbitmq_consumer.service;

import dev.pilarczykm.rabbitmq_consumer.config.RabbitMQConfig;
import dev.pilarczykm.rabbitmq_consumer.model.Order;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void processOrder(Order order) {
        System.out.println("Processing order: " + order);
    }
}
