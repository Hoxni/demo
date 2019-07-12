package com.example.demo.services;

import com.example.demo.order.OrderItem;
import com.example.demo.order.OrderObject;
import com.example.demo.product.Product;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;

    public void setProducts(OrderObject orderObject){
        for (OrderItem item: orderObject.getProducts()) {
            Optional<Product> optional = productRepository.findById(item.getProduct());
            optional.ifPresent(product -> {
                item.setTitle(product.getTitle());
                item.setType(product.getType());
                item.setPrice(product.getPrice());
            });
        }
    }

    public Iterable<OrderObject> getOrders(){
        return orderRepository.findAll();
    }

    public void save(OrderObject order){
        setProducts(order);
        orderRepository.save(order);
    }
}
