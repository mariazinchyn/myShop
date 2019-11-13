package com.mariazinchyn.myshop.repository;

import com.mariazinchyn.myshop.entity.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {
    @Query("from Subcategory s join s.category c where c.id=: categoriyyaId")
    List<Subcategory> findAllByCategoryId(@Param("categoriyyaId")Long categoryId);
}
