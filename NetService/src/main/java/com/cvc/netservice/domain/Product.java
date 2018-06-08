package com.cvc.netservice.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product")
public class Product implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "k_id")
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "type_order")
    private String typeOrder;

    @Column(name = "type_product_id")
    private Long typeProductId;

    @Column(name = "group_product_id")
    private Long groupProductId;

    @Column(name = "capital_price")
    private Double capitalPrice;

    @Column(name = "sale_price")
    private Double salePrice;

    @Column(name = "quantity_stock")
    private Double quantityStock;

    @Column(name = "quantity_store")
    private Double quantityStore;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTypeOrder() {
        return typeOrder;
    }

    public void setTypeOrder(String typeOrder) {
        this.typeOrder = typeOrder;
    }

    public Long getTypeProductId() {
        return typeProductId;
    }

    public void setTypeProductId(Long typeProductId) {
        this.typeProductId = typeProductId;
    }

    public Long getGroupProductId() {
        return groupProductId;
    }

    public void setGroupProductId(Long groupProductId) {
        this.groupProductId = groupProductId;
    }

    public Double getCapitalPrice() {
        return capitalPrice;
    }

    public void setCapitalPrice(Double capitalPrice) {
        this.capitalPrice = capitalPrice;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Double getQuantityStock() {
        return quantityStock;
    }

    public void setQuantityStock(Double quantityStock) {
        this.quantityStock = quantityStock;
    }

    public Double getQuantityStore() {
        return quantityStore;
    }

    public void setQuantityStore(Double quantityStore) {
        this.quantityStore = quantityStore;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
