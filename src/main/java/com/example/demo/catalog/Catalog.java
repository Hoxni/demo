package com.example.demo.catalog;

import com.example.demo.order.OrderItem;
import com.example.demo.product.Product;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Catalog {

    @Id
    @GeneratedValue
    public Long id;

    private boolean isActive;

    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, targetEntity = Product.class)
    private List<Product> products;

    private String name;

    public Catalog() {
        this.isActive = false;
        this.products = new ArrayList<>();
        this.name = "";
    }

    public Catalog(boolean isActive, List<Product> products, String name) {
        this.isActive = isActive;
        this.products = products;
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Product i: products) {
            s.append("\t").append(i.toString()).append("\n");
        }
        return "Catalog( id: " + id + ", name: " + name + ", isActive: " + isActive + ", products: \n" + s + " )";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
