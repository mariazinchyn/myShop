package com.mariazinchyn.myshop.controller;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@ToString
public class Person {
    private String name;
    private String surname;
    private Integer age;
}
