package com.mariazinchyn.myshop.service;

import com.mariazinchyn.myshop.dto.request.ProductRequest;
import com.mariazinchyn.myshop.dto.response.ProductResponse;
import com.mariazinchyn.myshop.entity.Product;
import com.mariazinchyn.myshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service


public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public void save(ProductRequest request){
        Product product = new Product();
        product.setName(request.getName());
        productRepository.save(product);
    }

    public List<ProductResponse> findAll(){
        return productRepository.findAll()
                .stream()
                .map(ProductResponse::new)
                .collect(Collectors.toList());
    }

}
