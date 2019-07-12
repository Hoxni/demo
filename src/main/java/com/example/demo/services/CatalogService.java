package com.example.demo.services;


import com.example.demo.catalog.Catalog;
import com.example.demo.catalog.CatalogUpdateModel;
import com.example.demo.product.Product;
import com.example.demo.repositories.CatalogRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CatalogService {

    @Autowired
    private CatalogRepository catalogRepository;
    @Autowired
    private ProductRepository productRepository;

    public Catalog getActiveCatalog(){
        for (Catalog c: catalogRepository.findAll()) {
            if (c.isActive()){
                System.out.println("Active catalog " + c);
                return c;
            }
        }
        return new Catalog();
    }

    private List<Product> getProducts(CatalogUpdateModel catalogUpdateModel){
        List<Product> products = new ArrayList<>();
        for (Long prodId: catalogUpdateModel.getProductsIds()) {
            System.out.println("\t Update catalog prodId " + prodId);

            Optional<Product> product = productRepository.findById(prodId);
            product.ifPresent(products::add); //products.add(product)
        }
        return products;
    }

    public void update(Long id, CatalogUpdateModel catalogUpdateModel){
        System.out.println("Save catalog request");

        Optional<Catalog> catalog = catalogRepository.findById(id);
        catalog.ifPresent(value -> {
            value.setProducts(getProducts(catalogUpdateModel));
            catalogRepository.save(value);
            System.out.println(value);
        });
    }
}
