package com.example.E_commerce_chala.controller;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Webconfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Permite CORS en todas las rutas de la API
                .allowedOrigins("http://localhost:5173")  // Tu frontend (puerto de React)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Métodos permitidos
                .allowedHeaders("*");  // Acepta todos los headers
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Esto le dice a Spring: si te piden /uploads/**, busca en la carpeta física /uploads
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:uploads/");
    }
}
