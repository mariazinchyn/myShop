package com.mariazinchyn.myshop.service;

import com.mariazinchyn.myshop.dto.request.SubcategoryRequest;
import com.mariazinchyn.myshop.dto.response.SubcategoryResponse;
import com.mariazinchyn.myshop.entity.Category;
import com.mariazinchyn.myshop.entity.Subcategory;
import com.mariazinchyn.myshop.exception.NoMatchesException;
import com.mariazinchyn.myshop.repository.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        subcategory.setCategory(category);
        subcategoryRepository.save(subcategory);

    }
   public List<SubcategoryResponse> findAllByCategoryId(Long categoryId){
        return subcategoryRepository.findAllByCategoryId(categoryId).stream().map(SubcategoryResponse::new).collect(Collectors.toList());
    }
    public Subcategory findOne(Long id){
        return subcategoryRepository.findById(id).orElseThrow(()-> new NoMatchesException("Subcategory with id " + id + " not exist."));
    }
}
