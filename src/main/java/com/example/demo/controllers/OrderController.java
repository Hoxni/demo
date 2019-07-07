package com.example.demo.controllers;

import com.example.demo.order.OrderObject;
import com.example.demo.repositories.OrderRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/orders")
    public Iterable<OrderObject> getOrders(){
        orderRepository.findAll().forEach(System.out::println);
        return orderRepository.findAll();
    }

    @PostMapping("/orders")
    public void addOrder(@RequestBody OrderObject order){
        orderRepository.save(order);
    }
}
