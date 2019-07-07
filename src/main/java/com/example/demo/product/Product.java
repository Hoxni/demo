package com.example.demo.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue
    public Long id;

    private String title;
    private String type;
    private int price;

    public Product() {
        this.title = "";
        this.type = "";
        this.price = 0;
    }

    public Product(String title, String type, int price) {
        this.title = title;
        this.type = type;
        this.price = price;
    }

    @Override
    public String toString() {
        return id + " " + title + " " + type + " " + price;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
