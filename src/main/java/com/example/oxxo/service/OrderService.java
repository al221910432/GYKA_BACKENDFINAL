package com.example.oxxo.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.oxxo.entity.Order;
import com.example.oxxo.model.request.CreateOrderRequest;
import com.example.oxxo.model.request.UpdateOrderRequest;

public interface OrderService extends JpaRepository<Order, Long> {
    
    void placeOrder(CreateOrderRequest request);

    List<Order> getList();
    
    List<Order> findByUserUsername(String username);

    void updateOrder(Long orderId, UpdateOrderRequest request);


}

