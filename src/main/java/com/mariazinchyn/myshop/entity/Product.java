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

    private String photo;



    @ManyToOne
    private Subcategory subcategory;

    @ManyToMany(mappedBy = "favoriteProducts")
    private List<User> users = new ArrayList<>();


}
