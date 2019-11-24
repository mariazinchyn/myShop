package com.mariazinchyn.myshop.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class ProductRequest {

    private Long id;
    @NotBlank
    private String name;

    @Positive
    @NotNull
    private Long price;
    private String image;
    private String size;

    @NotNull
    private Long subcategoryId;

}
