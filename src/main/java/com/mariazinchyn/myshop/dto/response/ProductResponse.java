package com.mariazinchyn.myshop.dto.response;

import com.mariazinchyn.myshop.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ProductResponse {
    private Long id;
    private String name;
    private String size;
    private Long price;
    private String image;
    private SubcategoryResponse subcategoryResponse;

    public ProductResponse(Product product){
        id = product.getId();
        name = product.getName();
        size = product.getSize();
        price = product.getPrice();
        image = product.getImage();
        subcategoryResponse = new SubcategoryResponse(product.getSubcategory());


    }




}
