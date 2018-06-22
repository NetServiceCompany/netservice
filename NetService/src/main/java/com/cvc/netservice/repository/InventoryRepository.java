package com.cvc.netservice.repository;

import com.cvc.netservice.domain.Goods;
import com.cvc.netservice.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Goods,Long> {

    @Query("SELECT g from Goods g where g.basicUnitId is null")
    List<Goods> findAllGoods();
}
