package com.cvc.netservice.service.mapper;

import com.cvc.netservice.domain.Customer;
import com.cvc.netservice.service.dto.CustomerDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-06-10T13:52:49+0700",
    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_92 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDTO toCustomerDTO(Customer entity) {
        if ( entity == null ) {
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setId( entity.getId() );
        customerDTO.setFirstName( entity.getFirstName() );
        customerDTO.setLastName( entity.getLastName() );
        customerDTO.setBirthDate( entity.getBirthDate() );
        customerDTO.setAddress( entity.getAddress() );
        customerDTO.setPhone( entity.getPhone() );
        customerDTO.setRewardPoint( entity.getRewardPoint() );
        customerDTO.setStatus( entity.getStatus() );

        return customerDTO;
    }

    @Override
    public Customer toEntity(CustomerDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( dto.getId() );
        customer.setFirstName( dto.getFirstName() );
        customer.setLastName( dto.getLastName() );
        customer.setBirthDate( dto.getBirthDate() );
        customer.setAddress( dto.getAddress() );
        customer.setPhone( dto.getPhone() );
        customer.setRewardPoint( dto.getRewardPoint() );
        customer.setStatus( dto.getStatus() );

        return customer;
    }
}
