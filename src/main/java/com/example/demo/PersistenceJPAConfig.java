package com.example.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.example" })
public class PersistenceJPAConfig {

    /*@Bean
    public ProductService getProductRepositoryImpl(){
        return new ProductService();
    }

    @Bean
    public OrderItem orderItem(){
        OrderItem orderItem = new OrderItem();
        orderItem.setProductRepository(getProductRepositoryImpl().getProductRepository());
        return orderItem;
    }*/
}
