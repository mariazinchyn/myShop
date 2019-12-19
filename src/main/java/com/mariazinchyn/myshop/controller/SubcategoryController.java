package com.mariazinchyn.myshop.controller;

import com.mariazinchyn.myshop.dto.request.SubcategoryRequest;
import com.mariazinchyn.myshop.dto.response.SubcategoryResponse;
import com.mariazinchyn.myshop.service.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/subcategory")

public class SubcategoryController {

    @Autowired
    private SubcategoryService subcategoryService;

    @PostMapping
    public void save(@Valid @RequestBody SubcategoryRequest request) {
        subcategoryService.save(request);
    }


    @GetMapping("/byCategoryId/{categoryId}")
    public List<SubcategoryResponse> findAllByCategoryId(@PathVariable Long categoryId) {
      return subcategoryService.findAllByCategoryId(categoryId);
    }

}
