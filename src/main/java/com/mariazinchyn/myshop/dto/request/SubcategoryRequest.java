package com.mariazinchyn.myshop.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class SubcategoryRequest {
    //private Long id; //21.11

    private String name;
    private Long categoryId;
}
