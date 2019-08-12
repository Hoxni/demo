package com.example.demo.controllers;

import com.example.demo.order.OrderObject;
import com.example.demo.services.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public Iterable<OrderObject> getOrders() {
        orderService.getOrders().forEach(System.out::println);
        return orderService.getOrders();
    }

    @PostMapping("/orders")
    public void addOrder(@RequestBody OrderObject order){
        orderService.save(order);
    }
}
