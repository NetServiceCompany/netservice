package com.cvc.netservice.service;

import com.cvc.netservice.service.dto.OrderDTO;
import com.cvc.netservice.service.dto.RevenueDTO;

import java.time.LocalDateTime;

public interface OrderService {

    Long createOrder(OrderDTO orderDTO) throws Exception;

    RevenueDTO getRevenueByDate(LocalDateTime dateTime) throws Exception;

}
