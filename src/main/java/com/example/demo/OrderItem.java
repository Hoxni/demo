package com.example.demo;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue
    public Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Product.class)
    private Product product;
    private int count;

    public OrderItem() {
        this.product = product;
        this.count = 0;
    }

    public OrderItem(Product product, int count) {
        this.product = product;
        this.count = count;
    }

    @Override
    public String toString() {
        return id + " " + product.toString() + " " + count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
