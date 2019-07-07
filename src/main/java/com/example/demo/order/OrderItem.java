package com.example.demo.order;

import com.example.demo.product.Product;

import javax.persistence.*;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue
    public Long id;

    //@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Product.class)
    //private Product product;
    private String title;
    private String type;
    private int price;
    private int count;

    public OrderItem() {
        this.title = "";//. = product;
        this.type = "";
        this.price = 0;
        this.count = 0;
    }

    public OrderItem(Product product, int count) {
        this.title = product.getTitle();
        this.type = product.getType();
        this.price = product.getPrice();
        this.count = count;
    }

    @Override
    public String toString() {
        return id + " " + title + " " + type + " " + price + " " + count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
