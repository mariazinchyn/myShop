package com.mariazinchyn.myshop.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter

public class SubcategoryRequest {
    @NotBlank
    private String name;

    @NotNull
    private Long categoryId;
}
