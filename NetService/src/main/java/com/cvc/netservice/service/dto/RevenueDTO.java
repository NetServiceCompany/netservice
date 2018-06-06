package com.cvc.netservice.service.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class RevenueDTO implements Serializable {

    private Double totalComputerFee;

    private Double totalFoodDrinkFee;

    private Double totalPromotionFee;

    private LocalDateTime currentDate;

    public RevenueDTO() {
    }

    public RevenueDTO(Double totalComputerFee, Double totalFoodDrinkFee, Double totalPromotionFee, LocalDateTime currentDate) {
        this.totalComputerFee = totalComputerFee;
        this.totalFoodDrinkFee = totalFoodDrinkFee;
        this.totalPromotionFee = totalPromotionFee;
        this.currentDate = currentDate;
    }

    public RevenueDTO(Double totalComputerFee, Double totalFoodDrinkFee, Double totalPromotionFee) {
        this.totalComputerFee = totalComputerFee;
        this.totalFoodDrinkFee = totalFoodDrinkFee;
        this.totalPromotionFee = totalPromotionFee;
    }

    public Double getTotalComputerFee() {
        return totalComputerFee;
    }

    public void setTotalComputerFee(Double totalComputerFee) {
        this.totalComputerFee = totalComputerFee;
    }

    public Double getTotalFoodDrinkFee() {
        return totalFoodDrinkFee;
    }

    public void setTotalFoodDrinkFee(Double totalFoodDrinkFee) {
        this.totalFoodDrinkFee = totalFoodDrinkFee;
    }

    public Double getTotalPromotionFee() {
        return totalPromotionFee;
    }

    public void setTotalPromotionFee(Double totalPromotionFee) {
        this.totalPromotionFee = totalPromotionFee;
    }

    public LocalDateTime getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(LocalDateTime currentDate) {
        this.currentDate = currentDate;
    }
}
