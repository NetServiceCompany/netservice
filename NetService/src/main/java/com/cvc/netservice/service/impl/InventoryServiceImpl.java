package com.cvc.netservice.service.impl;

import com.cvc.netservice.repository.InventoryRepository;
import com.cvc.netservice.service.InventoryService;
import com.cvc.netservice.service.dto.GoodsDTO;
import com.cvc.netservice.service.dto.ProductDTO;
import com.cvc.netservice.service.mapper.GoodsMapper;
import com.cvc.netservice.service.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    private final GoodsMapper goodsMapper;

    public InventoryServiceImpl(InventoryRepository inventoryRepository, GoodsMapper goodsMapper) {
        this.inventoryRepository = inventoryRepository;
        this.goodsMapper = goodsMapper;
    }

    @Override
    public List<GoodsDTO> findAllGoods() {
        return inventoryRepository.findAllGoods()
                .stream().map(goodsMapper::toGoodsDTO).collect(Collectors.toCollection(LinkedList::new));
    }


}
