package com.mariazinchyn.myshop.controller;

import com.mariazinchyn.myshop.dto.request.ProductRequest;

import com.mariazinchyn.myshop.dto.response.PageResponse;
import com.mariazinchyn.myshop.dto.response.ProductResponse;
import com.mariazinchyn.myshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/product")

public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public void save(@Valid @RequestBody ProductRequest request){
        productService.save(request);
            }

     @GetMapping
     public PageResponse<ProductResponse> findPage(
             @RequestParam Integer page,
             @RequestParam Integer size,
             @RequestParam(defaultValue = "name") String fieldName,
             @RequestParam(defaultValue = "ASC") Sort.Direction direction
     ) {
         return productService.findPage(page, size, fieldName, direction);

     }

      @PutMapping
     public void update(@Valid @RequestBody ProductRequest request, Long id) {
        productService.update(request, id);
           }


    }

