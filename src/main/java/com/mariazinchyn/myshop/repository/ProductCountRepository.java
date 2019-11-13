package com.mariazinchyn.myshop.repository;

import com.mariazinchyn.myshop.entity.ProductCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductCountRepository extends JpaRepository<ProductCount, Long> {
}
