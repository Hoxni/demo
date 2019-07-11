package com.example.demo.order;

import com.example.demo.product.Product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue
    public Long id;

    private Long product;
    private String title;
    private String type;
    private int price;
    private int count;

    public OrderItem() {
        this.title = "";//. = product;
        this.type = "";
        this.price = 0;
        this.count = 0;
        //this.productRepository = null;
        System.out.println("Zero orderItem constructor");
    }

    public OrderItem(Product product, int count) {
        this.product = product.getId();
        this.title = product.getTitle();
        this.type = product.getType();
        this.price = product.getPrice();
        this.count = count;
        System.out.println("First constructor: " + toString());
    }

    @Override
    public String toString() {
        return "OrderItem id: " + id + " productId: " + product + " title: " + title + " type: " + type + " price: " + price + " count: " + count;
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

    public Long getProduct() {
        return product;
    }

    public void setProduct(Long product) {
        this.product = product;
    }
}
