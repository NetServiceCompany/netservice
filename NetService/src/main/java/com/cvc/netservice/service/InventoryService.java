package com.cvc.netservice.service;

import com.cvc.netservice.service.dto.GoodsDTO;
import com.cvc.netservice.service.dto.ProductDTO;
import com.cvc.netservice.service.dto.TypeProductDTO;

import java.util.List;

public interface InventoryService {

    List<GoodsDTO> findAllGoods();
}
