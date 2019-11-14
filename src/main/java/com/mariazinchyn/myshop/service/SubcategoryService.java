package com.mariazinchyn.myshop.service;

import com.mariazinchyn.myshop.dto.request.SubcategoryRequest;
import com.mariazinchyn.myshop.entity.Category;
import com.mariazinchyn.myshop.entity.Subcategory;
import com.mariazinchyn.myshop.repository.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubcategoryService {
    @Autowired
    private SubcategoryRepository subcategoryRepository;

    @Autowired
    private CategoryService categoryService;

    public void save(SubcategoryRequest request){
        Subcategory subcategory = new Subcategory();
        subcategory.setName(request.getName());
        Category category = categoryService.findOne(request.getCategoryId());
    }
}
