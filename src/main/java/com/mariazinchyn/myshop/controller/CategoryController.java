package com.mariazinchyn.myshop.controller;

import com.mariazinchyn.myshop.dto.request.CategoryRequest;
import com.mariazinchyn.myshop.dto.response.CategoryResponse;
import com.mariazinchyn.myshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public void save(@RequestBody CategoryRequest request){
        categoryService.save(request);

    }

    @GetMapping
    public List<CategoryResponse> findAll(){
       return categoryService.findAll();
    }
}
