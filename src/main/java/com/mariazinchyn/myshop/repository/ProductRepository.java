package com.mariazinchyn.myshop.repository;

import com.mariazinchyn.myshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    @Query("from Product p join p.subcategory s join s.category c where c.id=:categoryId")
    List<Product> findAllByCategoryId(@Param("categoryId") Long categoryId);

}
