package com.mariazinchyn.myshop.exception;

public class BeanCreationException extends RuntimeException {
    public BeanCreationException(){

    }
    public BeanCreationException(String massage){
        super(massage);
    }
}
