package com.cvc.netservice.service.impl;

import com.cvc.netservice.domain.TypeProduct;
import com.cvc.netservice.repository.InventoryRepository;
import com.cvc.netservice.repository.TypeProductRepository;
import com.cvc.netservice.service.InventoryService;
import com.cvc.netservice.service.common.Constants;
import com.cvc.netservice.service.dto.ProductDTO;
import com.cvc.netservice.service.dto.TypeProductDTO;
import com.cvc.netservice.service.mapper.ProductMapper;
import com.cvc.netservice.service.mapper.TypeProductMapper;
import org.springframework.beans.PropertyAccessor;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    private final ProductMapper productMapper;

    public InventoryServiceImpl(InventoryRepository inventoryRepository, ProductMapper productMapper) {
        this.inventoryRepository = inventoryRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDTO> findAllGoods() {
        return inventoryRepository.findAllByTypeProductId(Constants.TYPE_MATERIAL_ID)
                .stream().map(productMapper::toProductDTO).collect(Collectors.toCollection(LinkedList::new));

    }


}
