package com.example.demo.repositories;

import com.example.demo.order.OrderObject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<OrderObject, Long> {
}
