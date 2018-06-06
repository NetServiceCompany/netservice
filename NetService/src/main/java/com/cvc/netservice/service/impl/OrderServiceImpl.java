package com.cvc.netservice.service.impl;

import com.cvc.netservice.domain.Order;
import com.cvc.netservice.repository.OrderRepository;
import com.cvc.netservice.service.OrderService;
import com.cvc.netservice.service.dto.OrderDTO;
import com.cvc.netservice.service.dto.OrderDetailDTO;
import com.cvc.netservice.service.dto.RevenueDTO;
import com.cvc.netservice.service.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderMapper orderMapper, OrderRepository orderRepository) {
        this.orderMapper = orderMapper;
        this.orderRepository = orderRepository;
    }

    @Override
    public Long createOrder(OrderDTO orderDTO) throws Exception {
        Order order = orderMapper.toEntity(orderDTO);
        orderRepository.save(order);
        return orderRepository.findFirstByOrderByIdDesc().getId();
    }

    public RevenueDTO sumTotalOrder(List<OrderDetailDTO> dtoList) {
        Double sumComputer = 0D;
        Double sumFoodDrink = 0D;
        Double sumPromotion = 0D;

        for (OrderDetailDTO orderDetailDTO : dtoList) {
            if (orderDetailDTO.getTypeOrder().contains("an") || orderDetailDTO.getTypeOrder().contains("uong")) {
                sumFoodDrink += orderDetailDTO.getUnitPrice()
                        * orderDetailDTO.getQuantity() * (1 - orderDetailDTO.getDiscount());
            }

            if (orderDetailDTO.getTypeOrder().contains("nap tien")) {
                sumComputer += orderDetailDTO.getUnitPrice()
                        * orderDetailDTO.getQuantity() * (1 - orderDetailDTO.getDiscount());
            }

            if (orderDetailDTO.getTypeOrder().contains("khuyen mai")) {
                sumPromotion += orderDetailDTO.getUnitPrice()
                        * orderDetailDTO.getQuantity() * (1 - orderDetailDTO.getDiscount());
            }
        }

        return new RevenueDTO(sumComputer, sumFoodDrink, sumPromotion);
    }

    @Override
    public RevenueDTO getRevenueByDate(LocalDateTime dateTime) throws Exception {

        LocalDateTime from = LocalDateTime.of(dateTime.getYear(), dateTime.getMonth(), dateTime.getDayOfMonth(), 0, 0, 0);
        LocalDateTime to = LocalDateTime.of(dateTime.getYear(), dateTime.getMonth(), dateTime.getDayOfMonth(), 23, 59, 59);

        List<OrderDTO> dtoList = orderRepository.findByOrderDateBetween(from,to).stream()
                .map(orderMapper::toOrderDTO)
                .collect(Collectors.toCollection(LinkedList::new));
        Timestamp timestamp = Timestamp.valueOf(dateTime);
        Double sumComputer = 0D;
        Double sumFoodDrink = 0D;
        Double sumPromotion = 0D;

        for (OrderDTO orderDTO : dtoList) {
            if (orderDTO.getOrderDetails().size() != 0) {
                RevenueDTO revenueDTO = sumTotalOrder(orderDTO.getOrderDetails());
                sumComputer += revenueDTO.getTotalComputerFee();
                sumFoodDrink += revenueDTO.getTotalFoodDrinkFee();
                sumPromotion += revenueDTO.getTotalPromotionFee();
            }
        }
        return new RevenueDTO(sumComputer, sumFoodDrink, sumPromotion, dateTime);
    }
}
