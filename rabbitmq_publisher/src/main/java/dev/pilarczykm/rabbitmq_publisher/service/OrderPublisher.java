package dev.pilarczykm.rabbitmq_publisher.service;

import dev.pilarczykm.rabbitmq_publisher.config.RabbitMQConfig;
import dev.pilarczykm.rabbitmq_publisher.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderPublisher {

    private final RabbitTemplate rabbitTemplate;

    public void sendOrder(String productName) {
        var order = Order.builder().id(UUID.randomUUID().toString()).date(new Date()).product(productName).build();
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, order);
        System.out.println("[PUBLISH] Sending order: " + order);
    }
}
