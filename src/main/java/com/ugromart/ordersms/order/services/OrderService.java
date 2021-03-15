package com.ugromart.ordersms.order.services;

import com.ugromart.ordersms.order.models.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface OrderService {
    Order save(Order order);
    Order findOrderById(long id);
    List<Order> findOrdersByUserId(long id);
    List<Order> findAll();
    void updateOrderStatus(long id, String status);
}
