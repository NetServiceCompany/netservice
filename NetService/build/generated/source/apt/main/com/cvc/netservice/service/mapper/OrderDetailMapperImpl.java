package com.cvc.netservice.service.mapper;

import com.cvc.netservice.domain.OrderDetail;
import com.cvc.netservice.service.dto.OrderDetailDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-06-06T12:47:30+0700",
    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class OrderDetailMapperImpl implements OrderDetailMapper {

    @Override
    public OrderDetailDTO toOrderDetailDTO(OrderDetail entity) {
        if ( entity == null ) {
            return null;
        }

        OrderDetailDTO orderDetailDTO = new OrderDetailDTO();

        orderDetailDTO.setId( entity.getId() );
        orderDetailDTO.setOrderId( entity.getOrderId() );
        orderDetailDTO.setProductId( entity.getProductId() );
        orderDetailDTO.setDiscount( entity.getDiscount() );
        orderDetailDTO.setQuantity( entity.getQuantity() );
        orderDetailDTO.setProductName( entity.getProductName() );
        orderDetailDTO.setTypeOrder( entity.getTypeOrder() );
        orderDetailDTO.setUnitPrice( entity.getUnitPrice() );

        return orderDetailDTO;
    }

    @Override
    public OrderDetail toEntity(OrderDetailDTO dto) {
        if ( dto == null ) {
            return null;
        }

        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setId( dto.getId() );
        orderDetail.setOrderId( dto.getOrderId() );
        orderDetail.setProductId( dto.getProductId() );
        orderDetail.setDiscount( dto.getDiscount() );
        orderDetail.setQuantity( dto.getQuantity() );
        orderDetail.setProductName( dto.getProductName() );
        orderDetail.setTypeOrder( dto.getTypeOrder() );
        orderDetail.setUnitPrice( dto.getUnitPrice() );

        return orderDetail;
    }
}
