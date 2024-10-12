package com.microorderplatform.inventoryservice.configurations;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    // exchanges
    @Value("${rabbitmq.exchange.order}")
    private String orderExchange;

    @Value("${rabbitmq.exchange.log}")
    private String logExchange;

    // queues
    @Value("${rabbitmq.queue.order.created}")
    private String orderCreatedQueue;

    @Value("${rabbitmq.queue.order.updated}")
    private String orderUpdatedQueue;

    @Value("${rabbitmq.queue.inventory.updated}")
    private String inventoryUpdatedQueue;

    @Value("${rabbitmq.queue.log}")
    private String logQueue;

    // routing keys
    @Value("${rabbitmq.routing.key.order.created}")
    private String orderCreatedRoutingKey;

    @Value("${rabbitmq.routing.key.order.updated}")
    private String orderUpdatedRoutingKey;

    @Value("${rabbitmq.routing.key.inventory.updated}")
    private String inventoryUpdatedRoutingKey;

    @Value("${rabbitmq.routing.key.log.event}")
    private String logEventRoutingKey;

    @Bean
    public TopicExchange orderExchange() {
        return new TopicExchange(orderExchange);
    }

    @Bean
    public TopicExchange logExchange() {
        return new TopicExchange(logExchange);
    }

    // queues
    @Bean
    public Queue orderCreatedQueue() {
        return new Queue(orderCreatedQueue);
    }

    @Bean
    public Queue orderUpdatedQueue() {
        return new Queue(orderUpdatedQueue);
    }

    @Bean
    public Queue inventoryUpdatedQueue() {
        return new Queue(inventoryUpdatedQueue);
    }

    @Bean
    public Queue logQueue() {
        return new Queue(logQueue);
    }

    // Bindings
    @Bean
    public Binding orderCreatedBinding(TopicExchange orderExchange, Queue orderCreatedQueue) {
        return BindingBuilder.bind(orderCreatedQueue).to(orderExchange).with(orderCreatedRoutingKey);
    }

    @Bean
    public Binding orderUpdatedBinding(TopicExchange orderExchange, Queue orderUpdatedQueue) {
        return BindingBuilder.bind(orderUpdatedQueue).to(orderExchange).with(orderUpdatedRoutingKey);
    }

    @Bean
    public Binding inventoryUpdatedBinding(TopicExchange orderExchange, Queue inventoryUpdatedQueue) {
        return BindingBuilder.bind(inventoryUpdatedQueue).to(orderExchange).with(inventoryUpdatedRoutingKey);
    }

    @Bean
    public Binding logBinding(TopicExchange logExchange, Queue logQueue) {
        return BindingBuilder.bind(logQueue).to(logExchange).with(logEventRoutingKey);
    }

    @Bean
    public Jackson2JsonMessageConverter mensageConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        return new Jackson2JsonMessageConverter(objectMapper);
    }
}
