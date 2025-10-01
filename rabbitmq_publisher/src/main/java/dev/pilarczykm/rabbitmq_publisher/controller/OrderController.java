package dev.pilarczykm.rabbitmq_publisher.controller;

import dev.pilarczykm.rabbitmq_publisher.dto.OrderRequest;
import dev.pilarczykm.rabbitmq_publisher.service.OrderPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderPublisher orderPublisher;

    @RequestMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderRequest orderRequest) {
        orderPublisher.sendOrder(orderRequest);
        return ResponseEntity.ok("Order successfully placed.");
    }
}
