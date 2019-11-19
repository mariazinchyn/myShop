package com.mariazinchyn.myshop.controller;

import com.mariazinchyn.myshop.dto.request.ProductRequest;
import com.mariazinchyn.myshop.dto.response.ProductResponse;
import com.mariazinchyn.myshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")

public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public void save(@RequestBody ProductRequest request){
        productService.save(request);
            }

     @GetMapping
    public List<ProductResponse> findAll(){
        return productService.findAll();
         }
    }
