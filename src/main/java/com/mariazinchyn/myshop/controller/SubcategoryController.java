package com.mariazinchyn.myshop.controller;

import com.mariazinchyn.myshop.dto.request.SubcategoryRequest;
import com.mariazinchyn.myshop.service.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("subcategory")

public class SubcategoryController {

    @Autowired
    private SubcategoryService subcategoryService;

    @PostMapping
    public void save(@RequestBody SubcategoryRequest request){
        subcategoryService.save(request);
    }
}
