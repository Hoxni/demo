package com.example.demo.controllers;

import com.example.demo.catalog.Catalog;
import com.example.demo.catalog.CatalogUpdateModel;
import com.example.demo.product.Product;
import com.example.demo.repositories.CatalogRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/products/catalogs")
public class CatalogController {

    private final CatalogRepository catalogRepository;
    private final ProductRepository productRepository;

    public CatalogController(CatalogRepository catalogRepository, ProductRepository productRepository) {
        this.catalogRepository = catalogRepository;
        this.productRepository = productRepository;
    }

    @GetMapping("/active")
    public Catalog getActiveCatalog(){
        for (Catalog c: catalogRepository.findAll()) {
            if (c.isActive()){
                System.out.println("Active catalog " + c);
                return c;
            }
        }
        return new Catalog();
    }

    @PutMapping("/{id}")
    public void saveCatalog(@PathVariable Long id, @RequestBody CatalogUpdateModel catalogUpdateModel){
        System.out.println("Save catalog request");
        Catalog catalog = catalogRepository.findById(id).get();
        List<Product> products = new ArrayList<>();
        for (Long prodId: catalogUpdateModel.getProductsIds()) {
            System.out.println("\t Save catalog prodId " + prodId);
            Product product = productRepository.findById(prodId).get();
            products.add(product);
        }
        catalog.setProducts(products);
        catalogRepository.save(catalog);
        System.out.println(catalog);
    }
}
