package com.mariazinchyn.myshop.controller;

import com.mariazinchyn.myshop.dto.request.ProductRequest;

import com.mariazinchyn.myshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
     public void update(@Valid @RequestBody ProductRequest request, Long id) {
         productService.update(request, id);
            }


    }

