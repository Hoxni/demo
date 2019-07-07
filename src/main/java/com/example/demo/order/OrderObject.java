package com.example.demo.order;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OrderObject {

    @Id
    @GeneratedValue
    public Long id;

    @Embedded
    private Client client;

    private int summaryPrice;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = OrderItem.class)
    private List<OrderItem> products;

    public OrderObject() {
        this.client = new Client();
        this.summaryPrice = 0;
        this.products = new ArrayList<>();
    }

    public OrderObject(Client client, int summaryPrice, List<OrderItem> products) {
        this.client = client;
        this.summaryPrice = summaryPrice;
        this.products = products;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (OrderItem i: products) {
            s.append(i.toString()).append(" ");
        }
        return id + " " + client.toString() + " " + summaryPrice + " " + s;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getSummaryPrice() {
        return summaryPrice;
    }

    public void setSummaryPrice(int summaryPrice) {
        this.summaryPrice = summaryPrice;
    }

    public List<OrderItem> getProducts() {
        return products;
    }

    public void setProducts(List<OrderItem> products) {
        this.products = products;
    }
}
