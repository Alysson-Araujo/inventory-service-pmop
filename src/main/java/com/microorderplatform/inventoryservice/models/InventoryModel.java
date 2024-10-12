package com.microorderplatform.inventoryservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;


@Entity
@Table(name = "TB_INVENTORY")
@Getter
@Setter
public class InventoryModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "product_id", nullable = false, referencedColumnName = "id")
    private ProductModel product;

    private int quantity;
}