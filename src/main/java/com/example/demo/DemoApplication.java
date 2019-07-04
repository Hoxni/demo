package com.example.demo;

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
    CommandLineRunner init(OrderRepository orderRepository) {
        return args -> {
            Stream.of("1", "2", "3", "4", "5").forEach(name -> {
                Client client = new Client(name, name);
                Product product = new Product(name, name, 1);
                OrderItem orderItem = new OrderItem(product, 1);
                OrderObject order = new OrderObject(client, 1, Collections.singletonList(orderItem));
                orderRepository.save(order);
            });
            orderRepository.findAll().forEach(System.out::println);
        };
    }
}
