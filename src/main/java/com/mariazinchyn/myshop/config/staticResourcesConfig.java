package com.mariazinchyn.myshop.config;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Paths;

import static com.mariazinchyn.myshop.service.FileService.IMG_DIR;

public class staticResourcesConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**")
                .addResourceLocations(Paths.get(IMG_DIR).toUri().toString());

    }
}
