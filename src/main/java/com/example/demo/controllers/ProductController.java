package com.example.demo.controllers;

import com.example.demo.catalog.Catalog;
import com.example.demo.product.Product;
import com.example.demo.repositories.CatalogRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public Iterable<Product> getProducts(){
        productRepository.findAll().forEach(System.out::println);
        return productRepository.findAll();
    }


}
