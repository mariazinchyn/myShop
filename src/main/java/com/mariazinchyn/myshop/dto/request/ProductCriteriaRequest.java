package com.mariazinchyn.myshop.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ProductCriteriaRequest {
    private String name;
    private Integer minPrice;
    private Integer maxPrice;
    private Long categoryId;
    private Long subcategoryId;

}
