package com.example.demo;

import com.example.demo.catalog.Catalog;
import com.example.demo.order.Client;
import com.example.demo.order.OrderItem;
import com.example.demo.order.OrderObject;
import com.example.demo.product.Product;
import com.example.demo.repositories.CatalogRepository;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collections;
import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner init(OrderRepository orderRepository, ProductRepository productRepository, CatalogRepository catalogRepository) {
        return args -> {
            Client client = new Client("client@mail", "client");
            Product product = new Product("product", "phone", 1);
            OrderItem orderItem = new OrderItem(product, 1);
            OrderObject order = new OrderObject(client, 1, Collections.singletonList(orderItem));

            productRepository.save(product);
            productRepository.findAll().forEach(System.out::println);
            orderRepository.save(order);
            orderRepository.findAll().forEach(System.out::println);
            Catalog catalog = new Catalog(true, Collections.singletonList(product), "catalog");
            catalogRepository.save(catalog);
        };
    }
}
