package com.example.demo.services;

import com.example.demo.product.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> getProducts(){
        productRepository.findAll().forEach(System.out::println);
        return productRepository.findAll();
    }

    public Product save(Product product){
        return productRepository.save(product);
    }
}