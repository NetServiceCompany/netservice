package com.cvc.netservice.service.mapper;

import com.cvc.netservice.domain.Product;
import com.cvc.netservice.service.dto.ProductDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-06-08T10:56:27+0700",
    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_92 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDTO toProductDTO(Product entity) {
        if ( entity == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setId( entity.getId() );
        productDTO.setProductName( entity.getProductName() );
        productDTO.setTypeOrder( entity.getTypeOrder() );
        productDTO.setTypeProductId( entity.getTypeProductId() );
        productDTO.setGroupProductId( entity.getGroupProductId() );
        productDTO.setCapitalPrice( entity.getCapitalPrice() );
        productDTO.setSalePrice( entity.getSalePrice() );
        productDTO.setQuantityStock( entity.getQuantityStock() );
        productDTO.setQuantityStore( entity.getQuantityStore() );
        productDTO.setDescription( entity.getDescription() );
        productDTO.setStatus( entity.getStatus() );

        return productDTO;
    }

    @Override
    public Product toEntity(ProductDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( dto.getId() );
        product.setProductName( dto.getProductName() );
        product.setTypeOrder( dto.getTypeOrder() );
        product.setTypeProductId( dto.getTypeProductId() );
        product.setGroupProductId( dto.getGroupProductId() );
        product.setCapitalPrice( dto.getCapitalPrice() );
        product.setSalePrice( dto.getSalePrice() );
        product.setQuantityStock( dto.getQuantityStock() );
        product.setQuantityStore( dto.getQuantityStore() );
        product.setDescription( dto.getDescription() );
        product.setStatus( dto.getStatus() );

        return product;
    }
}
