package com.mariazinchyn.myshop.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long price;

    private String size;

    private String photo; // Тут має бути лінк на фото товару
    // 31.10.2019

    //private String description;

   // private Double rating;
    //private Long subcategoryId;

    @ManyToOne
    private Subcategory subcategory;

    @ManyToMany(mappedBy = "favoriteProducts")
    private List<User> users = new ArrayList<>();

    //public void getPhoto(String photo) {/ }
}
