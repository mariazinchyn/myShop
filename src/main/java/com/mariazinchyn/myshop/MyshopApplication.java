package com.mariazinchyn.myshop;

import com.mariazinchyn.myshop.entity.Category;
import com.mariazinchyn.myshop.entity.Subcategory;
import com.mariazinchyn.myshop.repository.CategoryRepository;
import com.mariazinchyn.myshop.repository.ProductRepository;
import com.mariazinchyn.myshop.repository.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.annotation.PostConstruct;

@SpringBootApplication
public class MyshopApplication {
    private final CategoryRepository categoryRepository;
    private final SubcategoryRepository subcategoryRepository;
    private final ProductRepository productRepository;


    @Autowired
   //private CategoryRepository categoryRepository;
    public MyshopApplication(CategoryRepository categoryRepository, SubcategoryRepository subcategoryRepository,
                             ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.subcategoryRepository = subcategoryRepository;
        this.productRepository = productRepository;
    }

   @PostConstruct
   public void init(){
        //Category category = new Category();
       // category.setName("Pants");
       // categoryRepository.save(category);
      //  categoryRepository.findAll().forEach(e -> System.out.println(e.getId() + " " + e.getName()));
    }

    public static void main(String[] args) {
        SpringApplication.run(MyshopApplication.class, args);
    }

}
