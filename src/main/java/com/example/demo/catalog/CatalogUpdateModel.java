package com.example.demo.catalog;

import java.util.List;

public class CatalogUpdateModel {

    String name;
    List<Long> productsIds;

    public CatalogUpdateModel(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getProductsIds() {
        return productsIds;
    }

    public void setProductsIds(List<Long> productsIds) {
        this.productsIds = productsIds;
    }
}
