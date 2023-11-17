package com.example.oxxo.service.impl;

import java.util.List;

import com.example.oxxo.model.request.UpdateOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.oxxo.entity.Order;
import com.example.oxxo.entity.OrderDetail;
import com.example.oxxo.entity.User;
import com.example.oxxo.exception.NotFoundException;
import com.example.oxxo.model.request.CreateOrderDetailRequest;
import com.example.oxxo.model.request.CreateOrderRequest;
import com.example.oxxo.repository.OrderDetailRepository;
import com.example.oxxo.repository.OrderRepository;
import com.example.oxxo.repository.UserRepository;
import com.example.oxxo.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
    
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void placeOrder(CreateOrderRequest request) {
        // TODO Auto-generated method stub
        Order order = new Order();
        User user = userRepository.findByUsername(request.getUsername()).orElseThrow(() -> new NotFoundException("Not Found User With Username:" + request.getUsername()));
        order.setFirstname(request.getFirstname());
        order.setLastname(request.getLastname());
        order.setCountry(request.getCountry());
        order.setAddress(request.getAddress());
        order.setTown(request.getTown());
        order.setState(request.getState());
        order.setPostCode(request.getPostCode());
        order.setEmail(request.getEmail());
        order.setPhone(request.getPhone());
        order.setNote(request.getNote());   
        orderRepository.save(order);
        long totalPrice = 0;
        for(CreateOrderDetailRequest rq: request.getOrderDetails()){
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setName(rq.getName());
            orderDetail.setPrice(rq.getPrice());
            orderDetail.setQuantity(rq.getQuantity());
            orderDetail.setSubTotal(rq.getPrice()* rq.getQuantity());
            orderDetail.setOrder(order);
            totalPrice += orderDetail.getSubTotal();
            orderDetailRepository.save(orderDetail);
            
        }
        order.setTotalPrice(totalPrice);
        order.setUser(user);
        orderRepository.save(order);
    }

    @Override
    public List<Order> getList() {
        return orderRepository.findAll(Sort.by("id").descending());
    }

    @Override
    public List<Order> getOrderByUser(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new NotFoundException("Not Found User With Username:" + username));

        List<Order> orders = orderRepository.getOrderByUser(user.getId());
        return orders;  
    }

    @Override
    public void updateOrder(Long orderId, UpdateOrderRequest request) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new NotFoundException("Order not found with ID: " + orderId));

        if (request.getFirstname() != null) {
            order.setFirstname(request.getFirstname());
        }

        if (request.getLastname() != null) {
            order.setLastname(request.getLastname());
        }

        if (request.getCountry() != null) {
            order.setCountry(request.getCountry());
        }

        if (request.getAddress() != null) {
            order.setAddress(request.getAddress());
        }

        if (request.getTown() != null) {
            order.setTown(request.getTown());
        }

        if (request.getState() != null) {
            order.setState(request.getState());
        }

        if (request.getPostCode() != null) {
            order.setPostCode(request.getPostCode());
        }

        if (request.getEmail() != null) {
            order.setEmail(request.getEmail());
        }

        if (request.getPhone() != null) {
            order.setPhone(request.getPhone());
        }

        if (request.getNote() != null) {
            order.setNote(request.getNote());
        }

        if (request.getStatus() != null) {
            order.setStatus(request.getStatus());
        }

        if (request.getDiaentrega() != null) {
            order.setDiaentrega(request.getDiaentrega());
        }

        if(request.getDiapedido() !=null) {
            order.setDiapedido(request.getDiapedido());
        }

        if(request.getDiapago() !=null) {
            order.setDiapago(request.getDiapago());
        }

        if(request.getDiaenvio() !=null) {
            order.setDiaenvio(request.getDiaenvio());
        }

        if(request.getSeguimiento() !=null) {
            order.setSeguimiento(request.getSeguimiento());
        }

        orderRepository.save(order);
    }


}
