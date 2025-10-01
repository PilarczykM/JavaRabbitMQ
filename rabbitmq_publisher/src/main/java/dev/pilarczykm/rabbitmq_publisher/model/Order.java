package dev.pilarczykm.rabbitmq_publisher.model;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    private String id;
    private String product;
    private Date date;
}
