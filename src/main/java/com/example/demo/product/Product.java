package com.example.demo.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getPrice() == product.getPrice() &&
                Objects.equals(getTitle(), product.getTitle()) &&
                Objects.equals(getType(), product.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getType(), getPrice());
    }

    @Override
    public String toString() {
        return "Product( id: " + id + ", title: " + title + ", type: " + type + ", price: " + price + " )";
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
