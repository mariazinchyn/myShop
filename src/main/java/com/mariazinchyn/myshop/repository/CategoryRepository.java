package com.mariazinchyn.myshop.repository;

import com.mariazinchyn.myshop.entity.Category;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAllByNameLike(String name, Sort sort);
}
