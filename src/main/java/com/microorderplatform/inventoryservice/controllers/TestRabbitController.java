package com.microorderplatform.inventoryservice.controllers;


import com.microorderplatform.inventoryservice.services.TestRabbitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRabbitController {

    @Autowired
    private TestRabbitService testRabbitService;

    @PostMapping("/test-rabbit")
    public String testRabbit() {

        return "Message sent to RabbitMQ";
    }
}
