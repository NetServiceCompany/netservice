package com.cvc.netservice.repository;

import com.cvc.netservice.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Product,Long> {

    List<Product> findAllByTypeProductId(Long id);
}
