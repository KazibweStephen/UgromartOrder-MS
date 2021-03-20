package com.ugromart.ordersms.order.services;

import com.ugromart.ordersms.order.models.Order;

import java.util.List;
import java.util.UUID;


public interface OrderService {
    Order save(Order order);
    Order findOrderById(UUID id);
    List<Order> findOrdersByUserId(long id);
    List<Order> findAll();
    void updateOrderStatus(UUID id, String status);
    void updateOrderStatusAndPaymentId(UUID id , String status, UUID paymentReferenceId);
}
