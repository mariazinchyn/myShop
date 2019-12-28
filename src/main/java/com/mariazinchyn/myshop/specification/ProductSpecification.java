package com.mariazinchyn.myshop.specification;

import com.mariazinchyn.myshop.dto.request.ProductCriteriaRequest;
import com.mariazinchyn.myshop.entity.Category;
import com.mariazinchyn.myshop.entity.Product;
import com.mariazinchyn.myshop.entity.Subcategory;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class ProductSpecification implements Specification<Product> {
    private String name;
    private Integer minPrice;
    private Integer maxPrice;
    private Long categoryId;
    private Long subcategoryId;

    public ProductSpecification(ProductCriteriaRequest productCriteria) {
        this.name = productCriteria.getName();
        this.minPrice = productCriteria.getMinPrice();
        this.maxPrice = productCriteria.getMaxPrice();
        this.categoryId = productCriteria.getCategoryId();
        this.subcategoryId = productCriteria.getSubcategoryId();
    }

    @Override
    public Predicate toPredicate(Root<Product> root,
                                 CriteriaQuery<?> cq,
                                 CriteriaBuilder cb) {
       // return cb.le(root.get("price"), maxPrice);
        final List<Predicate> predicates = new ArrayList<>();
        predicates.add(findByNameLike(root, cb));
        predicates.add(findByPrice(root, cb));
        predicates.add(findByCategoryAndSubcategory(root, cb));

        return cb.and(predicates.toArray(new Predicate[0]));

    }

    private Predicate findByCategoryAndSubcategory(Root<Product> root, CriteriaBuilder cb) {
        if (subcategoryId != null) {
            Join<Product, Subcategory> joinSubcategory =
                    root.join("subcategory");

            return cb.equal(joinSubcategory.get("id"), subcategoryId);
        } else if (categoryId != null) {
            Join<Product, Subcategory> joinSubcategory =
                    root.join("subcategory");

            Join<Subcategory, Category> joinCategory =
                    joinSubcategory.join("category");

            //root.get("id") Product.id
            //joinSubcategory.get("id") Subcategory.id
            //joinCategory.get("id") Category.id
            return cb.equal(joinCategory.get("id"), categoryId);
        } else {
            return cb.conjunction();

        }
    }

    private Predicate findByPrice(Root<Product> root, CriteriaBuilder cb) {
        if (minPrice != null && maxPrice != null) {
            return cb.between(root.get("price"), minPrice, maxPrice);
        } else if (minPrice != null) {
            return cb.ge(root.get("price"), minPrice);
        } else if (maxPrice != null) {
            return cb.le(root.get("price"), maxPrice);
        } else {
            return cb.conjunction();
        }
    }

    private Predicate findByNameLike(Root<Product> root, CriteriaBuilder cb) {
        if (name == null || name.isEmpty()) {
            return cb.conjunction();
        } else {
            return cb.like(root.get("name"), "%" + name + "%");
        }
    }
}
