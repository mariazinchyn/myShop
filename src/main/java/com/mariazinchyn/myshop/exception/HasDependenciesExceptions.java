package com.mariazinchyn.myshop.exception;

public class HasDependenciesExceptions extends RuntimeException {
    public HasDependenciesExceptions(){
    }
    public HasDependenciesExceptions(String message){
        super(message);
    }
}
