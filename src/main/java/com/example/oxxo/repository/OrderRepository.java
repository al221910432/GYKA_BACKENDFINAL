package com.example.oxxo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.oxxo.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    
    @Query(value ="Select * from orders where user_id = :id order by id desc",nativeQuery = true)
    List<Order> getOrderByUser(long id);
}
