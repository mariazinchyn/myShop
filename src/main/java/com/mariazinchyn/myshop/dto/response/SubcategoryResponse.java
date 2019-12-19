package com.mariazinchyn.myshop.dto.response;

import com.mariazinchyn.myshop.entity.Subcategory;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class SubcategoryResponse {
   private Long id;
    private String name;
    private Long categoryId;

   public SubcategoryResponse(Subcategory subcategory){
       id = subcategory.getId();
      name = subcategory.getName();
     categoryId = subcategory.getCategory().getId();

   }



}
