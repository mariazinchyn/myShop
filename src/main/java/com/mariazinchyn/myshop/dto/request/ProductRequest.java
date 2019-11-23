package com.mariazinchyn.myshop.dto.request;

import com.mariazinchyn.myshop.entity.Subcategory;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Example;

@Getter
@Setter

public class ProductRequest {

    private Long id;
    private String name;
    private Long price;
    private String image;
    private String size;
    private Long subcategoryId;

}
