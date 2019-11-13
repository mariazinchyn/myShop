package com.mariazinchyn.myshop.controller;

import com.mariazinchyn.myshop.entity.Category;
import com.mariazinchyn.myshop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController

public class TestController {

    @GetMapping
    public String test1(){

        return "Hello World!";
    }
    @GetMapping("/test2")
    public Double test2(){

        return Math.random()*100;
    }

    @GetMapping("/test3")
    public Person test3(){
        return Person.builder()
                .name("Maria")
                .surname("Zinchyn")
                .age(37)
                .build();

    }

    @GetMapping("/te{var}st6")
    public String test6(@PathVariable String var){
        return var;
    }

    @Autowired
    private CategoryRepository categoryRepository;
    @GetMapping("/category-{id}")
    public String test6(@PathVariable Long id){
        return categoryRepository.findById(id)
                .orElse(new Category())
                .getName();
    }

    @PostMapping
    public String testPost(Person person){
        return person.toString();
    }

    @GetMapping("/test55")
    public Integer test55(Integer from, Integer to){
        return new Random().nextInt(to - from) + from;
    }
}
