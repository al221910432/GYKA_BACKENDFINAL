package com.example.oxxo.service;

import java.util.List;

import com.example.oxxo.entity.Order;
import com.example.oxxo.model.request.CreateOrderRequest;
import com.example.oxxo.model.request.UpdateOrderRequest;

public interface OrderService {
    
    void placeOrder(CreateOrderRequest request);

    List<Order> getList();
    
    List<Order> getOrderByUser(String username);

    void updateOrder(Long orderId, UpdateOrderRequest request);


}
