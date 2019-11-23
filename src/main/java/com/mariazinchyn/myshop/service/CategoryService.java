package com.mariazinchyn.myshop.service;

import com.mariazinchyn.myshop.dto.request.CategoryRequest;
import com.mariazinchyn.myshop.dto.response.CategoryResponse;
import com.mariazinchyn.myshop.entity.Category;
import com.mariazinchyn.myshop.exception.HasDependenciesExceptions;
import com.mariazinchyn.myshop.exception.NoMatchesException;
import com.mariazinchyn.myshop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service


public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public void save(CategoryRequest request){
        Category category = new Category();
        category.setName(request.getName());
        categoryRepository.save(category);
    }

    public void update(CategoryRequest request, Long id){
       // Category category = findOne(id);
      //  category.setName(request.getName());
      //  categoryRepository.save(category);
        categoryRepository.save(categoryRequestToCategory(findOne(id),request));


    }
    public List<CategoryResponse> findAll(){
        return categoryRepository.findAll().stream()
                .map(CategoryResponse::new)
                .collect(Collectors.toList())
                ;
    }
    public Category findOne(Long id){
        return categoryRepository.findById(id).orElseThrow(() -> new NoMatchesException("Category with id " + id + "not exist"));

    }
    public void delete(Long id){
        Category category = findOne(id);
        if(category.getSubcategories().isEmpty()){
            categoryRepository.delete(category);
        }else{
            throw new HasDependenciesExceptions("Cannot delete category with id " + id + " because it has dependencies.");
        }

    }
    private Category categoryRequestToCategory(Category category, CategoryRequest request){
        if(category == null){
            category = new Category();
        }
        category.setName(request.getName());
        return category;
    }
}
