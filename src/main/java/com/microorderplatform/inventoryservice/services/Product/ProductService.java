package com.microorderplatform.inventoryservice.services.Product;


import com.microorderplatform.inventoryservice.DTOs.ProductDTO;
import com.microorderplatform.inventoryservice.models.InventoryModel;
import com.microorderplatform.inventoryservice.models.ProductModel;
import com.microorderplatform.inventoryservice.repositories.Product.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public ProductModel saveProduct(ProductModel productModel) {
        return productRepository.save(productModel);
    }

    public ProductModel findProductById(UUID id) {
        return productRepository.findById(id).orElse(null);
    }

    public Iterable<ProductModel> findAllProducts() {
        return productRepository.findAll();
    }


}
