package com.microorderplatform.inventoryservice.repositories.Product;

import com.microorderplatform.inventoryservice.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductModel, UUID> {
}
