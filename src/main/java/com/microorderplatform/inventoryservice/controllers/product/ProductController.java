package com.microorderplatform.inventoryservice.controllers.product;

import com.microorderplatform.inventoryservice.DTOs.ProductDTO;
import com.microorderplatform.inventoryservice.models.ProductModel;
import com.microorderplatform.inventoryservice.services.Inventory.InventoryService;
import com.microorderplatform.inventoryservice.services.Product.ProductService;
import lombok.Getter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;



    @PostMapping("/products")
    public ResponseEntity<ProductModel> saveNewProduct(@RequestBody ProductDTO productDTO){

        ProductModel productModel = new ProductModel();
        BeanUtils.copyProperties(productDTO, productModel);
        productModel = productService.saveProduct(productModel);
        return new ResponseEntity<>(productModel, HttpStatus.CREATED);
    }

    @GetMapping("/products")
    public ResponseEntity<Iterable<ProductModel>> getAllProducts(){
        Iterable<ProductModel> productModels = productService.findAllProducts();
        return new ResponseEntity<>(productModels, HttpStatus.OK);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<ProductModel> updateProduct(@PathVariable("id") UUID id, @RequestBody ProductDTO productDTO){
        ProductModel productModel = productService.findProductById(id);
        if(productModel == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        BeanUtils.copyProperties(productDTO, productModel);
        productModel = productService.saveProduct(productModel);
        return new ResponseEntity<>(productModel, HttpStatus.OK);
    }
}
