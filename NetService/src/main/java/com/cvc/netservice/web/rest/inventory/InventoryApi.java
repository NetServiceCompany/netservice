package com.cvc.netservice.web.rest.inventory;

import com.cvc.netservice.service.dto.ProductDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/inventory")
public interface InventoryApi {

    @ApiOperation(value = "Check Inventory Goods", notes = "", response = ProductDTO.class, tags = {"INVENTORY",})
    @GetMapping("/findAllGoods")
    ResponseEntity<List<ProductDTO>> findAllMaterials();

}
