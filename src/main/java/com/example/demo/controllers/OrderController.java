package com.example.demo.controllers;

import com.example.demo.order.OrderItem;
import com.example.demo.order.OrderObject;
import com.example.demo.product.Product;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class OrderController {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderController(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @GetMapping("/orders")
    public Iterable<OrderObject> getOrders() {
        orderRepository.findAll().forEach(System.out::println);
        return orderRepository.findAll();
    }

    @PostMapping("/orders")
    public void addOrder(@RequestBody OrderObject order){
        for (OrderItem o: order.getProducts()) {
            Product product = productRepository.findById(o.getProduct()).get();
            o.setPrice(product.getPrice());
            o.setTitle(product.getTitle());
            o.setType(product.getType());
        }
        orderRepository.save(order);
    }
}
