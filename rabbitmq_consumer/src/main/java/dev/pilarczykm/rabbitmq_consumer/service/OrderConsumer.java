package dev.pilarczykm.rabbitmq_consumer.service;

import dev.pilarczykm.rabbitmq_consumer.config.RabbitMQConfig;
import dev.pilarczykm.rabbitmq_consumer.model.Order;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    @RabbitListener(queues = RabbitMQConfig.PREMIUM_QUEUE)
    public void processPremiumOrder(Order order) {
        System.out.println("Processing PREMIUM order: " + order);
    }

    @RabbitListener(queues = RabbitMQConfig.STANDARD_QUEUE)
    public void processStandardOrder(Order order) {
        System.out.println("Processing STANDARD order: " + order);
    }
}
