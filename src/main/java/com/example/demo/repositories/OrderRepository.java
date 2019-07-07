package com.example.demo.repositories;

import com.example.demo.order.OrderObject;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderObject, Long> {
}
