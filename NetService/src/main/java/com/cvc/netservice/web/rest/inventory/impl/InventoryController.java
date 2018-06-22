package com.cvc.netservice.web.rest.inventory.impl;

import com.cvc.netservice.service.InventoryService;
import com.cvc.netservice.service.dto.GoodsDTO;
import com.cvc.netservice.web.rest.inventory.InventoryApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class InventoryController implements InventoryApi {

    @Autowired
    private InventoryService inventoryService;


    @Override
    public ResponseEntity<List<GoodsDTO>> findAllGoods() {
        List<GoodsDTO> goodsDTOS = inventoryService.findAllGoods();
        return ResponseEntity.ok(goodsDTOS);
    }
}
