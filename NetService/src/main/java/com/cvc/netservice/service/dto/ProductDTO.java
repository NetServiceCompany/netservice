package com.cvc.netservice.service.dto;

import java.io.Serializable;

public class ProductDTO implements Serializable {


    private Long id;

    private String productName;

    private String typeOrder;

    private Long typeProductId;

    private Long groupProductId;

    private Double capitalPrice;

    private Double salePrice;

    private Double quantityStock;

    private Double quantityStore;

    private String description;

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
