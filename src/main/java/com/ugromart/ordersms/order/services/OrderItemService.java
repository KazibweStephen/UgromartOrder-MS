package com.ugromart.ordersms.order.services;

import com.ugromart.ordersms.order.models.OrderItem;

import java.util.List;

public interface OrderItemService {
    OrderItem save(OrderItem orderItem);
    List<OrderItem> findAll();
}
