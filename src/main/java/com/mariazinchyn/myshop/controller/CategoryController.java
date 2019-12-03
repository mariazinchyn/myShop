package com.mariazinchyn.myshop.controller;

import com.mariazinchyn.myshop.dto.request.CategoryRequest;
import com.mariazinchyn.myshop.dto.response.CategoryResponse;
import com.mariazinchyn.myshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public void save(@Valid @RequestBody CategoryRequest request){
        categoryService.save(request);
    }

    @GetMapping
    public List<CategoryResponse> findAll(@RequestParam(defaultValue = "id") String fieldName) {
        return categoryService.findAll(fieldName);
    }
   // public List<CategoryResponse> findAll(){
   //     return categoryService.findAll();
   // }

    @GetMapping("/one/{id}")
    public CategoryResponse findOne(@PathVariable Long id) {
        return categoryService.findOneResponse(id);
    }

    @PutMapping
    public  void update(@Valid @RequestBody CategoryRequest request, Long id){
        categoryService.update(request, id);
    }

    @DeleteMapping
    public void delete(Long id){
        categoryService.delete(id);
    }
}
