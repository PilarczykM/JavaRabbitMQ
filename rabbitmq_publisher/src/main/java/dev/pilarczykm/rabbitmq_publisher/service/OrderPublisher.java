package dev.pilarczykm.rabbitmq_publisher.service;

import dev.pilarczykm.rabbitmq_publisher.config.RabbitMQConfig;
import dev.pilarczykm.rabbitmq_publisher.dto.OrderRequest;
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

    public void sendOrder(OrderRequest orderRequest) {
        var order = Order.builder().id(UUID.randomUUID().toString()).date(new Date()).product(orderRequest.product()).build();

        String routingKey = orderRequest.orderType().equals("premium") ?
                RabbitMQConfig.PREM_ROUTING_KEY :
                RabbitMQConfig.STD_ROUTING_KEY;

        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, routingKey, order);
        System.out.println("[PUBLISH] Sending order: " + order);
    }
}
