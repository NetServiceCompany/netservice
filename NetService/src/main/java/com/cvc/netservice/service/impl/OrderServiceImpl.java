package com.cvc.netservice.service.impl;

import com.cvc.netservice.domain.Order;
import com.cvc.netservice.repository.CustomerRepository;
import com.cvc.netservice.repository.OrderRepository;
import com.cvc.netservice.service.OrderService;
import com.cvc.netservice.service.dto.*;
import com.cvc.netservice.service.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;

    private final OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

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

    private RevenueByTypeDTO filterOrderDetail(List<OrderDetailDTO> dtoList, String[] typeFilter, RevenueDetailDTO infoOrder) {
        List<RevenueDetailDTO> detailDTOList = new LinkedList<>();
        Double sumTotalOrder = 0D;
        for (OrderDetailDTO orderDetailDTO : dtoList) {
            if (Arrays.stream(typeFilter).parallel().anyMatch(orderDetailDTO.getTypeOrder()::contains)) {
                RevenueDetailDTO revenueDetailDTO = new RevenueDetailDTO();
                // Find productName
                revenueDetailDTO.setProductName(orderDetailDTO.getProductName());
                revenueDetailDTO.setCustomerName(infoOrder.getCustomerName());
                revenueDetailDTO.setOrderDate(infoOrder.getOrderDate());

                revenueDetailDTO.setQuantity(orderDetailDTO.getQuantity());
                revenueDetailDTO.setUnitPrice(orderDetailDTO.getUnitPrice());

                sumTotalOrder += orderDetailDTO.getUnitPrice()
                        * orderDetailDTO.getQuantity() * (1 - orderDetailDTO.getDiscount());

                detailDTOList.add(revenueDetailDTO);
            }
        }
        return new RevenueByTypeDTO(detailDTOList, sumTotalOrder);
    }

    private RevenueDTO sumTotalOrder(List<OrderDetailDTO> dtoList) {
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

    private List<OrderDTO> getOrderByDate(LocalDateTime from, LocalDateTime to) {
        return orderRepository.findByOrderDateBetween(from, to).stream()
                .map(orderMapper::toOrderDTO)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    public RevenueDTO getRevenueByDate(LocalDateTime dateTime) throws Exception {
        LocalDateTime from = LocalDateTime.of(dateTime.getYear(), dateTime.getMonth(), dateTime.getDayOfMonth(), 0, 0, 0);
        LocalDateTime to = LocalDateTime.of(dateTime.getYear(), dateTime.getMonth(), dateTime.getDayOfMonth(), 23, 59, 59);

        List<OrderDTO> dtoList = getOrderByDate(from, to);

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

    @Override
    public RevenueByTypeDTO getRevenueByTypeAndDate(LocalDateTime dateTime, String[] type) throws Exception {
        LocalDateTime from = LocalDateTime.of(dateTime.getYear(), dateTime.getMonth(), dateTime.getDayOfMonth(), 0, 0, 0);
        LocalDateTime to = LocalDateTime.of(dateTime.getYear(), dateTime.getMonth(), dateTime.getDayOfMonth(), 23, 59, 59);

        Double sumTotalOrder = 0D;
        RevenueByTypeDTO totalOrder = new RevenueByTypeDTO();
        List<OrderDTO> orderDTOS = getOrderByDate(from, to);
        for (OrderDTO orderDTO : orderDTOS) {
            //find name customer    orderDTO.getCustomerId();
            RevenueDetailDTO revenueDetailDTO = new RevenueDetailDTO();
            revenueDetailDTO.setOrderDate(orderDTO.getOrderDate());
            revenueDetailDTO.setCustomerName(customerRepository.findNameCustomer(orderDTO.getCustomerId()));

            RevenueByTypeDTO revenue = filterOrderDetail(orderDTO.getOrderDetails(), type, revenueDetailDTO);
            totalOrder.getListRevenue().addAll(revenue.getListRevenue());
            sumTotalOrder += revenue.getTotalRevenue();
        }
        totalOrder.setTotalRevenue(sumTotalOrder);
        return totalOrder;
    }
}
