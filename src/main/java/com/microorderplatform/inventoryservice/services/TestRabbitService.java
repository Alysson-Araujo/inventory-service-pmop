package com.microorderplatform.inventoryservice.services;

import com.microorderplatform.inventoryservice.producers.InventoryProducer;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestRabbitService {

    @Autowired
    private InventoryProducer inventoryProducer;

}
