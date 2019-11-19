package com.mariazinchyn.myshop.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ProductRequest {
    private Long id;
    private String name;
    private Long price;
    private String image;
    private String size;

}
