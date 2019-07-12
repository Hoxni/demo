package com.example.demo.controllers;

import com.example.demo.product.Product;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Iterable<Product> getProducts(){
        return productService.getProducts();
    }

    @PostMapping
    public void addProduct(@RequestBody Product product){
        productService.save(product);
    }

}
