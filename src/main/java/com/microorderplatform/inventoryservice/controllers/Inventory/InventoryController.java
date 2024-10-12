package com.microorderplatform.inventoryservice.controllers.Inventory;


import com.microorderplatform.inventoryservice.DTOs.InventoryDTO;
import com.microorderplatform.inventoryservice.DTOs.ProductUpdateDTO;
import com.microorderplatform.inventoryservice.models.InventoryModel;
import com.microorderplatform.inventoryservice.models.ProductModel;
import com.microorderplatform.inventoryservice.services.Inventory.InventoryService;
import com.microorderplatform.inventoryservice.services.Product.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private ProductService productService;

    @PostMapping("/inventory")
    public ResponseEntity<InventoryModel> saveInventory(@RequestBody @Valid InventoryDTO inventoryDTO) {
        try {
            ProductModel productModel = productService.findProductById(inventoryDTO.idProduct());

            if (productModel == null) {
                throw new RuntimeException("Product not found");
            }

            boolean isProductInInventory = inventoryService.isProductInInventory(inventoryDTO.idProduct());

            if (isProductInInventory) {
                throw new RuntimeException("Product already in inventory");
            }

            InventoryModel inventoryModel = new InventoryModel();
            inventoryModel.setProduct(productModel);
            inventoryModel.setQuantity(inventoryDTO.quantity());

            InventoryModel savedInventory = inventoryService.saveInventory(inventoryModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedInventory);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/inventory")
    public ResponseEntity<InventoryModel> updateInventory(@RequestBody @Valid ProductUpdateDTO productUpdateDTO) {
        try {

            ProductModel productModel = productService.findProductById(productUpdateDTO.productId());
            if (productModel == null) {
                throw new RuntimeException("Product not found");
            }


            boolean isProductInInventory = inventoryService.isProductInInventory(productUpdateDTO.productId());
            if (!isProductInInventory) {
                throw new RuntimeException("Product not in inventory");
            }


            InventoryModel inventoryModel = inventoryService.findInventoryByProductId(productUpdateDTO.productId());
            if (inventoryModel == null) {
                throw new RuntimeException("Inventory not found for product");
            }


            inventoryModel.setQuantity(productUpdateDTO.quantity());
            inventoryModel.setProduct(productModel); //


            InventoryModel savedInventory = inventoryService.saveInventory(inventoryModel);
            return ResponseEntity.status(HttpStatus.OK).body(savedInventory);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/inventory")
    public ResponseEntity<Iterable<InventoryModel>> getAllInventories() {
        try {
            Iterable<InventoryModel> inventoryModels = inventoryService.findAllInventories();
            return ResponseEntity.status(HttpStatus.OK).body(inventoryModels);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}